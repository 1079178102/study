package com.xph.demo.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;

/**
 * Document/Element对象功能
 * resources/jsoup.xml
 */
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        InputStream is = JsoupDemo1.class.getClassLoader().getResourceAsStream("jsoup.xml");
        Document document = Jsoup.parse(is,"utf-8","");

        //3.获取元素对象
        //3.1获取所有student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);

        System.out.println("------------");

        //3.2获取属性名为id的元素对象们
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);

        System.out.println("------------");

        //3.3 获取uid为01的元素对象
        Elements elements2 = document.getElementsByAttributeValue("uid", "01");
        System.out.println(elements2);

        System.out.println("------------");
        
        //3.4 获取id属性值的元素对象
        Element id = document.getElementById("xph");
        System.out.println(id);
    }
}
