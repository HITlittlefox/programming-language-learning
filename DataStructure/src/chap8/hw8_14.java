//package chap8;
//
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.Arrays;
//
//
//public class hw8_14 {
//    private char[] vertexs;  //����
//    private int edgeNum;  //�ߵĸ���
//    private int[][] matrix;  //�ڽӾ���
//    private static final int INT = -1;
//
//    public static void main(String[] args) {
//        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
//        int[][] matrix = {
//                /* *///A    B   C    D     E   F   G
//                /* A*/{0, 50, 60, INT, INT, INT, INT},
//                /* B*/{50, 0, INT, 65, 40, INT, INT},
//                /* C*/{60, INT, 0, 52, INT, INT, 45},
//                /* D*/{INT, 65, 52, 0, 50, 30, 42},
//                /* E*/{INT, 40, INT, 50, 0, 70, INT},
//                /* F*/{INT, INT, INT, 30, 70, 0, INT},
//                /* G*/{INT, INT, 45, 42, INT, INT, 0}
//        };
//        hw8_14 kruskaCase = new hw8_14(vertexs, matrix);
//        kruskaCase.print();
//
//        EData[] egdes = kruskaCase.getEgdes();
//        System.out.println(Arrays.toString(egdes));
//        System.out.println("==========================================================");
//        kruskaCase.sortEdges(egdes);
//        System.out.println(Arrays.toString(egdes));
//        System.out.println("==========================================================");
//        kruskaCase.kruskal();
//    }
//
//    /**
//     * @param vertexs ��������
//     * @param matrix  �ڽӾ���
//     */
//    //������
//    public hw8_14(char[] vertexs, int[][] matrix) {
//        //��ʼ��������
//        int vlen = vertexs.length;
//        this.vertexs = new char[vlen];
//        for (int i = 0; i < vertexs.length; i++) {
//            this.vertexs[i] = vertexs[i];
//        }
//        //��ʼ����
//        this.matrix = new int[vlen][vlen];
//        for (int i = 0; i < vlen; i++) {
//            for (int j = 0; j < vlen; j++) {
//                this.matrix[i][j] = matrix[i][j];
//            }
//        }
//        //ͳ�Ʊ�
//        for (int i = 0; i < vlen; i++) {
//            for (int j = i + 1; j < vlen; j++) {
//                if (this.matrix[i][j] != INT) {
//                    edgeNum++;
//                }
//            }
//        }
//    }
//
//    public void kruskal() {
//        int index = 0;  //��ʾ��������������
//        int[] ends = new int[edgeNum];//���ڱ�������"��С������"�е�ÿ����������С�������е��յ�
//        //�����������,������С������
//        EData[] rets = new EData[edgeNum];
//        //��ȡͼ�����бߵļ���
//        EData[] egdes = getEgdes();
//        //����Ȩֵ��С��������
//        sortEdges(egdes);
//        //����edges����,������ӵ���С������,�ж�׼������ı��Ƿ񹹳��˻�·,���û��,�ͼ���rets,�����ܼ���
//        for (int i = 0; i < edgeNum; i++) {
//            //��ȡ����i���ߵĵ�һ������(���)  �±�
//            int p1 = getPosition(egdes[i].start);
//            //��ȡ��i���ߵĵ�2������  �±�
//            int p2 = getPosition(egdes[i].end);
//
//            //��ȡp1���������������С�������е��յ�
//            int m = getEnd(ends, p1);
//            int n = getEnd(ends, p2);
//            if (m != n) {  //�ж��Ƿ񹹳��˻�·  ������ û�й��ɻ�·
//                ends[m] = n;  //����m��"������С������"�е��յ�
//                rets[index++] = egdes[i];  //��һ���߼��뵽rets����
//            }
//        }
//        //ͳ�Ʋ���ӡ"��С������",���rets
//        System.out.println("��С������Ϊ:");
//        for (int i = 0; i < index; i++) {
//            System.out.println(rets[i]);
//        }
//    }
//
//    /**
//     * ��ӡ�ڽӾ���
//     */
//    public void print() {
//        for (int i = 0; i < vertexs.length; i++) {
//            for (int j = 0; j < vertexs.length; j++) {
//                System.out.printf("%12d", matrix[i][j]);
//            }
//            System.out.println();
//        }
//    }
//
//    /**
//     * �Ա߽�������
//     *
//     * @param edges �ߵļ���
//     */
//    private void sortEdges(EData[] edges) {
//        for (int i = 0; i < edges.length - 1; i++) {
//            for (int j = 0; j < edges.length - 1 - i; j++) {
//                if (edges[j].weight > edges[i].weight) {
//                    EData temp = edges[j];
//                    edges[j] = edges[i];
//                    edges[i] = temp;
//                }
//            }
//        }
//    }
//
//    /**
//     * @param ch �����ֵ
//     * @return ���ض�����±�  ����Ҳ��� ����-1
//     */
//    private int getPosition(char ch) {
//        for (int i = 0; i < vertexs.length; i++) {
//            if (vertexs[i] == ch) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    /**
//     * ��ȡͼ�б� �ŵ�EData[] ������  ����������Ҫ��������
//     *
//     * @return ��ʽ['A','B',12]
//     */
//    private EData[] getEgdes() {
//        int index = 0;
//        EData[] edges = new EData[edgeNum];
//        for (int i = 0; i < vertexs.length; i++) {
//            for (int j = i + 1; j < vertexs.length; j++) {
//                if (matrix[i][j] != INT) {
//                    edges[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
//                }
//            }
//        }
//        return edges;
//    }
//
//    /**
//     * ����:��ȡ�±�Ϊi�Ķ�����յ�,���ں����ж�����������յ��Ƿ���ͬ
//     *
//     * @param ends ��¼���������Ӧ���յ�����һ��,endss�������ڱ����Ĺ�����,������
//     * @param i    ��ʾ��Ӧ�Ķ����Ӧ���±�
//     * @return ���صľ�����������Ӧ���±�
//     */
//    private int getEnd(int[] ends, int i) {
//        while (ends[i] != 0) {
//            i = ends[i];
//        }
//        return i;
//    }
//}
//
////����һ����EData  ���Ķ���ʵ���ͱ�ʾһ����
//class EData {
//    char start;  //�ߵ�һ����
//    char end; //�ߵ���һ��
//    int weight;  //�ߵ�Ȩֵ
//
//    public EData(char start, char end, int weight) {
//        this.start = start;
//        this.end = end;
//        this.weight = weight;
//    }
//
//    @Override
//    public String toString() {
//        return "EData{" +
//                "start=" + start +
//                ", end=" + end +
//                ", weight=" + weight +
//                '}';
//    }
//}
