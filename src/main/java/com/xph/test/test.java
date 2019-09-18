package com.xph.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class test {

    @Test
    public void test2(){
//        String path = "E:\\视频\\最新2019年传智黑马java完整视频idea版本\\阶段3 1.Mybatis\\01.Mybatis课程介绍及环境搭建";
        String path1 = "E:\\视频\\最新2019年传智黑马java完整视频idea版本\\阶段3 1.Mybatis\\01.Mybatis课程介绍及环境搭建\\07.环境搭建的注意事项.flv";
        File file = new File(path1);
//        System.out.println(file.listFiles().length);
//        Encoder encoder =
        System.out.println(Integer.MAX_VALUE);

    }

    @Test
    public void test1(){
        ObjectMapper objectMapper = new ObjectMapper();
    }

    @Test
    public void list(){
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2,3);
        System.out.println(list.toString());
        System.out.println(list.get(1));
    }
}
