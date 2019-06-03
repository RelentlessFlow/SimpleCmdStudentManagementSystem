package cn.edu.hbcit.text1;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList <Student> arr = new ArrayList<Student>();
        Student s1 = new Student("30001","张三","21",'男',78,81,90);
        Student s2 = new Student("30002","李四","21",'男',88,91,91);
        Student s3 = new Student("30003","王五","20",'男',85,91,90);
        Student s4 = new Student("30004","赵六","21",'女',55,70,45);
        Student s5 = new Student("30005","蒋七","19",'女',68,83,76);
        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        arr.add(s4);
        arr.add(s5);
        System.out.println("欢迎使用学生成绩管理系统");
        System.out.println("1. 显示所有学生的信息");
        System.out.println("2. 计算总分和平均分");
        System.out.println("3. 按姓名查询学生信息");
        System.out.println("4. 统计不合格学生");
        System.out.println("5. 5. 退出系统");
        System.out.println("请你输入你要执行的功能，输入1，2，3，4，5来启动");
        Scanner sc = new Scanner(System.in);
        String inputCase =  sc.nextLine();
    }
    void dsMessage(ArrayList<Student> arr){
        ArrayList<Student> newStu = new ArrayList<Student>();
        for (Student s  : newStu){
            System.out.println(s.getNum()+s.getNum()+s.getSex()+s.getJava()+s.getSql()+s.getC());
        }
    }
    void dsSumAvg(){
        ArrayList<Student> newStu = new ArrayList<Student>();
        for (Student s : newStu){
            double sum = s.getJava()+s.getSql()+s.getC();
            double avg = (s.getJava()+s.getSql()+s.getC())/3;
            System.out.println(sum);
            System.out.println(avg);
        }
    }
    void findNameScore(){

        ArrayList<Student> newStu = new ArrayList<Student>();
        for (Student s : newStu){

        }
    }
}
