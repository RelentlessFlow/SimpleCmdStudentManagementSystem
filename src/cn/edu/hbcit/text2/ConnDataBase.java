package cn.edu.hbcit.text2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDataBase {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3308/stuManager?useUnicode=true&characterEncoding=utf8&useSSL=true";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("数据库连接成功");
            //实例化Statement对象准备加载SQL语句
            System.out.println("实例化Statement对象");
            String createTable = "";
            createTable = "CREATE TABLE student\n" +
                    "(\n" +
                    "    sid       VARCHAR(30) NOT NULL,\n" +
                    "    sname     VARCHAR(10) NOT NULL,\n" +
                    "    sage      DATE        NOT NULL,\n" +
                    "    ssex      VARCHAR(5)  NOT NULL,\n" +
                    "    javascore FLOAT       NOT NULL,\n" +
                    "    sqlscore  FLOAT       NOT NULL,\n" +
                    "    cscore    FLOAT       NOT NULL\n" +
                    ");";
            //加载SQL语句创建表
            Statement smt = conn.createStatement();
            int i = smt.executeUpdate(createTable);
            if ( i ==  0){
                System.out.println("表已经创建成功了");
            }
            String insertStu = "";


        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
}