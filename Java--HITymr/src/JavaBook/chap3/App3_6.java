package JavaBook.chap3;//filename��App3_6.java
import java.util.*;
public class App3_6
{
  public static void main(String[] args)
  {
    int num1;
    double num2;
    Scanner reader=new Scanner(System.in);
    System.out.print("�������һ������");
    num1= reader.nextInt();
    System.out.print("������ڶ�������");
    num2= reader.nextDouble();
    System.out.println(num1+"*"+num2+"="+((float)num1*num2));
  }
}
