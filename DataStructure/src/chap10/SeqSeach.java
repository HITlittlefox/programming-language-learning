package chap10;

//无序序列查找某个元素是否存在。顺序查找
public class SeqSeach {
    public static int seqSeach(int[] a, int elem) {
        int n = a.length;
        int i = 0;
        while (i < n && a[i] != elem) i++;

        if (a[i] == elem) return i;
        else return -1;
    }

    public static void main(String[] args) {
        int[] test = {710, 342, 45, 686, 6, 841, 429, 134, 68, 264};
        int n = 10, elem = 686, i;

        if ((i = seqSeach(test, elem)) != -1)
            System.out.println("查找成功! 该对象为第" + i + "个对象");
        else System.out.println("查找失败! 该对象在对象集合中不存在");
    }
}
