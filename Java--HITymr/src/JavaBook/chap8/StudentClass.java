package JavaBook.chap8;
//import java.io.*;

public class StudentClass{
   private String name;             //�༶����
   static int capacity = 40;        //�������
   private Student students[];      //ѧ��
   private int size;                //ʵ������
   public StudentClass(String name, int size){
	this.name = name;
	this.size = size;
	students = new Student[capacity];
   }	 
   public String getName(){ 
        return name; 
   }
   public int getCapacity(){ 
        return capacity; 
   }        
   public Student[] getStudents(){ 
        return students; 
   }
   public int getSize(){ 
        return size; 
   } 
   public void setName(String name){ 
        this.name =name;
   }
   public void setCapacity(int capacity){
	this.capacity = capacity;
   }        
   public void setSize(int size){
	this.size = size;		
   }
   public void setStudents(Student[] students){
	for (int i = 0; i<size; i++)
	    this.students[i] = new Student(students[i]);
   }		
   public String toString(){
	String s;
	s = " �༶:" + name +"\t" + "����:" + capacity + "\t" + "ʵ������:" + size +"\n\n";
	s = s + "ѧ��"+"\t" + "����"+"\t" + "Ӣ��"+"\t" + "��ѧ" + "\t" + "�����" +"\t" + "�ܳɼ�\n";		
        for (int i=0; i<size; i++)
	    s = s + students[i].getId()+"\t"+  students[i].getName()+ "\t"  +students[i].getEng()+ "\t" +students[i].getMath()+"\t" + students[i].getComp()+"\t"+students[i].getSum()+"\n";  
	return s;
   }

   //˳����ҷ���:��֪ѧ����ѧ�ţ����Ҵ�ѧ���Ƿ����
   public int find(String id){
    	for (int i = 0; i < size; i++)
    	   if (students[i].getId().equals(id)) return i;
    	return -1;
   } 
   //����Ԫ�ص�����:�������ĩβ����һ��ѧ������
   public boolean add(Student aStudent){
        if (size == capacity) return false;
        if (find(aStudent.getId())>=0) return false; 
        this.students[size] = new Student(aStudent.getId(), aStudent.getName(), aStudent.getEng(), aStudent.getMath(), aStudent.getComp() );
	size++;
	return true;
   } 
   //����Ԫ�ص�ɾ��:��֪һ��Student���󣬽��˶����������ɾ��
   public boolean del(Student aStudent){
        int pos = find(aStudent.getId());
	if (pos== -1) return false; 
	for (int i = pos+1; i<size; i++)
	students[i-1] = students[i];
	size--;		
	return true;
   }
   //����Ԫ�ص�ɾ��:��֪ѧ��,ɾ��һ��ѧ��
   public boolean del(String id){
	int pos = find(id);
	if (pos== -1) return false; 
	for (int i = pos+1; i<size; i++)
	   students[i-1] = students[i];
	size--;		
	return true;
   }

//ѡ������	
   public void selectionSort(){
        Student temp;
	for (int i=0; i<size-1; i++)
	   for (int j=i+1;j<size;j++)
	      if (students[j].compare(students[i])>0) {
		    temp = students[i];
		    students[i] = students[j];
		    students[j] = temp;
	      }
   }
   //ֱ�Ӳ������򷽷�
   public void insertSort(){
        Student temp;
	for (int i=1; i<size; i++) {
	    temp = students[i];
	    int j = i-1;
	    while (j>-1 && temp.compare(students[j])>0){
	        students[j+1] = students[j];    j--;
            }
	    students[j+1] = temp;
        }		
    }

  }





  
 /*



   */



