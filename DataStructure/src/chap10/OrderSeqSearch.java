package chap10;

//有序数组的，顺序查找
public class OrderSeqSearch {
    public static int orderSeqSearch(int[] a, int elem) {
        int n = a.length;
        int i = 0;
        while (i < n && a[i] < elem) i++;

        if (a[i] == elem) {
            return i;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] test = {2, 4, 6, 8, 10};
        int n = 5, elem = 6, i;

        if ((i = orderSeqSearch(test, elem)) != -1) System.out.println("查找成功! 该对象为第" + i + "个对象");
        else System.out.println("查找失败! 该对象在对象集合中不存在");
    }
}
