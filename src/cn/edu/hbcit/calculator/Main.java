package cn.edu.hbcit.calculator;
import java.util.*;
public class Main {
    public static void main(String[] args) {

    }
    private static void menu() {
        System.out.println("——————————————————————————————————————_——————");
        System.out.println("_____________________________________________");
        System.out.println("______________简易计算器______________________________");
        System.out.println("_____________________________________________");
        System.out.println("______1. + ____________5. sin _______________");
        System.out.println("______2. - ____________6. cos________________");
        System.out.println("______3. × ____________7. tan________________");
        System.out.println("______4. ÷ ____________8. cot________________");
        System.out.println("_____________________________________________");
        System.out.println("________________按0键退出系统________________________");
        System.out.println("_____________________________________________");
        System.out.println("_____________________________________________");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入菜单项：");
        String inputValue = sc.nextLine();
        switch (inputValue) {
            case "1" :
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                break;
            case "8":
                break;
            case "0":
                break;
            default:
        }
    }
}
