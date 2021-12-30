package chap2.List_SeqList;

public class SeqListTest1 {
	public static void main(String args[]) {
		SeqList seqList = new SeqList(100);
		int n = 10;
		try {
			for (int i = 0; i < n; i++) {
				seqList.insert(i, new Integer(i + 1));
			}

			// 删除了5
			seqList.delete(4);

			// seqList.insert(22,new Integer(22));
			// seqList.delete(22);
			// seqList.getData(22);

			for (int i = 0; i < seqList.size; i++) {
				System.out.print(seqList.getData(i) + "   ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
