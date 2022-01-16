//package chap8;
//
////则在矩阵中某个点的入度和出度即为横向和纵向的有效权值个数
//public class hw89 {
//    static final int maxWeight = 10000;
//    static final int MAX_WEIGHT = 10000;
//
//    /**
//     * 获取某个顶点的出度
//     *
//     * @param index 顶点序号
//     * @return 出度
//     */
//    public static int getOutDegree(int index, int vertexSize, int[] groupNum) {
//        int degree = 0;
//        for (int i = 0; i < vertexSize; i++) {
//            int weight = groupNum[i];
//            if (weight > 0 && weight < maxWeight) {
//                degree++;
//            }
//        }
//        return degree;
//    }
//
//    /**
//     * 获取某个顶点的入度
//     *
//     * @param index 顶点序号
//     * @return 入度
//     */
//    public static int getInDegree(int index, int vertexSize, int[] groupNum) {
//        int degree = 0;
//        for (int i = 0; i < vertexSize; i++) {
//            int weight = matrix[i][index];
//            if (weight > 0 && weight < maxWeight) {
//                degree++;
//            }
//        }
//        return degree;
//    }
//
//    public static void main(String[] args) throws Exception {
//        int n = 5, e = 5;
//
//        AdjMWGraph g = new AdjMWGraph(n);
//        Character[] a = {new Character('A'), new Character('B'), new Character('C'), new Character('D'), new Character('E')};
//        RowColWeight[] rcw = {new RowColWeight(0, 1, 10), new RowColWeight(0, 4, 20), new RowColWeight(1, 3, 30), new RowColWeight(2, 1, 40), new RowColWeight(3, 2, 50)};
//
//        RowColWeight.createGraph(g, a, n, rcw, e);
////        getOutDegree(1, 2, g);
//
//        int[] graph0 = new int[]{0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
//        int[] graph1 = new int[]{10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12};
//        int[] graph2 = new int[]{MAX_WEIGHT, 18, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8};
//        int[] graph3 = new int[]{MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, MAX_WEIGHT, 16, 21};
//        int[] graph4 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT};
//        int[] graph5 = new int[]{11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT};
//        int[] graph6 = new int[]{MAX_WEIGHT, 16, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT};
//        int[] graph7 = new int[]{MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT};
//        int[] graph8 = new int[]{MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};
//
//        System.out.println(getOutDegree(0, graph0.length, graph0));
//    }
//}
