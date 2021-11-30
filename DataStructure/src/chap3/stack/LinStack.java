package chap3.stack;

// 链式堆栈类
public class LinStack implements Stack {
	Node head; // 堆栈头
	int size; // 结点个数

	public void LinStack() { // 构造函数
		head = null;
		size = 0;
	}

	public void push(Object obj) { // 入栈
		head = new Node(obj, head); // 新结点作为新栈顶
		size++;
	}

	public Object pop() throws Exception { // 出栈
		if (size == 0) {
			throw new Exception("堆栈已空！");
		}
		Object obj = head.data; // 原栈顶数据元素
		head = head.next; // 原栈顶结点脱链
		size--;
		return obj;
	}

	public boolean notEmpty() { // 非空否
		return head != null;
	}

	public Object getTop() {
		return head.data;
	}
}
