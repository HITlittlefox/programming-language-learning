package chap9;

import java.util.Date;


import static chap9.BubbleSort.bubbleSort;
import static chap9.HeapSort.heapSort;
import static chap9.InsertSort.insertSort;
import static chap9.MergeSort.mergeSort;
import static chap9.QuickSort.quickSort;
import static chap9.RadixSort.radixSort;
import static chap9.SelectSort.selectSort;
import static chap9.ShellSort.shellSort;

public class Hw922SpeedTest {
    public static int[] createArr() {
        // 用随机数产生100000个待排序数据元素值
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
        return arr;
    }

    public Hw922SpeedTest() {

        // 插入排序测速
        // 用随机数产生100000个待排序数据元素值
        int[] arr = createArr();
        System.out.print("(1)直接插入排序InsertSort:");
        long time = new Date().getTime();
        insertSort(arr);
        long time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");

        // 希尔排序测速
        // 用随机数产生100000个待排序数据元素值
        arr = createArr();
        System.out.print("(2)希尔排序ShellSort:");
        time = new Date().getTime();
        int dCount = 0;
        int testLength = arr.length;
        int j = 0;
        while (testLength != 1) {
            testLength = testLength / 2;
            dCount++;
        }
//        System.out.println("dCount=" + dCount);
        int[] d2 = new int[dCount];
        testLength = arr.length;
        for (int k = 0; k < dCount; k++) {
            testLength = testLength / 2;
            d2[k] = testLength;
        }
//        System.out.println(Arrays.toString(d2));
        int numOfD = dCount;
        testLength = arr.length;
        shellSort(arr, d2, numOfD);
        time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");

        // 选择排序测速
        // 用随机数产生100000个待排序数据元素值
        arr = createArr();
        System.out.print("(3)直接选择排序SelectSort:");
        time = new Date().getTime();
        selectSort(arr);
        time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");

        // 堆排序测速
        // 用随机数产生100000个待排序数据元素值
        arr = createArr();
        System.out.print("(4)堆排序HeapSort:");
        time = new Date().getTime();
        heapSort(arr);
        time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");

        // 冒泡排序测速
        // 用随机数产生100000个待排序数据元素值
        arr = createArr();
        System.out.print("(5)冒泡排序BubbleSort:");
        time = new Date().getTime();
        bubbleSort(arr);
        time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");

        // 快速排序测速
        // 用随机数产生100000个待排序数据元素值
        arr = createArr();
        System.out.print("(6)快速排序QuickSort:");
        time = new Date().getTime();
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
        time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");

        // 归并排序测速
        // 用随机数产生100000个待排序数据元素值
        arr = createArr();
        System.out.print("(7)归并排序MergeSort:");
        time = new Date().getTime();
        mergeSort(arr);
        time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");

        // 基数排序测速
        // 用随机数产生100000个待排序数据元素值
        arr = createArr();
        System.out.print("(8)基数排序RadixSort:");
        time = new Date().getTime();
        int n = arr.length;
        int m = 5, d = 10;

        try {
            radixSort(arr, m, d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");


    }

    public static void main(String[] args) {
        System.out.println("100000个元素值排序消耗时间(每使用一个排序算法，重新生成一个数组):");
        new Hw922SpeedTest();
    }
}
