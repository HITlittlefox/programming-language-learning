package HanShunPing.search;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};

        int findVal = 1000;
        System.out.println(binarySearch(arr, 0, arr.length - 1, findVal));
    }

    /**
     * 二分查找(单数版)
     *
     * @param arr     原始数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找的值
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {

        // 当 left > right 时候，说明已经递归完毕，仍没有找到
        if (left > right) {
            return -1;
        }

        // 折半，取值
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {// 向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {// 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
