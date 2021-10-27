package JavaBook.chap10;
//filename��App10_9.java
import java.io.*;
public class App10_9
{
  public static void main(String[] args) throws IOException
  {
    String str=new String();
    try
    {
      InputStreamReader isr=new InputStreamReader(System.in);
      BufferedReader inp=new BufferedReader(isr);
      String sdir="D:\\javaexamples\\chap10";
      String sfile;
      File fdir1=new File(sdir);
      if (fdir1.exists() && fdir1.isDirectory())
      {
        System.out.println("�ļ��У�"+sdir+"�Ѿ�����");
        for (int i=0;i<fdir1.list().length;i++)
          System.out.println((fdir1.list())[i]);
        File fdir2=new File("D:\\javaexamples\\chap10\\temp");
        if (!fdir2.exists())
          fdir2.mkdir();
        System.out.println();
        System.out.println("�������ļ��к���ļ��б�");
        for (int i=0;i<fdir1.list().length;i++)
          System.out.println((fdir1.list())[i]);
      }
      System.out.print("��������ļ����е�һ���ļ�����");
      sfile=inp.readLine();
      File ffile=new File(fdir1,sfile);
      if (ffile.isFile())
      {
        System.out.print("�ļ�����"+ffile.getName());
        System.out.print("�������ļ��У�"+ffile.getPath());
        System.out.println("���ļ���С��"+ffile.length()+"�ֽ�");
      }
    }
    catch (IOException e)
    {
      System.out.println(e.toString());
    }
  }
}
