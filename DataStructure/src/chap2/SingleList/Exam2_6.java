package chap2.SingleList;

import java.util.Comparator;

public class Exam2_6 {
	public static void orderInsert(LinList myList, Object x, Comparator mc) {
		Node curr, pre;

		curr = myList.head.next;
		pre = myList.head;

		while (curr != null && (mc.compare(curr.data, x) == 1)) {
			pre = curr;
			curr = curr.next;
		}

		Node temp = new Node((Integer) x, pre.next);
		pre.next = temp;
		myList.size++;
	}

	public static void main(String[] args) {
		MyComparator mc = new MyComparator();
		LinList myList = new LinList();
		int s[] = { 1, 3, 9, 11, 8, 6, 22, 16, 15, 10 }, n = 10;

		try {
			for (int i = 0; i < n; i++) {
				orderInsert(myList, new Integer(s[i]), mc);
			}

			for (int i = 0; i < myList.size; i++) {
				System.out.print(myList.getData(i) + "   ");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
