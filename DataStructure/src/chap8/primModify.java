package chap8;

import java.util.Arrays;

/**
 * 普利姆算法
 */
public class primModify {


    public static volatile int MAX = Integer.MAX_VALUE; // 表示到不了的边

    public void createGraph(MGraph graph, int vertex, char[] data, int[][] matrix) {
        for (int k = 0; k < vertex; k++) {
            graph.data[k] = data[k];
            for (int j = 0; j < vertex; j++) {
                graph.matrix[k][j] = matrix[k][j];
            }
        }
    }

    public void showGraph(MGraph graph) {
        for (int i = 0; i < graph.vertex; i++) {
            int link[] = graph.matrix[i];
            System.out.println(Arrays.toString(link).replaceAll(primModify.MAX + "", "∞"));
        }
    }


    public void primCore(MGraph graph, int v) {
        int visited[] = new int[graph.vertex];

        visited[v] = 1;

        int vertex = graph.vertex;
        int minWeight = primModify.MAX;

        for (int k = 1; k < vertex; k++) {

            int t1 = -1;
            int t2 = -1;
            for (int i = 0; i < vertex; i++) {
                for (int j = 0; j < vertex; j++) {
                    boolean flag = visited[i] == 1 && visited[j] == 0 && graph.matrix[i][j] < minWeight;
                    if (flag) {
                        minWeight = graph.matrix[i][j];
                        t1 = i;
                        t2 = j;
                    }
                }
            }

            //找到一条边是最小
            System.out.println("边 <" + graph.data[t1] + "," + graph.data[t2] + "> 权值:" + minWeight);
            visited[t2] = 1;
            minWeight = primModify.MAX;
        }

    }

    public static void main(String[] args) {
        prim();
    }

    public static void prim() {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int MAX = primModify.MAX;

        //邻接矩阵的关系使用二维数组表示,M 这个 表示无穷大的大数，表示两个点不联通
        //     *  | A  |  B  |  C  |  D  |  E  |  F |  G  |
        //     A  | M  |  5  |  7  |  M  |  M  |  M |  2  |
        //     B  | 5  |  M  |  M  |  9  |  M  |  M |  3  |
        //     C  | 7  |  M  |  M  |  M  |  8  |  M |  M  |
        //     D  | M  |  9  |  M  |  M  |  M  |  4 |  M  |
        //     E  | M  |  M  |  8  |  M  |  M  |  5 |  4  |
        //     F  | M  |  M  |  M  |  4  |  5  |  M |  6  |
        //     G  | 2  |  3  |  M  |  M  |  4  |  6 |  M  |
        int[][] weight = new int[][]{
                {MAX, 5, 7, MAX, MAX, MAX, 2},
                {5, MAX, MAX, 9, MAX, MAX, 3},
                {7, MAX, MAX, MAX, 8, MAX, MAX},
                {MAX, 9, MAX, MAX, MAX, 4, MAX},
                {MAX, MAX, 8, MAX, MAX, 5, 4},
                {MAX, MAX, MAX, 4, 5, MAX, 6},
                {2, 3, MAX, MAX, 4, 6, MAX},
        };

        // 生成图
        MGraph mGraph = new MGraph(data.length);

        primModify prim = new primModify();
        prim.createGraph(mGraph, data.length, data, weight);
        prim.primCore(mGraph, 1); // 3 2 4 5 4 7
    }
}

class MGraph {
    int vertex; //节点个数
    char[] data; // 存放节点数据
    int[][] matrix; // 存放边, 邻接矩阵

    public MGraph(int vertex) {
        this.vertex = vertex;
        data = new char[vertex];
        matrix = new int[vertex][vertex];
    }
}

