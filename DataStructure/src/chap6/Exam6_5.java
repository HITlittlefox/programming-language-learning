package chap6;

// 委员会问题，从n人抽出k人(k<=n)组成委员会，问共有多少种构成方法。
// 也就是求C_5^2=10
public class Exam6_5 {
	public static int comm(int n, int k) {
		if (n < 1 || k > n)
			return 0;
		if (k == 0)
			return 1;
		if (n == k)
			return 1;
		return comm(n - 1, k - 1) + comm(n - 1, k);
	}

	public static void main(String[] args) {
		int n = 5, k = 2, c;

		c = comm(n, k);
		System.out.println("c = " + c);
	}
}