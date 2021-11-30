package chap6;

// 递推求两个正整数n和m最大公约数的
public class Exam6_6 {
	// 第一个数需要是二者中最大的数
	public static int gcd(int n, int m) {
		// 至少有一个非正整数，直接返回0
		if (n < 0 || m < 0)
			System.exit(0);
		// 如果有一个
		if (m == 0)
			return n;
		else if (m > n)
			// 如果m>n,就让这两个数交换位置，
			// 第一个数需要是二者中最大的数
			return gcd(m, n);
		else
			// 如果n>=m, n%m取模
			return gcd(m, n % m);
	}

	// 前边一次的递归调用只是为了交换两个参数的位置；
	// 第一个数需要是二者中最大的数

	// 最后一行递归调用可以转换为循环结构实现
	public static int gcd2(int n, int m) {
		int tn, tm, temp;

		if (n < 0 || m < 0)
			System.exit(0);
		if (m > n) {
			tn = m;
			tm = n;
		} else {
			tn = n;
			tm = m;
		}
		while (tm != 0) {
			// 交换
			// 不断交换，temp接收较小的，tn接收较大的，tm是取模后的
			// 第一次取模后，tm总会是较小的
			temp = tn;
			// tn是m和n中较大的
			tn = tm;
			// 大%小取模
			tm = temp % tm;
		}
		return tn;
	}

	public static void main(String[] args) {
		int n = 30, m = 4, c;

		c = gcd2(n, m);
		System.out.println("c = " + c);
	}
}