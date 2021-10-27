package test;

import java.util.*;    //加载java.util类库里的所有类

public class test2 {
    public static void main(String[] args) {
        int num1;
        double num2;
        Scanner reader = new Scanner(System.in);
        System.out.print("请输入第一个数：");
        num1 = reader.nextInt();       //将输入的内容做int型数据赋值给变量num1
        System.out.print("请输入第二个数：");
        num2 = reader.nextDouble();    //将输入的内容做double型数据赋值给变量num2
        System.out.println(num1 + "*" + num2 + "=" + (num1 * num2));
    }
}
