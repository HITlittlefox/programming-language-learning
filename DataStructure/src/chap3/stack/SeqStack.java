package chap3.stack;

//?????
public class SeqStack implements Stack {
	final int defaultSize = 10;
	int top;
	Object[] stack;
	int maxStackSize;

	public SeqStack() {
		initiate(defaultSize);
	}

	public SeqStack(int sz) {
		initiate(sz);
	}

	private void initiate(int sz) {
		maxStackSize = sz;
		top = 0;
		stack = new Object[sz];
	}

	public void push(Object obj) throws Exception {
		if (top == maxStackSize) {
			throw new Exception("��ջ������");
		}
		stack[top] = obj;
		top++;
	}

	public Object pop() throws Exception {
		if (top == 0) {
			throw new Exception("��ջ�ѿգ�");
		}
		top--;
		return stack[top];
	}

	public Object getTop() throws Exception {
		if (top == 0) {
			throw new Exception("��ջ�ѿգ�");
		}
		return stack[top - 1];
	}

	public boolean notEmpty() {
		return (top > 0);
	}
}