package cn.edu.hbcit.st1;

public class Student {
    private String num;
    private String name;
    private char sex;
    private double java;
    private double sql;
    private double c;
    Student(String num,String name,String age,char sex,double java,double sql,double c){
        this.name = name;
        this.num = num;
        this.sex = sex;
        this.java = java;
        this.sql = sql;
        this.c = c;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public char getSex() {
        return sex;
    }

    public double getJava() {
        return java;
    }

    public double getSql() {
        return sql;
    }

    public double getC() {
        return c;
    }
}
