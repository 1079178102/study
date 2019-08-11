package com.xph.demo.JDBC;

import java.sql.*;

/**
 * 查询 select 语句
 */
public class JdbcDemo4 {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs =null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            String sql = "select * from student";
            //3.获取Connection对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study","root","root");
            //4.获取执行sql的对象Statement
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.处理结果
            //循环判断游标是否是最后一行末尾
            while (rs.next()){
                int id = rs.getInt(1);//int id1 = rs.getInt("id"); 一个意思
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                System.out.println(id+" "+name+" "+phone);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //7.释放资源
            //避免空指针异常
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
