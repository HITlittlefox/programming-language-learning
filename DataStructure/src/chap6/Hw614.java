package chap6;

import java.util.Arrays;
import java.util.Date;

public class Hw614 {
    public static void main(String[] args) {

        //测试
        int[] arr = {1, 3, 4, 7, 9};
        System.out.println("原数组为" + Arrays.toString(arr));
        int index = binarySearch(arr, 1);
        System.out.println("想要找1，结果为" + index);
        index = binarySearch(arr, 2);
        System.out.println("想要找2，结果为" + index);
        index = binarySearch(arr, 9);
        System.out.println("想要找9，结果为" + index);

//    }

        //速度test
        //测试一下冒泡排序的速度O(n^2)，给8w个数据测试
        //创建一个10000个的随机数组
        int[] arr2 = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arr2[i] = (int) (Math.random() * 1000000);// 生成一个[0,80000)数
        }
        new Hw614(arr2);
        BinarySearchRecur(arr2, 6999, 0, 10000);
    }

    public Hw614(int[] arr) {
        long time = new Date().getTime();
        binarySearch(arr, 6999);
        long time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");
    }

    public static void BinarySearchRecur(int[] a, int x, int low, int high) {
        long time = new Date().getTime();

        int bn = bSearch(a, x, low, high);
        if (bn == -1)
            System.out.println("x不在数组a中");
        else
            System.out.println("x在数组a中，下标为" + bn);

        long time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");
    }


    //二分查找的循环结构函数

    /**
     * @param arr    需要查找的数组，假设arr是升序
     * @param target 需要查找的数
     * @return 返回对应的下表，-1表示没有找到
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {//说明继续查找
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;//向左边查找
            } else {
                left = mid + 1;//向右边查找
            }
        }
        return -1;
    }


    public static int bSearch(int[] a, int x, int low, int high) {
        int mid;

        if (low > high)
            return -1;

        mid = (low + high) / 2;
        if (x == a[mid])
            return mid;
        else if (x < a[mid])
            return bSearch(a, x, low, mid - 1);
        else
            return bSearch(a, x, mid + 1, high);
    }

}
