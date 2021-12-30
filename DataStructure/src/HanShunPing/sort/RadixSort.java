package HanShunPing.sort;

import java.util.Arrays;
import java.util.Date;

/**
 * title: 基数排序
 *
 * @author 阿K
 * 2020年12月17日 上午12:02:16
 */
public class RadixSort {

    public static void main(String[] args) {

//      int arr[] = { 53, 3, 542, 748, 14, 214 };
//      radixSort2(arr);
//      System.out.println("基数排序后 " + Arrays.toString(arr));

        // 80000000 * 11 * 4 / 1024 / 1024 / 1024 =3.3G
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000); // 生成一个[0, 8000000) 数
        }

        // new RadixSort(arr);
        // new MergeSort(arr);
        new QuickSort(arr);
    }

    public RadixSort(int arr[]) {
        long time = new Date().getTime();
        radixSort2(arr);
        long time2 = new Date().getTime();
        System.out.println("基数排序 排" + (arr.length) + "个数据，使用" + (time2 - time) + "毫秒");
    }

    // 基数排序 Api
    public static void radixSort2(int[] arr) {
        // 根据前面的推导过程，我们可以得到最终的基数排序代码

        // 得到数组中最大的数，的位数
        int max = arr[0];// 假定第一个为最大
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 得到最大数的位数
        int maxLength = (max + "").length();

        // 定义一个二维数组表示 10 个桶（0-9），每个桶是一个一维数组
        // 须知：
        // 1、二维数组中包含 10 个一维数组
        // 2、为防止放入数值的时候数据溢出，则每个一维数组(桶) 的大小定义为 arr.length(要排序的数量)
        // 3、故 基数排序为典型的空间换时间 算法
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中，实际存放数据的个数、我们定义了一个二维数组用来记录每个桶中每次存放数据的个数
        // 第几个桶 bucketElementCounts[0] --- 第一个
        int[] bucketElementCounts = new int[10];

        // 这里使用循环（代替未知轮数）将代码处理
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            // 针对每个元素对应的位数进行处理，第一次是个位，第二次是十位，第三次数百位.....
            for (int j = 0; j < arr.length; j++) {
                // 取出每个元素个位数的值
                int digitOfElement = arr[j] / n % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            // 按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
            int index = 0;
            // 遍历每一个桶，并将桶中数组，放入到原来数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 若桶中有数据，则放入到原来数组
                if (bucketElementCounts[k] != 0) {
                    // 循环该桶的第 J 和元素，既 第 j 个一维数组
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素放入
                        arr[index++] = bucket[k][l];
                    }
                }
                // 第 i+1 轮处理后，需将每个桶 清空 bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;
            }
        }
    }

    // 基数排序 分轮 Api
    public static void radixSort1(int[] arr) {

        // 定义一个二维数组表示 10 个桶（0-9），每个桶是一个一维数组
        // 须知：
        // 1、二维数组中包含 10 个一维数组
        // 2、为防止放入数值的时候数据溢出，则每个一维数组(桶) 的大小定义为 arr.length(要排序的数量)
        // 3、故 基数排序为典型的空间换时间 算法
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中，实际存放数据的个数、我们定义了一个二维数组用来记录每个桶中每次存放数据的个数
        // 第几个桶 bucketElementCounts[0] --- 第一个
        int[] bucketElementCounts = new int[10];

        // 一、基数排序 第一轮(针对每个数的个位数排序处理)
        for (int i = 0; i < arr.length; i++) {
            // 取出每个元素个位数的值
            int digitOfElement = arr[i] / 1 % 10;
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
        int index = 0;
        // 遍历每一个桶，并将桶中数组，放入到原来数组
        for (int j = 0; j < bucketElementCounts.length; j++) {
            // 若桶中有数据，则放入到原来数组
            if (bucketElementCounts[j] != 0) {
                // 循环该桶的第 J 和元素，既 第 j 个一维数组
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    // 取出元素放入
                    arr[index++] = bucket[j][k];
                }
            }
            // 第一轮处理后，需将每个桶 清空 bucketElementCounts[j] = 0
            bucketElementCounts[j] = 0;
        }
        System.out.println("第1轮，对个位的排序处理 arr =" + Arrays.toString(arr));

        // 二、基数排序 第二轮(针对每个数的十位数排序处理)
        for (int i = 0; i < arr.length; i++) {
            // 取出每个元素个位数的值
            int digitOfElement = arr[i] / 1 / 10 % 10;// 748 / 10 => 74 % 10 => 4
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
        int index2 = 0;
        // 遍历每一个桶，并将桶中数组，放入到原来数组
        for (int j = 0; j < bucketElementCounts.length; j++) {
            // 若桶中有数据，则放入到原来数组
            if (bucketElementCounts[j] != 0) {
                // 循环该桶的第 J 和元素，既 第 j 个一维数组
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    // 取出元素放入
                    arr[index2++] = bucket[j][k];
                }
            }
            // 第一轮处理后，需将每个桶 清空 bucketElementCounts[j] = 0
            bucketElementCounts[j] = 0;
        }
        System.out.println("第2轮，对个位的排序处理 arr =" + Arrays.toString(arr));

        // 三、基数排序 第三轮(针对每个数的百位数排序处理)
        for (int i = 0; i < arr.length; i++) {
            // 取出每个元素个位数的值
            int digitOfElement = arr[i] / 1 / 10 / 10 % 10;// 748 / 10 /10 => 7 % 10 => 7
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }
        // 按照这个桶的顺序（一维数组的下标依次取出数据，放入原来的数组）
        int index3 = 0;
        // 遍历每一个桶，并将桶中数组，放入到原来数组
        for (int j = 0; j < bucketElementCounts.length; j++) {
            // 若桶中有数据，则放入到原来数组
            if (bucketElementCounts[j] != 0) {
                // 循环该桶的第 J 和元素，既 第 j 个一维数组
                for (int k = 0; k < bucketElementCounts[j]; k++) {
                    // 取出元素放入
                    arr[index3++] = bucket[j][k];
                }
            }
            // 第一轮处理后，需将每个桶 清空 bucketElementCounts[j] = 0
            bucketElementCounts[j] = 0;
        }
        System.out.println("第3轮，对个位的排序处理 arr =" + Arrays.toString(arr));

    }

}
