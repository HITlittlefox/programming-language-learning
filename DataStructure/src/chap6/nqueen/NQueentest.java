package chap6.nqueen;

// NQueen类的测试函数
import java.util.Scanner;

public class NQueentest {
    public static void main(String args[]) {
        int q;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入皇后个数并回车");
        q = sc.nextInt();
        NQueen nq = new NQueen(q);
        nq.NQueens(0);// 先放第0行
    }
}
