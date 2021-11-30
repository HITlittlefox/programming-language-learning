package chap2.SingleList;

public class Exam2_4 {
	public static int dataDelete(SeqList L, Object x) throws Exception {
		int i;

		for (i = 0; i < L.size; i++)
			if (x.equals(L.getData(i)))
				break;

		if (i == L.size)
			return 0;
		L.delete(i);
		return 1;
	}

	public static void main(String[] args) {
		SeqList myList = new SeqList(100);
		int n = 10;
		try {
			for (int i = 0; i < n; i++) {
				myList.insert(i, new Integer(i + 1));
			}

			dataDelete(myList, new Integer(5));

			for (int i = 0; i < myList.size; i++) {
				System.out.print(myList.getData(i) + "   ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}