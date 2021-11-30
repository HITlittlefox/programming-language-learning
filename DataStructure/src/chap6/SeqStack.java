package chap6;


public class SeqStack{
	
	final int defaultSize = 10;
	int top;
	Object[] stack;
	int maxStackSize;
	
	SeqStack(){
		initiate(defaultSize);
	}
	
	SeqStack(int sz){
		initiate(sz);
	}
	
	public void initiate(int sz){
		maxStackSize = sz;
		top = 0;
		stack = new Object[sz];
	}
	
	public void push(Object obj) throws Exception{
		if(top == maxStackSize){
			throw new Exception("¶ÑÕ»ÒÑÂú£¡");
		}
		stack[top] = obj;
		top ++;
	}
	
	public Object pop() throws Exception{
		if(top == 0){
			throw new Exception("¶ÑÕ»ÒÑ¿Õ£¡");
		}
		top --;
		return stack[top];
	}
	
	public Object getTop() throws Exception{
		if(top == 0){
			throw new Exception("¶ÑÕ»ÒÑ¿Õ£¡");
		}
		return stack[top - 1];
	}
	
	public boolean isEmpty(){
		return (top != 0);
	}
}