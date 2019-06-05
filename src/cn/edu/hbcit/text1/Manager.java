package cn.edu.hbcit.text1;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    public static void main(String[] args) {
        ArrayList<Student> stuArr = new ArrayList<>();
        Student stu1 = new Student("30001", "张三", "21", '男', 78, 81, 90);
        Student stu2 = new Student("30002", "李四", "21", '男', 88, 91, 91);
        Student stu3 = new Student("30003", "王五", "20", '男', 85, 91, 90);
        Student stu4 = new Student("30004", "赵六", "21", '女', 55, 70, 45);
        Student stu5 = new Student("30005", "蒋七", "19", '女', 68, 83, 76);
        stuArr.add(stu1);
        stuArr.add(stu2);
        stuArr.add(stu3);
        stuArr.add(stu4);
        stuArr.add(stu5);
        welcome(stuArr);
    }

    private static void selectAll(ArrayList<Student> tempArr) {
        for (Student s :tempArr) {
            System.out.println("学号："+s.getNum()+"   姓名："+s.getName()+"  性别："+s.getSex()+"   Java成绩："+s.getJava()+"  SQL成绩"+s.getSql()+"    C语言成绩"+s.getC());
        }
        ifExit();
    }
    private static void calScore(ArrayList<Student> tempArr){
        int all=0;
        for (Student s : tempArr){
            var sum = s.getC()+s.getJava()+s.getSql();
            all += sum;
        }
        System.out.println("总分"+all+"   平均分"+all/tempArr.size());
        ifExit();
    }
    private static void selName(ArrayList<Student> tempArr){
        System.out.println("请您输入你要查询的学生的姓名");
        Scanner sc= new Scanner(System.in);
        String inputStr = sc.nextLine();
        for (Student s : tempArr){
            if (inputStr.equals(s.getName())){
                System.out.println(s.getName()+"    Java："+s.getJava()+"    SQL："+s.getSql()+"    C语言:"+s.getC());
            }else {
                System.out.println("查无此人");
                break;
            }
        }
        ifExit();
    }
    private static void selFail(ArrayList<Student> tempArr){
        for (Student s : tempArr){
            if (s.getC()<60||s.getSql()<60||s.getJava()<60){
                System.out.println("学号："+s.getNum()+"   姓名："+s.getName()+"  性别："+s.getSex()+"   Java成绩："+s.getJava()+"  SQL成绩"+s.getSql()+"    C语言成绩"+s.getC());
            }
        }
        ifExit();
    }
    private static void ifExit(){
        System.out.println("您是否想要继续使用，输入1即为退出，输入2继续使用");
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        if (temp.equals("1")){
            System.exit(0);
        }
    }
    private static void welcome(ArrayList <Student> tempArr){
        while (true){
            System.out.println("欢迎使用学生成绩管理系统!");
            System.out.println("1. 显示所有学生的信息");
            System.out.println("2. 计算总分和平均分");
            System.out.println("3. 按姓名查询学生信息");
            System.out.println("4. 统计不合格学生");
            System.out.println("5. 退出系统");
            System.out.println("请你输入你要执行的功能，输入1，2，3，4，5来启动");
            Scanner sc=  new Scanner(System.in);
            String stuFunction = sc.nextLine();
            switch (stuFunction){
                case "1" : selectAll(tempArr);
                    break;
                case "2" : calScore(tempArr);
                    break;
                case "3" : selName(tempArr);
                    break;
                case "4" : selFail(tempArr);
                    break;
                case "5" : ifExit();
            }
        }
    }
}