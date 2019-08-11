package com.xph.demo.JDBC;

import com.xph.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtilsTest {
    public static void main(String[] args) {
        Statement stmt = null;
        Connection conn = null;
        ResultSet rs =null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from student";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                System.out.println(id+" "+name+" "+phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
    }
}
