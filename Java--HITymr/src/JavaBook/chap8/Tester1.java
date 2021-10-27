package JavaBook.chap8;
import java.io.*;
public class Tester1{		
    public static void main(String args[]){
        StudentClass aClass = new StudentClass("���0201",5); 	
        Student students[]=new Student[5];		
	for (int i=0; i<5; i++)
            students[i] = new Student(getAStudent(i+1));	
        aClass.setStudents(students);		
	System.out.println(aClass);	
        //��ѧ����Ϣ���浽�ļ�stu.ser�С�		
	try {			
           ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("stu.ser"));
           for (int i=0; i<5; i++)
           oos.writeObject(students[i]);
           oos.close();
       }catch(Exception e){
          System.out.println(e) ;
       }
    }	
    public static Student getAStudent(int i){		
        Student studenti;		    		
	System.out.println("�����" + i + "��ѧ������Ϣ:"); 
	System.out.print("ѧ��:"); 
       	String id = Keyboard.getString(); 
        System.out.print("����:"); 
        String name = Keyboard.getString();         
        System.out.print("Ӣ��ɼ�:"); 
        int eng = Keyboard.getInteger();         
        System.out.print("��ѧ�ɼ�:"); 
        int math = Keyboard.getInteger();         
        System.out.print("������ɼ�:"); 
        int comp = Keyboard.getInteger();         
        studenti = new Student(id,name,eng,math,comp);
        return studenti;
    }
}

