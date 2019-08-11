package com.xph.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test {
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
