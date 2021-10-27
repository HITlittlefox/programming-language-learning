package HomeWork;

import java.util.*;

public class NumComplete {


    public static void main(String[] args) {
        int num;
        Scanner reader = new Scanner(System.in);
        System.out.print("请输入一个数，该程序会判断该数是否是完全数：");
        num = reader.nextInt();
        int i;
        int sum = 0;
        for (i = 1; i < num; i++)
            if (num % i == 0)
                sum += i;
        if (sum == num)
            System.out.println("您输入的" + num + "是完全数！");
        else
            System.out.println("您输入的" + num + "不是完全数！");


    }


}
