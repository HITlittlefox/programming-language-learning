package chap9;

import java.util.Date;


import static chap9.BubbleSort.bubbleSort;
import static chap9.HeapSort.heapSort;
import static chap9.InsertSort.insertSort;
import static chap9.MergeSort.mergeSort;
import static chap9.QuickSort.quickSort;
import static chap9.RadixSort.radixSort;
import static chap9.SelectSort.selectSort;
import static chap9.ShellSort.shellSort;

public class Hw922SpeedTest {
    public static int[] createArr() {
        // �����������100000������������Ԫ��ֵ
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
        return arr;
    }

    public Hw922SpeedTest() {

        // �����������
        // �����������100000������������Ԫ��ֵ
        int[] arr = createArr();
        System.out.print("(1)ֱ�Ӳ�������InsertSort:");
        long time = new Date().getTime();
        insertSort(arr);
        long time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");

        // ϣ���������
        // �����������100000������������Ԫ��ֵ
        arr = createArr();
        System.out.print("(2)ϣ������ShellSort:");
        time = new Date().getTime();
        int dCount = 0;
        int testLength = arr.length;
        int j = 0;
        while (testLength != 1) {
            testLength = testLength / 2;
            dCount++;
        }
//        System.out.println("dCount=" + dCount);
        int[] d2 = new int[dCount];
        testLength = arr.length;
        for (int k = 0; k < dCount; k++) {
            testLength = testLength / 2;
            d2[k] = testLength;
        }
//        System.out.println(Arrays.toString(d2));
        int numOfD = dCount;
        testLength = arr.length;
        shellSort(arr, d2, numOfD);
        time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");

        // ѡ���������
        // �����������100000������������Ԫ��ֵ
        arr = createArr();
        System.out.print("(3)ֱ��ѡ������SelectSort:");
        time = new Date().getTime();
        selectSort(arr);
        time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");

        // ���������
        // �����������100000������������Ԫ��ֵ
        arr = createArr();
        System.out.print("(4)������HeapSort:");
        time = new Date().getTime();
        heapSort(arr);
        time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");

        // ð���������
        // �����������100000������������Ԫ��ֵ
        arr = createArr();
        System.out.print("(5)ð������BubbleSort:");
        time = new Date().getTime();
        bubbleSort(arr);
        time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");

        // �����������
        // �����������100000������������Ԫ��ֵ
        arr = createArr();
        System.out.print("(6)��������QuickSort:");
        time = new Date().getTime();
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
        time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");

        // �鲢�������
        // �����������100000������������Ԫ��ֵ
        arr = createArr();
        System.out.print("(7)�鲢����MergeSort:");
        time = new Date().getTime();
        mergeSort(arr);
        time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");

        // �����������
        // �����������100000������������Ԫ��ֵ
        arr = createArr();
        System.out.print("(8)��������RadixSort:");
        time = new Date().getTime();
        int n = arr.length;
        int m = 5, d = 10;

        try {
            radixSort(arr, m, d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");


    }

    public static void main(String[] args) {
        System.out.println("100000��Ԫ��ֵ��������ʱ��(ÿʹ��һ�������㷨����������һ������):");
        new Hw922SpeedTest();
    }
}
