package HanShunPing.sort;

/**
 * title: 堆排序(大顶堆案例--800W数据测试
 *
 * @author 阿K
 * 2021年1月2日 下午11:22:55
 */
public class HeapSort {

    public static void main(String[] args) {
        // 要求将数组进行升序排序
//      int arr[] = {4, 6, 8, 5, 9};
//      heapSort(arr);
//      System.out.println(Arrays.toString(arr));

        // 800w 数据测试
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }
        long time1 = System.currentTimeMillis();
        heapSort(arr);
        long time2 = System.currentTimeMillis();
        System.out.println("堆排序实现大顶堆排序800W数据：" + (time2 - time1) + "毫秒");
    }

    /**
     * 构建堆排序(最终调用)
     *
     * @param arr 传入的数组
     */
    public static void heapSort(int[] arr) {
        int temp = 0;

        // 分步测试
//      adjustHeap(arr, 1, arr.length);
//      System.out.println("第一次" + Arrays.toString(arr)); // 4, 9, 8, 5, 6
//      adjustHeap(arr, 0, arr.length);
//      System.out.println("第二次" + Arrays.toString(arr)); // 9, 6, 8, 5, 4

        // 完整步骤
        // 将无序序列构建成的一个堆，根据升序或者降序，选择大顶堆或者小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        // 将堆顶元素与末尾元素交换，将最大元素 "沉"到数组末端
        // 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，（就这样反复执行 【调整 -> 交换】，直到整个序列有序）
        // 时间复杂度 为线性 O(nlogn)
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 将一个数组（二叉树），调整成一个大顶堆
     * 功能：完成将 以 i 对应的非叶子节点的树调整成大顶堆
     * eg：第一次：int arr[] = {4, 6, 8, 5, 9}; => adjustHeap(i=1) => 得到 {4, 9, 8, 5, 6}
     * eg：第一次：int arr[] = {4, 9, 8, 5, 6}; => adjustHeap(i=0) => 得到 {9, 6, 8, 5, 4}
     *
     * @param arr    待调整的数组
     * @param i      表非叶子节点在数组中的索引
     * @param length 表对多少个元素进行调整（length会逐渐减少，因为被调整好的增加了）
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        // 先取出当前元素的值，报错在临时变量中
        int temp = arr[i];

        // 开始调整
        // 故：k = 2*i+1; 表示 k 是 i节点的左子节点
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {// k=2*k+1 ,k 左子节点的左子节点
            if (k + 1 < length && arr[k] < arr[k + 1]) {// 说明左子节点的值，小于右子节点的值
                k++;// k 指向右子节点
            }
            if (arr[k] > temp) {// 若子节点大于父节点的值
                arr[i] = arr[k]; // 把较大的值赋值给当前节点
                i = k;// 指向 k,继续比较(移动)
            } else {
                break;
            }
        }
        // 当for 循环结束后,已经将以 i 为父节点的树的最大值，放在最顶点(局部)
        arr[i] = temp;// 将 temp放到调整后的位置
    }
}
