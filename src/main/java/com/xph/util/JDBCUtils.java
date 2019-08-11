package com.xph.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driverClass;
    /**
     * 文件的读取只需要读取一次即可拿到这些值。使用静态代码块
     */
    static {
        //读取资源文件，获取值
        try {
            //1.创建Properties集合类
            Properties pro = new Properties();
            //读取resource目录下的文件
            InputStream in = JDBCUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            //2.加载文件
            pro.load(in);
            //3.获取数据，赋值
            url  = pro.getProperty("jdbc.jdbcUrl");
            user  = pro.getProperty("jdbc.user");
            password  = pro.getProperty("jdbc.password");
            driverClass = pro.getProperty("jdbc.driverClass");
            //4.注册驱动
            Class.forName(driverClass);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt,Connection conn){
        if ( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if ( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if ( rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if ( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if ( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
