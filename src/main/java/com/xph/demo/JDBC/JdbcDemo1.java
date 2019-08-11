package com.xph.demo.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC快速入门
 *
 * 数据库study
 * 数据表student
 * 结构：id int 主键
 *       name varchar(255)
 *       phone varchar(11)
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study","root","root");
        //4.定义sql语句
        String sql = "update student set name='whh1' where id = 2";//中文会乱码
        //5.获取执行sql的对象Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();
    }
}
