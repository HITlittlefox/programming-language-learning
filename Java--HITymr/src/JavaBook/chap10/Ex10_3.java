package JavaBook.chap10;

import java.io.FileWriter;
import java.io.IOException;

//ʹ��FileWriter����Ϣд���ļ�
class Ex10_3 {

    public static void main(String[] args) throws IOException {
        //main�����������׳�IO�쳣
        String fileName = "Hello1.txt";
        //String fileName = "E:\\Hello1.txt";

        FileWriter writer = new FileWriter(fileName, true);
        writer.write("Hello\n");
        writer.write("This !is my first text file,\n");
        writer.write("You can see how this is done.\n");
        writer.write("����һ������Ҳ����\n");
        writer.close();
    }





/*
  public static void main ( String[] args ) {
    String fileName = "E:\\javaexamples\\lesson6\\Hello2.txt"; 
    //String fileName = "E:\\Hello2.txt"; 
    
     try {  //������IO��������try����
         FileWriter writer = new FileWriter( fileName,true);
 	 writer.write( "Hello!\n");  
    	 writer.write( "This is my first text file,\n"  );  
    	 writer.write( "You can see how this is done. \n" );
         writer.write("����һ������Ҳ����\n");
         
     	 writer.close();
      	 
    }catch ( IOException iox) { 
        System.out.println("Problem writing" + fileName ); 
    }
  }
*/
}
