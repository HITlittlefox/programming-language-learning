package chap2.SingleList;

public class LinListTest {
	public static void main(String args[]) {
		LinList linList = new LinList();
		int n = 10;
		try {
			for (int i = 0; i < n; i++) {
				linList.insert(i, new Integer(i + 1));
			}

			linList.delete(4);

			for (int i = 0; i < linList.size; i++) {
				System.out.print(linList.getData(i) + "   ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}