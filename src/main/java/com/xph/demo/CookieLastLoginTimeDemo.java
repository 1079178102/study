package com.xph.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CookieLastLoginTimeDemo {
    /*使用cookie记录最后一次登录时间*/


    //删除cookie，调试用
    @RequestMapping("/delteLastLoginTime")
    public void delteLastLoginTime(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        Cookie cookie = new Cookie("lastDate", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.getWriter().write("<h1>删除成功</h1>");
    }

    @RequestMapping("/CookieLastLoginTime")
    public void CookieLastLoginDemo(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=UTF-8");

        //1.获取所有Cookie
        Cookie[] cookies = request.getCookies();
        //2.遍历Cookie数组
        Boolean flag = false;
        if (cookies != null){
            for (Cookie cookie : cookies){
                if("lastDate".equals(cookie.getName())){
                    flag = true;
                    String lastDate = cookie.getValue();

                    //因为lastDate中存的是编码后的数据所以要用URL解码
                    lastDate = URLDecoder.decode(lastDate,"utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为"+lastDate+"</h1>");
                    break;
                }
            }
        }
        //3.判断是否首次来访
        if (flag == false){response.getWriter().write("<h1>您好,欢迎您首次访问</h1>");}

        //4.不论是否首次访问，都得记录本次登录时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);

        //cookie的值中不能有特殊字符（如空格）,若想加则需要使用URL编码
        str_date = URLEncoder.encode(str_date,"utf-8");

        Cookie cookie = new Cookie("lastDate",str_date);
        cookie.setMaxAge(60*60*20*30);//一个月
        response.addCookie(cookie);//若之前有lastDate会被覆盖
    }
}
