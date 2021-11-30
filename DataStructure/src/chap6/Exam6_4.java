package chap6;

// 一般递归函数设计举例
// 以竖列显示n~1,n~2,n~3,n~4,···,n
public class Exam6_4 {
	public static void display(int n) {
		for (int i = 1; i <= n; i++) {
			// n一直没变化哦，输出9个9，8个8，7个7...
			System.out.print("     " + n);
		}
		System.out.println();

		if (n > 0)
			display(n - 1);
	}

	public static void main(String[] args) {
		int n = 9;

		display(n);
	}
}