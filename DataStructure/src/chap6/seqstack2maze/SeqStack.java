package chap6.seqstack2maze;

public class SeqStack {
	protected int top;
	protected Mazeunit[] Data;
	protected int MaxSize;

	public SeqStack(int _maxsize) {
		MaxSize = _maxsize;
		Data = new Mazeunit[MaxSize];
		for (int h = 0; h < MaxSize; h++) {
			Data[h] = new Mazeunit();
		}
	}

	public void Push(Mazeunit item) {
		if (top == MaxSize) {
			System.out.println("堆栈已满");
			return;
		}
		Data[top].i = item.i;
		Data[top].j = item.j;
		Data[top].di = item.di;
		top++;
	}

	public Mazeunit Pop() {
		if (top == 0) {
			System.out.println("堆栈已空");
			return null;
		}
		top--;
		return Data[top];
	}

	public Mazeunit GetTop() {
		if (top == 0) {
			System.out.println("堆栈已空");
			return null;
		}
		return Data[top - 1];
	}

	public Mazeunit GetElement(int p) {
		if (top == 0) {
			System.out.println("堆栈已空");
			return null;
		}
		return Data[p];
	}

	public boolean NotEmpty() {
		if (top != 0)
			return true;
		return false;
	}
}
