package chap6.Hw615;

// NQueen��Ĳ��Ժ���

import java.util.Scanner;

public class NQueenTest {
    public static void main(String args[]) {
        int q;
        Scanner sc = new Scanner(System.in);
//        System.out.println("������ʺ�������س�");
        System.out.println("��8�ʺ�Ϊ���ӣ�");
//        q = sc.nextInt();
        NQueen nq = new NQueen(8);
        nq.NQueens(0);// �ȷŵ�0��
    }
}
