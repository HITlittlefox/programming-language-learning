package chap1;

// ??1-1:���??���Ѵ洢������a�е�??��������������Ԫ��???�ú󱣴�������b�е��㷨??
// ??ν???����ָ����Ԫ�����д����෴??
public class reverse1Test {
    static void reverse1(int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            b[i] = a[n - 1 - i]; // ������a��Ԫ��???�ú󸳸�����b

        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("");
        for (int k = 0; k < b.length; k++) {
            System.out.print(b[k] + " ");

        }

    }

    public static void main(String args[]) {
        // int[][] a = new int[][] { { 4, 5, 6 }, { 2, 3, 9 } };
        // int[][] b = new int[a[0].length][a.length];
        int[] a = new int[] { 2, 3, 9 };
        int[] b = new int[a.length];
        reverse1(a, b);
    }
}