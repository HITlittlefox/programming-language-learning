package chap8;
public class SeqQueue{
	static final int defaultSize = 100;
	int front;
	int rear;
	int count;
	int maxSize;
	Object[] data;

	SeqQueue(){
		initiate(defaultSize);
	}

	SeqQueue(int sz){
		initiate(defaultSize);
	}

	private void initiate(int sz){
		maxSize = sz;
		front = rear = 0;
		count = 0;
		data = new Object[sz];
	}

	public void append(Object obj) throws Exception{
		if(count > 0 && front == rear){
			throw new Exception("队列已满！");
		}

		data[rear] = obj;
		rear = (rear + 1) % maxSize;
		count ++;
	}

	public Object delete() throws Exception{
		if(count == 0){
			throw new Exception("队列已空！");
		}

		Object temp = data[front];
		front = (front + 1) % maxSize;
		count --;
		return temp;
	}

	public Object getFront() throws Exception{
		if(count == 0){
			throw new Exception("队列已空！");
		}

		return data[front];
	}

	public boolean isEmpty(){
		return count == 0;
	}
}
