package chap6;

// 汉诺塔 4片
public class Exam6_3 {
	public static void towers(int n, char fromPeg, char toPeg, char auxPeg) {
		if (n == 1) {
			System.out.println("move disk 1 from peg " + fromPeg + " to peg " + toPeg);
			return;
		}
		towers(n - 1, fromPeg, auxPeg, toPeg);
		System.out.println("move disk " + n + " from peg " + fromPeg + " to peg " + toPeg);
		towers(n - 1, auxPeg, toPeg, fromPeg);
	}

	public static void main(String[] args) {
		towers(4, 'A', 'C', 'B');
	}
}