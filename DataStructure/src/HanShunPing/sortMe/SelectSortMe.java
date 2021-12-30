package HanShunPing.sortMe;

import java.util.Arrays;

public class SelectSortMe {
    public static void main(String[] args) {
        int[] arr = {10, 11, 5, 7, 1, 8};
        selectSort(arr);
    }

    public static void selectSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
//        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //找到后半段最小值
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                flag = true;
            }

            if (!flag) {
                break;
            } else {
                flag = false;
            }
            System.out.println("第" + (i + 1) + "次");
            System.out.println(Arrays.toString(arr));


        }
    }
}
