package JavaBook.chap3;

import java.util.*;    //����java.util������������
public class App3_7{
  public static void main(String[] args){
    String s1,s2;
    Scanner reader=new Scanner(System.in);
    System.out.print("�������һ������");
    s1= reader.nextLine();       //�������������Ϊ�ַ������ݸ�ֵ������s1
    System.out.print("������ڶ�������");
    s2= reader.next();           //��Enter����next()�������س����ͻ��з�ȥ��
    System.out.println("�������"+s1+"��"+s2);
  }
}
