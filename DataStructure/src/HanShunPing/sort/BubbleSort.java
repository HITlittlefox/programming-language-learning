package HanShunPing.sort;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
//        int arr[] = {3, 9, -1, 10, 20};
        //���������length-1
        //Ϊ��������⣬���ǰ�ð��������ݱ���̣������չʾ

        //���Է�װ���ð������
        System.out.println("ð������ǰ");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("ð�������");
        System.out.println(Arrays.toString(arr));

//        //�ٶ�test
//        //����һ��ð��������ٶ�O(n^2)����8w�����ݲ���
//        //����һ��8w�����������
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000);// ����һ��[0,80000)��
//        }
//        new BubbleSort(arr);
    }

    public BubbleSort(int[] arr) {
        long time = new Date().getTime();
        bubbleSort(arr);
        long time2 = new Date().getTime();
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");
    }


    //��ǰ���ð�������㷨����װ��һ������
    public static void bubbleSort(int[] arr) {
        //��һ�����򣬾��ǽ����������ں���
        //ʱ�临�Ӷ�O(n^2)
        int temp = 0;//��ʱ����

        //��ʶ��������ʾ�Ƿ���й�����
        boolean flag = false;

        for (int i = 0; i < arr.length - 1; i++) {
            //i��0��1��2��3
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //���ǰ������Ⱥ���������򽻻�
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("��" + (i + 1) + "������������");//10���Ӧ���������
            System.out.println(Arrays.toString(arr));

            if (!flag) {//��һ�������У�һ�ν�����û�з�����
                break;
            } else {
                flag = false;//����flag�������´��ж�
            }

        }


    }
}
