package chap6.Hw615;

public class NQueen {
    private int n; // 皇后个数
    private int s[]; // 存放解的一维数组
    private int count; // 第几个解和解的总个数

    public NQueen(int i) {
        n = i;
        count = 0;
        s = new int[n];
    }

    // 打印解
    public void print() {
        int i;
        count++;
        System.out.println("第" + count + "个解，各个皇后摆放的行列位置分别是：");
        for (i = 0; i < n; i++)
            System.out.print("(" + i + "," + s[i] + ")"); // s[i]表示第i个皇后摆放的列号。即i皇后摆放在坐标（i,s[i]）位置上
        System.out.println();
    }

    public static int abs(int i) {
        if (i < 0)
            return -i;
        return i;
    }

    public boolean place(int k, int i) {// 判断第k行皇后放在第i列位置是否合适
        for (int j = 0; j < k; j++) // 检测欲放在第k行的k皇后是否与敌0~k-1行上的每个皇后(共k个，即前k个)冲突
            // 不能对角线、不能竖线
            if ((s[j] == i) || (abs(s[j] - i) == abs(j - k)))
                return false;
        return true;
    }

    // 第k行，第i列
    public void NQueens(int k) { // 在第k行的合适列摆放k皇后
        for (int i = 0; i < n; i++) { // 在第k行的各列试验
            if (place(k, i)) {// 判断在第k行的i列上放k皇后 合适否。如果合适，则把k皇后摆在i列上，并输出一个可行解
                s[k] = i;
                if (k == n - 1)
                    print();
                else
                    NQueens(k + 1);
            }
        }
    }
}
