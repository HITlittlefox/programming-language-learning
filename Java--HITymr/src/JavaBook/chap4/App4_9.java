package JavaBook.chap4;//filename��App4_9.java
import java.io.*;
public class App4_9
{
public static void main(String[] args) throws IOException
  {
    int a,b,k;
    String str1,str2;
    BufferedReader buf;
    buf=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("�������һ���� a=");
    str1=buf.readLine();
    a=Integer.parseInt(str1);
    System.out.print("������ڶ����� b=");
    str2=buf.readLine();
    b=Integer.parseInt(str2);
    System.out.print("gcd("+a+","+b+")=");
    do {
      k=a % b;
      a=b;
      b=k;
    }while(k!=0);
    System.out.println(a);
  }
}
