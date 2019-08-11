package com.xph.demo;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();//集合
        FileInputStream fis = new FileInputStream("Properties.properties");//获取文件的字节流
        InputStreamReader isr = new InputStreamReader(fis,"GBK");//将字节流转换为指定的字符流
        prop.load(isr);//加载流中的数据
        for (String key : prop.stringPropertyNames()){
            System.out.println("key:"+key+" val:"+prop.getProperty(key));//以keg:val形式遍历输出数据
        }
        isr.close();
    }
}