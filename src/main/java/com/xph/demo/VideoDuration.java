package com.xph.demo;

/**
 *  到目前（2019-9-2 23:15:47）jave包在maven中是没有的，所以要自己下载：http://www.sauronsoftware.it/projects/jave/download.php
 *  在maven项目中导入本地jar包方法：https://www.jb51.net/article/152632.htm  //要注意：指令格式的参数之间是要空格的
 */
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

/**
 * 计算一个文件夹下所有视频的总时长
 */
public class VideoDuration {
    private int InputFormatExceptionCount = 0 ;

    /*
        it.sauronsoftware.jave.InputFormatException
            at it.sauronsoftware.jave.Encoder.parseMultimediaInfo(Encoder.java:659)
            at it.sauronsoftware.jave.Encoder.getInfo(Encoder.java:487)
            at com.xph.demo.VideoDuration.getVideoDuration(VideoDuration.java:75)
            at com.xph.demo.VideoDuration.getVideosDuration(VideoDuration.java:58)
            at com.xph.demo.VideoDuration.getVideosDuration(VideoDuration.java:56)
            at com.xph.demo.VideoDuration.main(VideoDuration.java:22)
        在程序运行时会报这个异常，我目前未找到时什么原因造成的
        报异常的视频时长以0秒计算
     */
    public static void main(String[] args) {
        String path = "F:\\视频\\最新2019年传智黑马java完整视频idea版本\\阶段3 1.Mybatis";
        VideoDuration vD = new VideoDuration();
        File file = new File(path);
        long videoDurations = vD.getVideosDuration(file);

        System.out.println(vD.timeConversion(videoDurations));
        System.out.println("共"+ vD.InputFormatExceptionCount + "个报错");
    }

    /**
     * 将毫秒级时间转为小时级时间
     * @param millisecond
     * @return
     */
    public String timeConversion(long millisecond){
        long second = millisecond / 1000;
        long hour = second / 3600;
        long minute = second % 3600 / 60;
        second %= 60;
        return hour + "小时" + minute + "分" + second + "秒";
    }

    /**
     * 计算文件夹下所有视频的总时长
     * @param file
     * @return
     */
    public long getVideosDuration(File file) {
        long duration = 0;
        for (File f:file.listFiles()) {
            if (f.isDirectory()) {
                duration += getVideosDuration(f);
            } else {
                duration += getVideoDuration(f);
            }
        }
        return duration;
    }

    /**
     * 获取指定视频的时长
     * @param file
     * @return 毫米级时长
     */
    public long getVideoDuration(File file) {
        if (file == null) return 0;
        long duration = 0;
        Encoder encoder = new Encoder();
        try {
            MultimediaInfo m = encoder.getInfo(file);
            duration = m.getDuration();
        } catch (EncoderException e) {
            InputFormatExceptionCount++;
            System.out.println("此处有异常:["+file.getPath()+"]");
            e.printStackTrace();
        }
        return duration;
    }

}
