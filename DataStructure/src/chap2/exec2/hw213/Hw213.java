package chap2.exec2.hw213;

//2－3.编写顺序表定位操作的函数。
//顺序表定位操作的功能是：
//在顺序表中查找是否存在的数据元素x，
//如果存在，返回顺序表中和x值相等的第1个数据元素的序号（序号从0开始编号）；
//如果不存在，回返－1。
public class Hw213 {

	static int listFind(SeqList s, int x) {
		// System.out.println("listFind内部");
		for (int i = 0; i < s.size; i++) {
			// System.out.println(s.list[i]);
			// 在顺序表中查找是否存在的数据元素x，
			if (s.list[i] == x) {
				// 如果存在，
				// 返回顺序表中和x值相等的第1个数据元素的序号（序号从0开始编号）；
				return i;
			}
		}
		// 如果不存在，回返－1。
		return -1;
	}

	public static void main(String[] args) {

		Hw213 e = new Hw213();
		SeqList s = new SeqList();
		// System.out.println(s);
		int x = 20;

		int result = Hw213.listFind(s, x);
		System.out.println();
		System.out.println(x + " position is " + result);
	}
}

// 前几节写的SeqList
class SeqList {
	public int[] list = new int[50];
	public int size;

	public SeqList() {
		size = 0;
		for (int i = 0; i < list.length - 1; i++) {
			int m = (int) (Math.random() * 100);
			if (m > 100)
				break;
			list[i] = m;
			size++;
			// 打印出来SeqList的每个元素
			System.out.print(m + " ");
		}
	}
}