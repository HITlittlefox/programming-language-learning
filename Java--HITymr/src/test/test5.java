package test;

import java.util.Scanner;

public class test5 {


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int score;
        while (true) {
            System.out.print("请输入您的分数：");
            score = reader.nextInt();
            if (score >= 0 && score <= 100) {
                break;
            }
            System.out.print("您的分数在不合理的范围，请输入0~100的分数");

        }
        switch (score / 5) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                System.out.println("该学生的分数段为D");
                break;
            case 12:
            case 13:
                System.out.println("该学生的分数段为C");
                break;
            case 14:
            case 15:
            case 16:
                System.out.println("该学生的分数段为B");
                break;
            case 17:
            case 18:
            case 19:
            case 20:
                System.out.println("该学生的分数段为A");
                break;
        }


    }

}
