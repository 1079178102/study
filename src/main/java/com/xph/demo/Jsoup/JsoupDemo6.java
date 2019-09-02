package com.xph.demo.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;

/**
 * 选择器查询
 * resources/jsoup.xml
 */
public class JsoupDemo6 {
    public static void main(String[] args) throws IOException {
        InputStream is = JsoupDemo1.class.getClassLoader().getResourceAsStream("jsoup.xml");
        Document document = Jsoup.parse(is,"utf-8","");

        //查询student中uid为01的name标签
        Elements name = document.select("student[uid='01'] name");
        System.out.println(name);

        System.out.println("------------");

        Elements select = document.select("#xph");
        System.out.println(select);

        System.out.println("------------");

        Elements select1 = document.select("#xph>xing");
        Elements select2 = document.select("#xph xing");
        System.out.println(select1);
        System.out.println(select2);

        System.out.println("------------");
    }
}
