package JavaBook.chap3;

import java.io.*;
public class App3_3{
  public static void main(String[] args) throws IOException {
    BufferedReader buf;
    String str;
    buf=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("ÇëÊäÈë×Ö·û´®£º");
    str=buf.readLine();
    System.out.println("ÄúÊäÈëµÄ×Ö·û´®ÊÇ£º"+str);

    byte b=(byte)222222;
  }
}
