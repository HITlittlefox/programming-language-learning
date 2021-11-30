package chap6;

// ½×³Ë
public class Exam6_1_2 {
	public static long fact(int n) throws Exception {
		int x;
		long y;

		if (n < 0) {
			throw new Exception("?????¨ª??");
		}

		if (n == 0) {
			System.out.println("n=" + n);
			return 1;
		} else {
			x = n - 1;
			System.out.println("n=" + n + " x=" + x);
			y = fact(x);
			System.out.println("n=" + n + " x=" + x + " y=" + y);
			return n * y;
		}
	}

	public static void main(String[] args) {
		int n = 3;
		long fn;

		try {
			fn = fact(n);
			System.out.println("fn = " + fn);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}