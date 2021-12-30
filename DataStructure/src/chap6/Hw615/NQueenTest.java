package chap6.Hw615;

// NQueen类的测试函数

import java.util.Scanner;

public class NQueenTest {
    public static void main(String args[]) {
        int q;
        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入皇后个数并回车");
        System.out.println("以8皇后为例子：");
//        q = sc.nextInt();
        NQueen nq = new NQueen(8);
        nq.NQueens(0);// 先放第0行
    }
}
