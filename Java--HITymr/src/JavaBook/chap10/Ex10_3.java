package JavaBook.chap10;

import java.io.FileWriter;
import java.io.IOException;

//使用FileWriter把信息写入文件
class Ex10_3 {

    public static void main(String[] args) throws IOException {
        //main方法中声明抛出IO异常
        String fileName = "Hello1.txt";
        //String fileName = "E:\\Hello1.txt";

        FileWriter writer = new FileWriter(fileName, true);
        writer.write("Hello\n");
        writer.write("This !is my first text file,\n");
        writer.write("You can see how this is done.\n");
        writer.write("输入一行中文也可以\n");
        writer.close();
    }





/*
  public static void main ( String[] args ) {
    String fileName = "E:\\javaexamples\\lesson6\\Hello2.txt"; 
    //String fileName = "E:\\Hello2.txt"; 
    
     try {  //将所有IO操作放入try块中
         FileWriter writer = new FileWriter( fileName,true);
 	 writer.write( "Hello!\n");  
    	 writer.write( "This is my first text file,\n"  );  
    	 writer.write( "You can see how this is done. \n" );
         writer.write("输入一行中文也可以\n");
         
     	 writer.close();
      	 
    }catch ( IOException iox) { 
        System.out.println("Problem writing" + fileName ); 
    }
  }
*/
}
