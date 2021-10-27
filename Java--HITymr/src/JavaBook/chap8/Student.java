package JavaBook.chap8;
import java.io.*;
public class Student implements Serializable {
    private String id;	//ѧ��
    private String name;	//����
    private int eng;	//Ӣ��ɼ�
    private int math; //��ѧ�ɼ�
    private int comp; //������ɼ�
    private int sum;  //�ܳɼ�
	
    public Student(String id,String name, int eng, int math,int comp){
	this.id=id;
	this.name=name;
	this.eng=eng;
	this.math=math;
	this.comp=comp;
	sum();  //�����ܳɼ�
    }	
    public Student(Student s){		
	this.id=s.id;
	this.name=new String(s.name);
	this.eng=s.eng;
	this.math=s.math;
	this.comp=s.comp;		
	sum();            //�����ܳɼ�
    }
    public void setId(String id){
	this.id=id;
    }
    public void setName(String name){
	this.name=name;
    }	
    public void setEng(int eng){
	this.eng=eng;
	sum();            //�����ܳɼ�
    }
    public void setMath(int math){
	this.math=math;
	sum();            //�����ܳɼ�
    }
    public void setComp(int comp){
	this.comp=comp;
	sum();            //�����ܳɼ�
    }    	
    public String getId(){
	return id;
    }	
    public String getName(){
	return name;
    }
    public int getEng(){ 
        return eng; 
    }
    public int getMath(){ 
        return math; 
    }
    public int getComp(){ 
        return comp; 
    }
    public int getSum(){ 
        return sum; 
    }
    final void sum(){  
        sum=eng+math+comp;
    }
    public String toString(){
        return getId() + "\t"+getName() +"\t"+getEng() + "\t"+getMath() +"\t"+getComp() +"\t"+getSum();
    } 	
    public boolean equals(Object x) { 
      	if (this.getClass() != x.getClass()) return false;      
      	Student b = (Student) x;     
      	return (this.getId().equals(b.getId())); 
    }	
    //�Ƚϳɼ���С,��ǰ����ɼ��Ȳ�������ɼ���ʱ����1,���ʱ����0,��������-1.
    public int compare(Student A){
	if(this.getSum()>A.getSum()) return 1;
	else if(this.getSum()==A.getSum()) return 0;
	else return -1;
    }	
}
