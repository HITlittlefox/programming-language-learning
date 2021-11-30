package chap3.SeqPQueue;

public class Element{
	private Object elem;						//原先意义上的数据元素
	private int priority;						//优先级
	
	Element(Object obj, int i){					//构造函数
		elem = obj;
		priority = i;
	}
	public Object getElem(){
		return elem;
	}
	
	public void setElem(Object obj){
		elem = obj;
	}
	
	public int getPriority(){
		return priority;
	}
	
	public void setPriority(int i){
		priority = i;
	}
}
