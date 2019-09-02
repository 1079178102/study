package com.xph.demo;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

/**
 * 计算一个文件夹下所有视频的总时长
 *
 * 到目前（2019-9-2 23:15:47）jave包在maven中是没有的，所以要自己下载：http://www.sauronsoftware.it/projects/jave/download.php
 * 在maven项目中导入本地jar包方法：https://www.jb51.net/article/152632.htm  //要注意：指令格式的参数之间是要空格的
 *
 */
public class VideoDuration {

    public static void main(String[] args) {
        String path = "E:\\视频\\最新2019年传智黑马java完整视频idea版本\\阶段3 1.Mybatis";
        VideoDuration vD = new VideoDuration();
        File file = new File(path);
        long videoDurations = vD.getVideosDuration(file);
        System.out.println(videoDurations);

//        VideoDuration vD = new VideoDuration();
//        String path = "E:\\视频\\最新2019年传智黑马java完整视频idea版本\\阶段3 1.Mybatis\\04.自定义Mybatis框架基于注解开发\\2 回顾自定义mybatis的流程分析.flv";
//        File file = new File(path);
//        System.out.println(vD.getVideoDuration(file));

    }

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
    private long getVideoDuration(File file) {
        if (file == null) return 0;
        System.out.println(file.getName());
        long duration = 0;
        Encoder encoder = new Encoder();
        try {
            MultimediaInfo m = encoder.getInfo(file);
            duration = m.getDuration();
        } catch (EncoderException e) {
            e.printStackTrace();
        }
        return duration;
    }


//    /**
//     * 获取指定视频的时长
//     * @param filePath
//     * @return 毫米级时长
//     */
//    public long getVideoDuration(String filePath){
//        long duration = 0;
//        File file = new File(filePath);
//        Encoder encoder = new Encoder();
//        try {
//            MultimediaInfo m = encoder.getInfo(file);
//            duration = m.getDuration();
//        } catch (EncoderException e) {
//            e.printStackTrace();
//        }finally {
//            return duration;
//        }
//    }
}
