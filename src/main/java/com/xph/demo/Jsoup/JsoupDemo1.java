package com.xph.demo.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Jsoup快速入门
 * resources/jsoup.xml
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //2.获取document对象，根据xml文档获取
        //2.1获取jsoup.xml的InputStream
        InputStream is = JsoupDemo1.class.getClassLoader().getResourceAsStream("jsoup.xml");
        //2.2解析xml文档，加载文档进内存，获取dom树--》document
        Document document = Jsoup.parse(is,"utf-8","");
        //3.获取元素对象elements
        Elements elements = document.getElementsByTag("name");
        //3.1获取数据
        elements.forEach(element-> System.out.println(element));
        System.out.println();
        elements.forEach(element-> System.out.println(element.text()));
    }
}
