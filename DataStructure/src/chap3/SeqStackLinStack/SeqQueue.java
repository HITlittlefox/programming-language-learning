//package chap3.SeqStackLinStack;
//
//import chap3.链式队列顺序循环队列.Queue;
//
//public class SeqQueue implements Queue {
//	final int defaultSize = 10;
//	int front;
//	int rear;
//	int count;
//	int maxSize;
//	Object[] data;
//
//	public SeqQueue(){
//		this.initiate(defaultSize);
//	}
//
//	public SeqQueue(int sz){
//		this.initiate(sz);
//	}
//
//	private void initiate(int sz){
//		maxSize = sz;
//		front = rear = 0;
//		count = 0;
//		data = new Object[sz];
//	}
//
//	public void append(Object obj) throws Exception{
//		if(count > 0 && front == rear){
//			throw new Exception("����������");
//		}
//
//		data[rear] = obj;
//		rear = (rear + 1) % maxSize;
//		count ++;
//	}
//
//	public Object delete() throws Exception{
//		if(count == 0){
//			throw new Exception("�����ѿգ�");
//		}
//
//		Object temp = data[front];
//		front = (front + 1) % maxSize;
//		count --;
//		return temp;
//	}
//
//	public Object getFront() throws Exception{
//		if(count == 0){
//			throw new Exception("�����ѿգ�");
//		}
//
//		return data[front];
//	}
//
//	public boolean notEmpty(){
//		return count != 0;
//	}
//
//}
