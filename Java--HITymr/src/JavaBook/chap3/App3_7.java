package JavaBook.chap3;

import java.util.*;    //加载java.util类库里的所有类
public class App3_7{
  public static void main(String[] args){
    String s1,s2;
    Scanner reader=new Scanner(System.in);
    System.out.print("请输入第一个数：");
    s1= reader.nextLine();       //将输入的内容作为字符型数据赋值给变量s1
    System.out.print("请输入第二个数：");
    s2= reader.next();           //按Enter键后next()方法将回车符和换行符去掉
    System.out.println("输入的是"+s1+"和"+s2);
  }
}
