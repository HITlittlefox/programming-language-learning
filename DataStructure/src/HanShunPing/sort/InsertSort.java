package HanShunPing.sort;

import java.util.Arrays;
import java.util.Date;

// 把n个待排序的元素看成为一个有序表和一个无序表，
// 开始时有序表中只包含一个元素，无序表中包含有n-1个元素，
// 排序过程中每次从无序表中取出第一个元素，
// 把它的排序码依次与有序表元素的排序码进行比较，
// 将它插入到有序表中的适当位置，使之成为新的有序表。
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {110, 34, -1, 119, 1, 89};
//        System.out.println(Arrays.toString(arr));
        insertSort(arr);
//      System.out.println(Arrays.toString(arr));

//        // 创建要给80000个的随机的数组
//        int[] arr = new int[80000];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }
//        new InsertSort(arr);
    }


    public InsertSort(int[] arr) {
        long time = new Date().getTime();
        insertSort(arr);
        long time2 = new Date().getTime();
        System.out.println("使用了：" + (time2 - time) + "毫秒");
    }

    //插入排序
    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //使用逐步推导的方式来讲解，便于理解
        //第1轮 {101, 34, 119, 1}
        //使用for循环来把代码简化
        for (int i = 0; i < arr.length; i++) {
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1;//即arr[i]的前面这个数的下标
            //给insertVal在"前面有序表"中找到插入的位置
            // 说明
            // 1. insertIndex >=0 保证在给insertVal找插入位置,不越界
            // 2. insertVal < arr[insertIndex]待插入的数,还没有找到插入位置
            // 3. 就需要将arr[insertIndex]后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];//arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
            System.out.println("第" + (i + 1) + "次");
            System.out.println(Arrays.toString(arr));
        }
    }
}
