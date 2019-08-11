package com.xph.demo;

import org.springframework.stereotype.Controller;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
public class CheckCodeServlet {
    /*
        生成验证码图片
     */
    @RequestMapping("/checkCodeServlet")
    public void checkCodeServlet(HttpServletResponse res) throws IOException {
        int width=100,hight=50;
        //1.创建一对象，在内存中图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width,hight,BufferedImage.TYPE_3BYTE_BGR);
//        System.out.println(image);
        //2.美化图片
        //2.1 填充背景颜色
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0,0,width,hight);

        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,hight-1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        //生成随机下标
        Random ran = new Random();
        for (int i= 1 ;i <=4 ; i++){
            int index = ran.nextInt(str.length());//随机字符
            //获取字符
            char ch = str.charAt(index);
            //2.3写验证码
            g.drawString(ch+"",width / 5 * i,hight/2);
        }

        //2.4画干扰线
        g.setColor(Color.GREEN);
        //2.4.1随机生成坐标点
        for(int i = 0;i<10;i++){
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(hight);
            int y2 = ran.nextInt(hight);
            g.drawLine(x1,y1,x2,y2);
        }
        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",res.getOutputStream());
    }

}
