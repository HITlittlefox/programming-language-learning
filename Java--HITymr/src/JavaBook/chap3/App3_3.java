package JavaBook.chap3;

import java.io.*;
public class App3_3{
  public static void main(String[] args) throws IOException {
    BufferedReader buf;
    String str;
    buf=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("�������ַ�����");
    str=buf.readLine();
    System.out.println("��������ַ����ǣ�"+str);

    byte b=(byte)222222;
  }
}
