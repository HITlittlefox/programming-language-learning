package JavaBook.chap3;

import java.io.*;
public class Exe3_18{

/**document test111*/
  public static void main(String[] args) throws IOException {
     int x=3,y=17;
     boolean yn=true;
/**document test2222*/
     System.out.println("x+y*x-- :"+(x+y*x--));
     System.out.println("-x*y+y :"+(-x*y+y));
     System.out.println("x<y && yn- :"+(x<y && yn));
     System.out.println("x>y || !yn :"+(x>y || !yn));
     System.out.println("y!=++x?x:y :"+(y!=++x?x:y));
     System.out.println("y++/--x:"+(y++/--x));


  }
}
