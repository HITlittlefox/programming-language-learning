public class Exec217 {
	public void converse(SeqList s) {
		int mid, i;
		int x;
		mid = s.size / 2;
		for (i = 0; i < mid; i++) {
			x = s.list[i];
			s.list[i] = s.list[s.size - 1 - i];
			s.list[s.size - 1 - i] = x;
		}
	}

	public static void main(String[] args) {
		Exec217 ex = new Exec217();
		SeqList l = new SeqList();
		ex.converse(l);
		System.out.println();
		System.out.println("after converse");
		for (int i = 0; i < l.size; i++) {
			System.out.print(l.list[i] + " ");
		}
	}
}

class SeqList {
	public int[] list = new int[50];
	public int size;

	public SeqList() {
		size = 0;
		for (int i = 0; i < list.length; i++) {
			int m = (int) (Math.random() * 100);
			if (m > 100)
				break;
			list[i] = m;
			size++;
			System.out.print(m + " ");
		}
	}

}