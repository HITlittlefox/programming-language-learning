package chap8;

import java.util.ArrayList;

public class primModify3 {
    /*
     * ����G��������ͼ���䶥��ֱ�Ϊ0~G.length-1����ӦȨֵΪ����Ԫ�ص�ֵ
     * �������ܣ����ع������ɵ���С���������Զ�ά������ʽ��ʾ������Ԫ��Ϊ0��ʾ��С�������ı�
     */
    public void getMinTree(int[][] G) {
        int[][] result = G;
        int[] vertix = new int[G.length];   //��¼�����Ƿ񱻷��ʣ�����ѱ����ʣ�������Ӧ�����Ԫ��ֵΪ-2
        for (int i = 0; i < G.length; i++)
            vertix[i] = i;
        ArrayList<Integer> listV = new ArrayList<Integer>(); //�����Ѿ��������Ķ���
        listV.add(0);      //��ʼ����ѡ��һ��������Ϊ��ʼ�㣬�˴�ѡ�񶥵�0
        vertix[0] = -2;    //��ʾ����0������
        while (listV.size() < G.length) {  //���ѱ������Ķ��������ڸ���������ʱ���˳�ѭ��
            int minDistance = Integer.MAX_VALUE;    //����Ѱ����СȨֵ����ʼ��Ϊint���ֵ���൱����������˼
            int minV = -1;   //���ڴ��δ�������Ķ��������ѱ�������������СȨֵ�Ķ���
            int minI = -1;   //���ڴ���ѱ������Ķ�����δ��������������СȨֵ�Ķ���  ����G[minI][minV]��ʣ���Ȩֵ����С
            for (int i = 0; i < listV.size(); i++) {   //i ��ʾ�ѱ����ʵĶ���
                int v1 = listV.get(i);
                for (int j = 0; j < G.length; j++) {
                    if (vertix[j] != -2) {    //����������ı�ʾ������jδ������
                        if (G[v1][j] != -1 && G[v1][j] < minDistance) {//G[v1][j]ֵΪ-1��ʾv1��j�Ƿ����ڶ���
                            minDistance = G[v1][j];
                            minV = j;
                            minI = v1;
                        }
                    }
                }
            }
            vertix[minV] = -2;
            listV.add(minV);
            result[minI][minV] = 0;
            result[minV][minI] = 0;
        }
        System.out.println("ʹ��Prim�㷨�����ڸ���ͼ�еĶ������˳��Ϊ��");
        System.out.println(listV);
        System.out.println("ʹ��Prim�㷨���������С�������Ķ�ά�����ʾ���£�PS��Ԫ��Ϊ0��ʾ���ıߣ���");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++)
                System.out.print(result[i][j] + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        primModify3 test = new primModify3();
        int[][] G = {{-1, 3, -1, -1, 6, 5},
                {3, -1, 1, -1, -1, 4},
                {-1, 1, -1, 6, -1, 4},
                {-1, -1, 6, -1, 8, 5},
                {6, -1, -1, 8, -1, 2},
                {5, 4, 4, 5, 2, -1}};
        test.getMinTree(G);
    }
}
