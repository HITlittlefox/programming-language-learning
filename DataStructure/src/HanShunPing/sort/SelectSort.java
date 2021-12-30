package HanShunPing.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));


//        //速度test
//        //测试一下冒泡排序的速度O(n^2)，给8w个数据测试
//        //创建一个8w个的随机数组
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000);// 生成一个[0,80000)数
//        }
//        new SelectSort(arr);
    }

    public SelectSort(int[] arr) {
        long time = new Date().getTime();
        selectSort(arr);
        long time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");
    }

    //选择排序
    public static void selectSort(int[] arr) {
        //使用逐步推导的方式来，讲解选择排序
        //第1轮
        //原始的数组：101，34，119，1
        //第一轮排序：1，34，119，101
        //算法 先简单-->把复杂算法拆分简单-->逐步解决
        //推导过程中发现规律，可以使用for来解决

        //时间复杂度是O(n^2)，嵌套for循环
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {

                //如果要从大到小排序，就min<arr[j]

                if (min > arr[j]) {//说明假定的最小值，但不是最小
                    min = arr[j];//重置min
                    minIndex = j;//重置minIndex
                }
            }
            //将最小值，放在arr[0]，即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "轮后~~");
            System.out.println(Arrays.toString(arr));
        }
    }
}
