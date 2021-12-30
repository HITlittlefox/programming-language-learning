package chap10;

//二分查找
public class BiSearch {
    public static int biSearch(int[] a, int elem) {
        int n = a.length;
        int low = 0, high = n - 1, mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == elem) return mid;
            else if (a[mid] < elem) low = mid + 1;//往右查找
            else high = mid - 1;//往左查找
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 5, 7, 9, 11, 13, 15, 17, 20};
        //elem:待查找元素
        int n = 10, elem = 11, i;

        if ((i = biSearch(test, elem)) != -1)
            System.out.println("查找成功! 该对象为第" + i + "个对象");
        else System.out.println("查找失败! 该对象在对象集合中不存在");
    }
}
