package chap1;

// ??1-1:设计??个把存储在数组a中的??组整数类型数据元素???置后保存在数组b中的算法??
// ??谓???置是指数据元素排列次序相反??
public class reverse1Test {
    static void reverse1(int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++)
            b[i] = a[n - 1 - i]; // 把数组a的元素???置后赋给数组b

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