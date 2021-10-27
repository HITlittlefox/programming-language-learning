import java.util.*;

public class InputNum {
    public static void main(String[] args) {
        int a = 0;
        float b = 0F;
        double c = 0D;
        String s = "";
        Scanner reader = new Scanner(System.in);
        System.out.print("从键盘输入一串字符：");
        s = reader.nextLine();
        System.out.println("你输入的字符串是" + s);
        System.out.print("从键盘输入一个整数：");
        a = reader.nextInt();
        System.out.println("你输入的整数是" + a);
        System.out.print("从键盘输入一个单精度浮点数：");
        b = reader.nextFloat();
        System.out.println("你输入的单精度浮点数是" + b);
        System.out.print("从键盘输入一个双精度浮点数：");
        c = reader.nextDouble();
        System.out.println("你输入的单精度浮点数是" + c);
    }
}
