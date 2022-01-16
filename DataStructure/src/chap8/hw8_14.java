//package chap8;
//
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.Arrays;
//
//
//public class hw8_14 {
//    private char[] vertexs;  //顶点
//    private int edgeNum;  //边的个数
//    private int[][] matrix;  //邻接矩阵
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
//     * @param vertexs 顶点数组
//     * @param matrix  邻接矩阵
//     */
//    //构造器
//    public hw8_14(char[] vertexs, int[][] matrix) {
//        //初始化顶点数
//        int vlen = vertexs.length;
//        this.vertexs = new char[vlen];
//        for (int i = 0; i < vertexs.length; i++) {
//            this.vertexs[i] = vertexs[i];
//        }
//        //初始化边
//        this.matrix = new int[vlen][vlen];
//        for (int i = 0; i < vlen; i++) {
//            for (int j = 0; j < vlen; j++) {
//                this.matrix[i][j] = matrix[i][j];
//            }
//        }
//        //统计边
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
//        int index = 0;  //表示最后结果数组的索引
//        int[] ends = new int[edgeNum];//用于保存已有"最小生成树"中的每个顶点在最小生成树中的终点
//        //创建结果数组,保存最小生成树
//        EData[] rets = new EData[edgeNum];
//        //获取图中所有边的集合
//        EData[] egdes = getEgdes();
//        //按照权值从小到大排序
//        sortEdges(egdes);
//        //遍历edges数组,将边添加到最小生成树,判断准备加入的边是否构成了回路,如果没有,就加入rets,否则不能加入
//        for (int i = 0; i < edgeNum; i++) {
//            //获取到第i条边的第一个顶点(起点)  下标
//            int p1 = getPosition(egdes[i].start);
//            //获取第i条边的第2个顶点  下标
//            int p2 = getPosition(egdes[i].end);
//
//            //获取p1这个顶点在已有最小生成树中的终点
//            int m = getEnd(ends, p1);
//            int n = getEnd(ends, p2);
//            if (m != n) {  //判断是否构成了回路  不等于 没有构成回路
//                ends[m] = n;  //设置m在"已有最小生成树"中的终点
//                rets[index++] = egdes[i];  //有一条边加入到rets数组
//            }
//        }
//        //统计并打印"最小生成树",输出rets
//        System.out.println("最小生成树为:");
//        for (int i = 0; i < index; i++) {
//            System.out.println(rets[i]);
//        }
//    }
//
//    /**
//     * 打印邻接矩阵
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
//     * 对边进行排序
//     *
//     * @param edges 边的集合
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
//     * @param ch 顶点的值
//     * @return 返回顶点的下标  如果找不到 返回-1
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
//     * 获取图中边 放到EData[] 数组中  后面我们需要遍历数组
//     *
//     * @return 形式['A','B',12]
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
//     * 功能:获取下标为i的顶点的终点,用于后面判断两个顶点的终点是否相同
//     *
//     * @param ends 记录各个顶点对应的终点是哪一个,endss数组是在遍历的过程中,逐步生成
//     * @param i    表示对应的顶点对应的下标
//     * @return 返回的就是这个顶点对应的下标
//     */
//    private int getEnd(int[] ends, int i) {
//        while (ends[i] != 0) {
//            i = ends[i];
//        }
//        return i;
//    }
//}
//
////创建一个类EData  它的对象实例就表示一条边
//class EData {
//    char start;  //边的一个点
//    char end; //边的另一点
//    int weight;  //边的权值
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
