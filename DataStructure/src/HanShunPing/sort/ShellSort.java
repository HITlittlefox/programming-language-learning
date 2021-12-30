package HanShunPing.sort;

import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
////        shellSort(arr);//交换式
//        System.out.println("===");
//        shellSort(arr);//移位式

        //速度test
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        new ShellSort(arr);
    }

    //使用逐步推导的方式来编写希尔排序
    //交换法、移动法
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        //根据前面的逐步分析，使用循环处理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素（共有gap组，每组有()元素,步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    //（从小到大排序）
                    // 如果当前元素大于加上步长后的那个元素，说明需要交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("希尔排序第" + (++count) + "轮=" + Arrays.toString(arr));
        }
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {
        int count = 0;
        //增量gap，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                //插入排序
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        //交换就是一个一个的换到位置上，移动就是先找到位置然后直接换过去
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while，就给temp找到插入位置
                    arr[j] = temp;
                }
            }
//            System.out.println("希尔排序第" + (++count) + "轮=" + Arrays.toString(arr));
        }
    }

    //
    public ShellSort(int[] arr) {
        long time = new Date().getTime();
        shellSort2(arr);
        long time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");
    }
}
