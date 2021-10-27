package JavaBook.chap8;
import java.io.*;
public class Tester2{
  public static void main(String args[]){	
    Student students[]=new Student[5];	
    try {//���ļ�stu.ser�ж���ѧ����Ϣ
      FileInputStream fi = new FileInputStream("stu.ser");
      ObjectInputStream si = new ObjectInputStream(fi);
      for (int i=0; i<5; i++)             
        students[i] = (Student)si.readObject();             
      si.close();
    }catch(Exception e) {
      System.out.println(e);
    }
    StudentClass aClass = new StudentClass("���0201",5);
    aClass.setStudents(students);		
    System.out.println(aClass);	
    aClass.add(new Student("1111","����",89,90,98));
    System.out.println("position of 1111:"+aClass.find("1111")); 
    System.out.println(aClass); 
    aClass.del("1111");
    System.out.println("position of 1111:"+aClass.find("1111")); 			
    aClass.selectionSort(); // ѡ������  		
    System.out.println("ѡ�������Ľ��:\n");  
    System.out.println(aClass); 
    //aClass.insertSort();//ֱ�Ӳ�������  
   // System.out.println("ֱ�Ӳ��������Ľ��:\n"); 	
   // System.out.println(aClass);    	    	
  }
}
