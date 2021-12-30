package chap9;

public class HeapSort {

    //创建最大堆（被反复调用）
    public static void createHeap(int[] a, int n, int h) {
        int i, j, flag;
        int temp;

        i = h;// i为要建堆的二叉树根结点下标
        j = 2 * i + 1;// j为i结点的左孩子结点的下标
        temp = a[i];
        flag = 0;

        //沿左右孩子中值较大者重复向下筛选
        while (j < n && flag != 1) {

            //寻找左右孩子结点中的较大者,j为其下标
            if (j < n - 1 && a[j] < a[j + 1]) {
                j++;
            }

            if (temp > a[j])    //如果父节点>“左右孩子中较大结点”  a[i]>a[j]
                flag = 1;   //标记结束筛选条件
            else {
                //如果父节点<“左右孩子中较大结点”,就让大的孩子结点与父节点交换位置
                //否则把a[j]上移
                a[i] = a[j];
                i = j;
                j = 2 * i + 1;//看刚才较大孩子的左孩子
            }
        }
        a[i] = temp;//如果父节点<“左右孩子中较大结点”,就让大的孩子结点与父节点交换位置；把最初的a[i]赋予最后的a[j]
    }

    //初始化创建堆（对每一个非叶节点到根节点进行调整）
    public static void initCreateHeap(int[] a) {
        int n = a.length;
        for (int i = (n - 1) / 2; i >= 0; i--)
            createHeap(a, n, i);
    }

    //堆排序

    /**
     * @param a 堆排序基本思想：循环执行以下过程直到数组为空
     *          1. 把堆顶a[0]元素（最大元素）和当前最大堆的最后一个元素交换
     *          2. 最大堆元素个数减1
     *          3. 调整根节点使之满足最大堆的定义
     */
    public static void heapSort(int[] a) {
        int temp;
        int n = a.length;

        initCreateHeap(a);                //初始化创建最大堆

        for (int i = n - 1; i > 0; i--) {    //当前最大堆个数每次递减1
            //把堆顶a[0]元素和当前最大堆的最后一个元素交换
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            createHeap(a, i, 0);            //调整根结点满足最大堆
        }
    }

    public static void main(String[] args) {
        int[] test = {10, 50, 32, 5, 76, 9, 40, 88};
        int n = test.length;

        heapSort(test);
        for (int j : test) {
            System.out.print(j + "  ");
        }
    }
}
