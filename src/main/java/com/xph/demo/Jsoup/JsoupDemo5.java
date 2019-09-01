package com.xph.demo.Jsoup;

import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.lang.model.util.Elements;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *Xpath查询
 * resources/jsoup.xml
 */
public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        InputStream is = JsoupDemo1.class.getClassLoader().getResourceAsStream("jsoup.xml");
        Document document = Jsoup.parse(is,"utf-8","");

        //1.根据 document 对象，创建 JXDocument对象
        JXDocument jxDocument = new JXDocument(document);

        //2.结合xpat语法查询
        //2.1 查询所有的studnent标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        jxNodes.forEach(i-> System.out.println(i + "\n"));

        System.out.println("------------");

        //2.2 查询所有sutdent下的name标签
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        jxNodes1.forEach(i-> System.out.println(i + "\n"));

        System.out.println("------------");

        //2.3 查询studnet标签下带有id属性的name标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id]");
        jxNodes2.forEach(i-> System.out.println(i + "\n"));

        System.out.println("------------");

        //2.4 查询studnet标签下带有id属性的name标签并且id属性值为xph
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id='xph']");
        jxNodes3.forEach(i-> System.out.println(i + "\n"));
    }
}
