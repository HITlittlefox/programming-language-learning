package chap1;

// 例1-2:设计一个把存储在数组a中的整数类型数据元素就地逆置的算法。
// 所谓就地逆置是指将数据a中的数据元素反序存放。

public class reverse2Test {
    static void reverse2(int[] a) {
        int n = a.length;
        int m = n / 2;
        int temp;
        for (int i = 0; i < m; i++) { // 进行m次调换
            temp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 - i] = temp;
        }
        System.out.println("");
        System.out.println("After: ");
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }
    }

    public static void main(String args[]) {
        // int[][] a = new int[][] { { 4, 5, 6 }, { 2, 3, 9 } };
        // int[][] b = new int[a[0].length][a.length];
        int[] a = new int[] { 2, 3, 9 };
        System.out.println("Origin: ");
        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + " ");
        }
        // int[] b = new int[a.length];
        reverse2(a);
    }
}