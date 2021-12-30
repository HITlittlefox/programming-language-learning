package chap7.Hw;
import java.util.Arrays;

public class HwP173 {
    public static void main(String[] args) {
        int n = 4;
        HaffmanTree myHaff = new HaffmanTree(n);
        int[] weight = {1, 3, 5, 7};
        HaffNode[] node = new HaffNode[2 * n - 1];
        Code[] haffCode = new Code[n];

        myHaff.haffman(weight, node);
        myHaff.haffmanCode(node, haffCode);
        //��ӡȨ�����Ӧ����������
        System.out.println("��ӡȨ�����Ӧ����������");
        for (int i = 0; i < n; i++) {
            System.out.print("Weight = " + haffCode[i].weight + " Code = ");
            for (int j = haffCode[i].start + 1; j < n; j++)
                System.out.print(haffCode[i].bit[j]);
        }
        System.out.println("===");


        int[][] codeBottle = new int[4][4];
        //�ѹ��������뱣������
        for (int k = 0; k < n; k++) {
            for (int l = haffCode[k].start + 1; l < n; l++) {
                codeBottle[k][l] = haffCode[k].bit[l];
//                System.out.print(haffCode[k].bit[l]);
            }
        }
        System.out.println();
        System.out.println("===");
        //��ӡ����ƿ��
        System.out.println("��ӡ����ı���");
        for (int i = 0; i < codeBottle.length; i++) {
            System.out.println(Arrays.toString(codeBottle[i]));
        }

        System.out.println("===");
        //�������
        System.out.println("��ӡ�����ı���");
        for (int i = 0; i < codeBottle.length; i++) {
            if (i == 0 || i == 1) {
                codeBottle[i] = Arrays.copyOfRange(codeBottle[i], 1, codeBottle.length);
                System.out.println(Arrays.toString(codeBottle[i]));
            }
            if (i == 2) {
                codeBottle[i] = Arrays.copyOfRange(codeBottle[i], 2, codeBottle.length);
                System.out.println(Arrays.toString(codeBottle[i]));
            }
            if (i == 3) {
                codeBottle[i] = Arrays.copyOfRange(codeBottle[i], 3, codeBottle.length);
                System.out.println(Arrays.toString(codeBottle[i]));
            }
        }

        System.out.println("===");
        //�������������
        System.out.println("�������������:");
        for (int i = 0; i < codeBottle.length; i++) {

//            int[] testDes = new int[]{0, 0, 0};
            translateHaffman(node, codeBottle[i]);
        }


//        Exam7_4.translateHaffman(node);

    }

    //����������
    public static void translateHaffman(HaffNode[] node, int[] bit) {
        int[] testDes = bit;
        int target = 6;
        HaffNode ancestor = node[target];
        HaffNode temp;

        System.out.print("����������" + Arrays.toString(testDes) + "������·����:");
        System.out.print(ancestor.weight + " ");
        temp = ancestor;
        int weightDes = 0;
        for (int i = 0; i < testDes.length; i++) {

            if (testDes[i] == 0) {
                target = temp.leftChild;
                temp = node[target];
                weightDes = temp.weight;
                System.out.print(temp.weight + " ");
            }
            if (testDes[i] == 1) {
                target = temp.rightChild;
                temp = node[target];
                weightDes = temp.weight;
                System.out.print(temp.weight + " ");
            }

        }
        System.out.print(";" + "�������Ȩ���ǣ�" + weightDes);
        System.out.println();

    }


}
