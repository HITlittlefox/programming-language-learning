package chap3.SeqPQueue;

public class Element{
	private Object elem;						//ԭ�������ϵ�����Ԫ��
	private int priority;						//���ȼ�
	
	Element(Object obj, int i){					//���캯��
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
