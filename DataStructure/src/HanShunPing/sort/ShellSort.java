package HanShunPing.sort;

import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
////        shellSort(arr);//����ʽ
//        System.out.println("===");
//        shellSort(arr);//��λʽ

        //�ٶ�test
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        new ShellSort(arr);
    }

    //ʹ�����Ƶ��ķ�ʽ����дϣ������
    //���������ƶ���
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        //����ǰ����𲽷�����ʹ��ѭ������
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                //�������������е�Ԫ�أ�����gap�飬ÿ����()Ԫ��,����gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    //����С��������
                    // �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵����Ҫ����
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("ϣ�������" + (++count) + "��=" + Arrays.toString(arr));
        }
    }

    //�Խ���ʽ��ϣ����������Ż�->��λ��
    public static void shellSort2(int[] arr) {
        int count = 0;
        //����gap��������С����
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                //��������
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //�ƶ�
                        //��������һ��һ���Ļ���λ���ϣ��ƶ��������ҵ�λ��Ȼ��ֱ�ӻ���ȥ
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //���˳�while���͸�temp�ҵ�����λ��
                    arr[j] = temp;
                }
            }
//            System.out.println("ϣ�������" + (++count) + "��=" + Arrays.toString(arr));
        }
    }

    //
    public ShellSort(int[] arr) {
        long time = new Date().getTime();
        shellSort2(arr);
        long time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");
    }
}
