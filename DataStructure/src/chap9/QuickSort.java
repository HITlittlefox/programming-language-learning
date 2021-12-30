package chap9;

public class QuickSort {
    public static void quickSort(int[] a, int low, int high) {
        int i, j;
        int temp;

        i = low;
        j = high;
        temp = a[low];//取第一个元素为标准数据元素（把i所在的元素保存在一边）

        while (i < j) {
            //在数组的右端扫描
            //j往左走，如果从右往左遍历的数，大于temp，就继续往左遍历，直到ij相遇或者直到遇到第一个小于temp的数
            while (i < j && temp <= a[j]) j--;
            //如果出了while，i仍然在j左边
            if (i < j) {
                //此时把刚才j找到的比temp小的数，放到i
                a[i] = a[j];
                //i往右走一个
                i++;
            }

            //在数组的左端扫描
            //i没有遇到j的时候，并且i所在位置的数小于temp的时候，一直往右遍历，知道ij相遇，或者i遇到一个比temp大的数
            while (i < j && a[i] < temp) i++;
            //如果出了while后，i仍然在j左边
            if (i < j) {
                //此时把刚才j找到的比temp大的数，放到j
                a[j] = a[i];
                //j往右走一个
                j--;
            }
            //最终ij会相遇
        }
        //相遇后，让ij相遇的那个值，变为temp即可
        a[i] = temp;

        if (low < i) quickSort(a, low, i - 1);//对左端子集合递归
        if (i < high) quickSort(a, j + 1, high);//对右端子集合递归
    }

    public static void main(String[] args) {
        int[] test = {60, 55, 48, 37, 10, 90, 84, 36};
        int n = 8;

        quickSort(test, 0, 7);
        for (int i = 0; i < n; i++)
            System.out.print(test[i] + "  ");
    }
}
