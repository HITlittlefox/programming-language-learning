package chap8;

//8-9编写函数,求邻接矩阵图类的对象G中各结点的入度。
public class hw8_9 {
    private int vertexSize;//顶点数量
    private int[] vertexs;//顶点数组
    private int[][] matrix;    //矩阵
    private static final int MAX_WEIGHT = 1000;

    private boolean[] isVisited;

    //初始化顶点数量、二维矩阵和顶点数组
    public hw8_9(int vertextSize) {
        this.vertexSize = vertextSize;
        matrix = new int[vertexSize][vertexSize];

        vertexs = new int[vertextSize];
        for (int i = 0; i < vertextSize; i++) {
            vertexs[i] = i;
        }

        isVisited = new boolean[vertexSize];

    }

    public int[] getVertexs() {
        return vertexs;
    }

    public void setVertexs(int[] vertexs) {
        this.vertexs = vertexs;
    }

    /*
     * 根据下标获取指定顶点,然后求得指定顶点的出度
     * 求出度看二维矩阵的横排
     * 求入度看二维矩阵的纵排
     */

    /*
     * 获取顶点的入度  (求入度看二维矩阵的纵排)
     */
    public int getInDegree(int index) {
        int degree = 0;
        for (int k = 0; k < matrix[index].length; k++) {
            int weight = matrix[k][index];
            if (weight != 0 && weight != MAX_WEIGHT) {
                degree++;
            }
        }

        return degree;
    }

    public static void main(String[] args) {
        hw8_9 test = new hw8_9(9);

        int[] a1 = new int[]{0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a2 = new int[]{10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12};
        int[] a3 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8};
        int[] a4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, MAX_WEIGHT, 16, 21};
        int[] a5 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT};
        int[] a6 = new int[]{11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT};
        int[] a7 = new int[]{MAX_WEIGHT, 16, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT};
        int[] a8 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT};
        int[] a9 = new int[]{MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};

        test.matrix[0] = a1;
        test.matrix[1] = a2;
        test.matrix[2] = a3;
        test.matrix[3] = a4;
        test.matrix[4] = a5;
        test.matrix[5] = a6;
        test.matrix[6] = a7;
        test.matrix[7] = a8;
        test.matrix[8] = a9;

        int inDegree = test.getInDegree(2);
        System.out.println("求入度看二维矩阵的纵排");
        System.out.println("V2的入度:" + inDegree);

    }
}


