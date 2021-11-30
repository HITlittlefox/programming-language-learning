package chap6;

// 二分法搜索
public class Exam6_2 {
	public static int bSearch(int[] a, int x, int low, int high) {
		int mid;

		if (low > high)
			return -1;

		mid = (low + high) / 2;
		if (x == a[mid])
			return mid;
		else if (x < a[mid])
			return bSearch(a, x, low, mid - 1);
		else
			return bSearch(a, x, mid + 1, high);
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 5, 17, 18, 31, 33 };
		int x = 17;
		int bn;

		bn = bSearch(a, x, 0, 7);
		if (bn == -1)
			System.out.println("x不在数组a中");
		else
			System.out.println("x在数组a中，下标为" + bn);
	}
}