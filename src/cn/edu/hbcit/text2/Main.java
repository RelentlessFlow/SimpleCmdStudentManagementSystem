package cn.edu.hbcit.text2;

import java.sql.*;

public class Main {
    static final String JBBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3308/mysql?useUnicode=true&characterEncoding=utf8&useSSL=true";
    static final String USER = "root";
    static final String PASS = "123456";
    public static void main(String[] args) {
        Connection conn =  null;
        Statement stmt = null;
        try {
            Class.forName(JBBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("连接数据库成功");
            stmt = conn.createStatement();
            String createDB = "CREATE DATABASE student_manager;";
            stmt.execute(createDB);
            System.out.println("数据库已经创建成功");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
