package HanShunPing.sort;

import java.util.Arrays;
import java.util.Date;

// ��n���������Ԫ�ؿ���Ϊһ��������һ�������
// ��ʼʱ�������ֻ����һ��Ԫ�أ�������а�����n-1��Ԫ�أ�
// ���������ÿ�δ��������ȡ����һ��Ԫ�أ�
// �����������������������Ԫ�ص���������бȽϣ�
// �������뵽������е��ʵ�λ�ã�ʹ֮��Ϊ�µ������
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {110, 34, -1, 119, 1, 89};
//        System.out.println(Arrays.toString(arr));
        insertSort(arr);
//      System.out.println(Arrays.toString(arr));

//        // ����Ҫ��80000�������������
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
        System.out.println("ʹ���ˣ�" + (time2 - time) + "����");
    }

    //��������
    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        //ʹ�����Ƶ��ķ�ʽ�����⣬�������
        //��1�� {101, 34, 119, 1}
        //ʹ��forѭ�����Ѵ����
        for (int i = 0; i < arr.length; i++) {
            //������������
            insertVal = arr[i];
            insertIndex = i - 1;//��arr[i]��ǰ����������±�
            //��insertVal��"ǰ�������"���ҵ������λ��
            // ˵��
            // 1. insertIndex >=0 ��֤�ڸ�insertVal�Ҳ���λ��,��Խ��
            // 2. insertVal < arr[insertIndex]���������,��û���ҵ�����λ��
            // 3. ����Ҫ��arr[insertIndex]����
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];//arr[insertIndex]
                insertIndex--;
            }
            // ���˳�whileѭ��ʱ��˵�������λ���ҵ�, insertIndex + 1
            // �ж��Ƿ���Ҫ��ֵ
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
            System.out.println("��" + (i + 1) + "��");
            System.out.println(Arrays.toString(arr));
        }
    }
}
