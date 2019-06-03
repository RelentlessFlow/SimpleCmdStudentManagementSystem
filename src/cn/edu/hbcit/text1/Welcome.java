package cn.edu.hbcit.text1;

import java.util.Scanner;

public class Welcome {
    void display(){
        System.out.println("欢迎使用学生成绩管理系统!");
        System.out.println("1. 显示所有学生的信息");
        System.out.println("2. 计算总分和平均分");
        System.out.println("3. 按姓名查询学生信息");
        System.out.println("4. 统计不合格学生");
        System.out.println("5. 退出系统");
    }
    void setControl(){
        System.out.println("请你输入你要执行的功能，输入1，2，3，4，5来启动");
        Scanner sc=  new Scanner(System.in);
        String stuFunction = sc.nextLine();
        switch (stuFunction){
            case "1":
                
        }
    }
}
