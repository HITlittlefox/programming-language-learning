package HanShunPing.sort;

import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        // int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        new QuickSort(arr);
        //new MergeSort(arr);
    }

    public MergeSort(int[] arr) {
        int temp[] = new int[arr.length]; // 归并排序需要一个额外空间
        long time = new Date().getTime();
        mergeSort(arr, 0, arr.length - 1, temp);
        long time2 = new Date().getTime();
        System.out.println("并归排序 排" + (arr.length) + "个数据，使用" + (time2 - time) + "毫秒");

    }

    // 并归(分+治)排序 Api
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;// 中间索引

            // 向左递归分解
            mergeSort(arr, left, mid, temp);
            // 向右递归分解
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param arr   排序的原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left; // 初始化 i,左边有序序列的初始索引
        int j = mid + 1;// 初始化 j,右边有序序列的初始索引
        int t = 0; // 指向 temp 数组的当前索引

        // (一)
        // 1、先把左右两边（有序）的数据，按照规则填充到 temp数组
        // 2、直到左右两边有序序列，有一边处理完毕为止
        while (i <= mid && j <= right) {// 执行条件
            // 若左边有序序列的当前元素，小于等于右边有序序列的当前元素
            // 则将左边的当前元素，填充到 temp 数组
            // 之后再 t++, i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {// 反之，将右边有序序列的当前元素填充到 temp 数组中
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        // (二)把有剩下数据的一边的数据，依次全部填充到temp 中
        while (i <= mid) {
            // (1) 左边有序序列的剩余所有元素，填充到 temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {
            // (2) 右边有序序列的剩余所有元素，填充到 temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        // (三)
        // 将 temp 数组拷贝到 arr
        // 注： 并非每次都拷贝所有
        t = 0;
        int tempLeft = left;
        // 第一次合并 tempLeft = 0 , right = 1 // tempLeft = 2 right = 3 // tempLeft=0 right=3
        // 最后一次 tempLeft = 0 right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
