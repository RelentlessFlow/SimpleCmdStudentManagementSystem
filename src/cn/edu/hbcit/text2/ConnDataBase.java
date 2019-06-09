package cn.edu.hbcit.text2;

import java.sql.*;
import java.util.Scanner;

public class ConnDataBase {
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/stuManager?useUnicode=true&characterEncoding=utf8&useSSL=true";
    // 数据库的用户名与密码，需要根据自己的设置
    private static final String USER = "root";
    private static final String PASS = "123456";

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

            //加载createStatement
            Statement smt = conn.createStatement();
            createTable(smt);

//            selSumAvg(smt);

            welcome(smt,conn);
            smt.close();
            conn.close();


        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }
    private static void welcome(Statement smt,Connection conn) {
        while (true) {
            System.out.println("欢迎使用学生成绩管理系统!");
            System.out.println("1. 显示所有学生的信息");
            System.out.println("2. 计算总分和平均分");
            System.out.println("3. 按姓名查询学生信息");
            System.out.println("4. 统计不合格学生");
            System.out.println("5. 退出系统");
            System.out.println("请你输入你要执行的功能，输入1，2，3，4，5来启动");
            Scanner sc = new Scanner(System.in);
            String stuFunction = sc.nextLine();
            switch (stuFunction) {
                case "1":
                    selAll(smt);
                    break;
                case "2":
                    System.out.println("功能未实现");
                    break;
                case "3":
                    selName(conn);
                    break;
                case "4":
                    selFail(smt);
                    break;
                case "5":
                    ifExit();
            }
        }
    }
    private static void createTable(Statement smt){
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
        try {
            int i = smt.executeUpdate(createTable);
            if ( i ==  0){
                System.out.println("表已经创建成功了");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    private static void selAll(Statement smt){
        String insertStu = "INSERT INTO student\n" +
                "VALUES ('3001', '张三', '2000-05-11', '男', '81', '100', '80'),\n" +
                "       ('3002', '李四', '1998-08-07', '男', '100', '80', '99'),\n" +
                "       ('3003', '王五', '2001-01-08', '男', '90', '77', '60'),\n" +
                "       ('3004', '赵六', '1997-02-09', '女', '50', '80', '100'),\n" +
                "       ('3005', '刘七', '1998-10-02', ' 女', '88', '40', '67');";
        try {
            smt.executeUpdate(insertStu);
            System.out.print("数据已经插入成功了");
            String selectAll = "SELECT * FROM student;";

            ResultSet rs1 = smt.executeQuery(selectAll);
            while (rs1.next()){
                String id = rs1.getString(1);
                String name = rs1.getString(2);
                String age = rs1.getString(3);
                String sex = rs1.getString(4);
                String javascore = rs1.getString(5);
                String sqlscore = rs1.getString(6);
                String cscore = rs1.getString(7);
                System.out.println("");
                System.out.println(name+"    "+age+"     "+sex+"     "+javascore+"     "+sqlscore+"     "+cscore);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static void selSumAvg(Statement smt){
        String selSum = "SELECT sum(javascore+sqlscore+cscore) AS '总分' FROM student;";
        String selAvg = "SELECT avg(javascore+sqlscore+cscore) AS '平均分' FROM student;";
        try {
            ResultSet sumRes = smt.executeQuery(selSum);
            ResultSet avgRes = smt.executeQuery(selAvg);
            while (sumRes.next()){
                String sum = sumRes.getString(1);
                System.out.println(sum);
            }
            while (avgRes.next()){
                String avg = sumRes.getString(1);
                System.out.println(avg);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static void selName(Connection conn){
        System.out.println("请您输入要查询的学生的姓名");
        Scanner sc = new Scanner(System.in);
        String inputName = sc.nextLine();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM student WHERE sname LIKE ?;");
            ps.setString(1,inputName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(
                        "   学号"+ rs.getString(1)+"  姓名"+ rs.getString(2)+"  出生日期"+
                        rs.getString(3)+"   性别"+ rs.getString(4)+"  Java："+
                        rs.getString(5)+"   MySQL："+ rs.getString(6)+"  C语言："+
                        rs.getString(7));
            }
            rs.last();
            if (rs.getRow()==0){
                System.out.println("数据库里没有这位学生的信息");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static void selFail(Statement smt){
        String sqlFail = "SELECT * FROM student WHERE javascore<60 OR sqlscore<60 OR cscore<60;";
        try {
            System.out.println("成绩中有不及格的学生的信息");
            ResultSet rs1 = smt.executeQuery(sqlFail);
            while (rs1.next()){
                String id = rs1.getString(1);
                String name = rs1.getString(2);
                String age = rs1.getString(3);
                String sex = rs1.getString(4);
                String javascore = rs1.getString(5);
                String sqlscore = rs1.getString(6);
                String cscore = rs1.getString(7);
                System.out.println("");
                System.out.println(name+"    "+age+"     "+sex+"     "+javascore+"     "+sqlscore+"     "+cscore);
            }
            rs1.last();
            if (rs1.getRow()==0){
                System.out.println("没有成绩不合格的学生的信息");
            }else {
                System.out.println("数据如上");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static void ifExit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("您是否想要继续使用?  输入“2”退出使用，输入其他任意键继续使用");
        String inputValue = sc.nextLine();
        if (inputValue.equals("2")){
            System.exit(0);
        }
    }
}