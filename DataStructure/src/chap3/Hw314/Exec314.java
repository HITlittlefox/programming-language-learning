package chap3.Hw314;

import java.util.*;
public class Exec314{
	public static void main(String[] args){
		SeqPQueue s=new SeqPQueue();
		PQueueNode x=new PQueueNode(0,0);
		boolean notempty=true;
		
		System.out.println("��ʼ��������ȼ�ɾ��");
		while(notempty){
			notempty=s.SPQDelete(x);
			if(notempty)
			System.out.println(x.getPriority()+"    "+x.getElem());
		}
			
	
	}
}



class SeqPQueue{
	PQueueNode[] list;
	int size;
	SeqPQueue(){
		list=new PQueueNode[50];
		size=10;
		Random r=new Random();
		
		for(int i=0;i<size;i++){
			list[i]=new PQueueNode((int)(Math.random()*100),r.nextInt(10));
			System.out.println(list[i].getPriority()+"       "+list[i].getElem());	
		}
	}
	
	boolean SPQDelete(PQueueNode x){
		PQueueNode min=list[0];
		int minIndex=0;
		if(size<=0){
			System.out.println("�����ѿգ���Ԫ�ؿ�ɾ��");
			return false;
		}
		for(int i=0;i<size;i++){
			if(list[i].getPriority()<min.getPriority()){
				min=list[i];
				minIndex=i;
			}
		}
		
		//x=list[minIndex];
		x.setElem(list[minIndex].getElem());
		x.setPriority(list[minIndex].getPriority());
		
		list[minIndex]=list[size-1];
		size--;
		return true;
		
	}
}



class PQueueNode{
	private int elem;
	private int priority;
	
	PQueueNode(int elem,int priority){
		this.elem=elem;
		this.priority=priority;
	}
	
	int getElem(){
		return elem;
	}
	
	void setElem(int elem){
		this.elem=elem;
	}
	
	
	int getPriority(){
		return priority;
	}
	
	void setPriority(int priority){
		this.priority=priority;
	}
	
	
}