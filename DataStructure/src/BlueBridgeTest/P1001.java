package BlueBridgeTest;

//С������λ�к��� 2��0��1��9 �����ֺܸ���Ȥ��
// �� 1 �� 40 �������������� 1��2��9��10 �� 32��39 �� 40���� 28 �������ǵĺ��� 574��ƽ������ 14362��
//ע�⣬ƽ������ָ��ÿ�����ֱ�ƽ������͡�
//���ʣ��� 1 �� 2019 �У���������������ƽ�����Ƕ��٣�
public class P1001 {
    public static void main(String[] args) {
//        int aimNumber = 40;
        int aimNumber = 2019;
        int[] target = new int[]{2, 0, 1, 9, 111};
        int total = 0;

        for (int i = 1; i <= aimNumber; i++) {
            for (int j = 0; j < target.length; j++) {
                int k = target[j];
                //��λ��ʮλ����λ��ǧλ
                if ((k == i % 10)//��λ
                        || (i > 10 & i <= 100 & k == ((i - i % 10) / 10))//ʮλ
                        || (i > 100 & i < 1000 & k == (i - (i - i % 10 - (i - i % 10))) / 100)) //��λ
                {
                    total = total + i * i;
                    System.out.println(i);
                    k = 4;
                    break;
                }

            }

        }
        System.out.println("total:" + total);
//        for (int i = 1; i <= 40; i++) {
//            System.out.println("i=" + i);
//            System.out.println("i %10=" + i % 10);
//            System.out.println("(i-i%10)/10=" + (i - i % 10) / 10);
////            System.out.println("i - 10 * (i / 10)=" + (i - 10 * (i / 10)));
//        }


    }
}
