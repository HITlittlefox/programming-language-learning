package HanShunPing.sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
//        int arr[] = {3, 9, -1, 10, 20};
        //排序次数：length-1
        //为了容易理解，我们把冒泡排序的演变过程，给大家展示

        //测试封装后的冒泡排序
        System.out.println("冒泡排序前");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("冒泡排序后");
        System.out.println(Arrays.toString(arr));

//        //速度test
//        //测试一下冒泡排序的速度O(n^2)，给8w个数据测试
//        //创建一个8w个的随机数组
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000);// 生成一个[0,80000)数
//        }
//        new BubbleSort(arr);
    }

    public BubbleSort(int[] arr) {
        long time = new Date().getTime();
        bubbleSort(arr);
        long time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");
    }


    //将前面的冒泡排序算法，封装成一个方法
    public static void bubbleSort(int[] arr) {
        //第一趟排序，就是将最大的数排在后面
        //时间复杂度O(n^2)
        int temp = 0;//临时变量

        //标识遍历，表示是否进行过交换
        boolean flag = false;

        for (int i = 0; i < arr.length - 1; i++) {
            //i：0，1，2，3
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序后的数组");//10最大，应该在最后面
            System.out.println(Arrays.toString(arr));

            if (!flag) {//在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false;//重置flag，进行下次判断
            }

        }


    }
}
