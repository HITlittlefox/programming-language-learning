package chap2.SingleList;

public class Exam2_5 {
	public static int moreDataDelete(SeqList L, Object x) throws Exception {
		// 删除顺序表L中所有的数据元素x
		int i;
		int tag = 0;

		for (i = 0; i < L.size; i++) {
			if (x.equals(L.getData(i))) {
				L.delete(i);
				i--;
				tag = 1;
			}
		}

		return tag;
	}

	public static void main(String[] args) {
		SeqList myList = new SeqList(100);
		int n = 10;
		try {
			for (int i = 0; i < n; i++) {
				myList.insert(i, new Integer(i + 1));
			}
			myList.insert(10, new Integer(5));

			moreDataDelete(myList, new Integer(5));

			for (int i = 0; i < myList.size; i++) {
				System.out.print(myList.getData(i) + "   ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}