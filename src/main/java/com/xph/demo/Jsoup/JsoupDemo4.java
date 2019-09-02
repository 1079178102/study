package com.xph.demo.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;

/**
 * Element对象功能
 * resources/jsoup.xml
 */
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        InputStream is = JsoupDemo1.class.getClassLoader().getResourceAsStream("jsoup.xml");
        Document document = Jsoup.parse(is,"utf-8","");

        //通过 Document 对象获取name，获取所有的name标签
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        System.out.println("------------");
        //通过 Element 对象获取子标签的对象
        Element element_student = document.getElementsByTag("student").get(0);
        Elements ele_name = element_student.getElementsByTag("name");
        System.out.println(ele_name.size());

        System.out.println("------------");

        //获取 student 对象的属性值（不区分大小写）
        String uid = element_student.attr("uid");
        String UID = element_student.attr("UID");
        System.out.println(uid + " : " +UID + " : "+uid.equals(UID));

        System.out.println("------------");

        //获取文本内容
        String text = ele_name.text();
        String html = ele_name.html();
        System.out.println(text);
        System.out.println(html);
    }
}
