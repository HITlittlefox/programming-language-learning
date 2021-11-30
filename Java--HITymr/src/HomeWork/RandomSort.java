package HomeWork;

public class RandomSort {
    public static void main(String[] args) {
        int[] array = new int[8];
        System.out.println("数组长度：" + array.length);

        // 0~100间随机产生8个数字,并把数字打印出来
        for (int i = 0; i < array.length; i++) {
            // 这里生成随机数的范围是[0,101)
            array[i] = (int) (Math.random() * 101);
            System.out.print(array[i] + " ");
        }

        // 冒泡排序(从前往后两个数进行比较，如果前一个数大于后一个数，则与下一个数交换位置)
        for (int i = 0; i < array.length - 1; i++) {
            //最大的会到最后面
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        // 把排序结果打印出来
        System.out.println("从小到大排序后的结果是:");
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
