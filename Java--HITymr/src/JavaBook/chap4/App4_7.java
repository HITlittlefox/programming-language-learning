package JavaBook.chap4;//filename��App4_7.java
import java.util.*;
public class App4_7
{
  public static void main(String[] args)
  {
    double sum=0;
    int n=0;
    System.out.println("������������ÿ����һ������Enter��Tab��ո��ȷ�ϣ�");
    System.out.println("�������һ�������ֽ����������");
    Scanner reader=new Scanner(System.in);
    while(reader.hasNextDouble() )
    {
      double x=reader.nextDouble();
      sum=sum+x;
      n++;
    }
    System.out.print("��������"+n+"���������Ϊ��"+sum);
  }
}
