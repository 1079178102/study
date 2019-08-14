package com.xph.demo.JDBCTemplate;

import com.xph.util.JDBCUtilsDruid;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JDBCTemplate入门
 */
public class JDBCTemplateDemo1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtilsDruid.getDataSource());
        //3.调用方法
        String sql = "update student set name = '徐鹏辉1' where id = ?";
        int count = template.update(sql, 2);
        System.out.println(count);
    }
}
