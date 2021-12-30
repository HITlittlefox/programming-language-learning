package chap9;


//插入排序
//算法思想：
//1. 顺序的把待排序的数据元素按其值的大小插入到已排序数据元素子集合的适当位置。
//2. 子集合的数据元素个数从1增大。
//3. 当子集合大小与集合大小相同时，排序完毕
public class InsertSort {
    public static void insertSort(int[] arr) {
        int i, j, temp;
        int n = arr.length;

        for (i = 0; i < n - 1; i++) {
            //temp待插入的元素
            temp = arr[i + 1];

            j = i;
            //待插入的数,还没有找到插入位置
            while (j > -1 && temp <= arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }


    public static void main(String[] args) {
        int[] test = {64, 5, 7, 89, 6, 24};
        int n = test.length;
//        InsertSortSpeedTest();
		insertSort(test);
		for(int i = 0; i < n; i ++)
			System.out.print(test[i] + "  ");
    }
}
