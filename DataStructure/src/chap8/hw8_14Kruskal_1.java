package chap8;


/**
 * ͼ����С��������kruskal�㷨
 */
public class hw8_14Kruskal_1 {

    private Edge[] edges;
    private int edgeSize;

    public hw8_14Kruskal_1(int edgeSize) {
        this.edgeSize = edgeSize;
        edges = new Edge[edgeSize];
        createEdgeKruskal();
    }

    /**
     * �����ߵļ��ϣ���С����
     */
    private void createEdgeKruskal() {
        Edge edge0 = new Edge(4, 7, 7);
        Edge edge1 = new Edge(2, 8, 8);
        Edge edge2 = new Edge(0, 1, 10);
        Edge edge3 = new Edge(0, 5, 11);
        Edge edge4 = new Edge(1, 8, 12);
        Edge edge5 = new Edge(3, 7, 16);
        Edge edge6 = new Edge(1, 6, 16);
        Edge edge7 = new Edge(5, 6, 17);
        Edge edge8 = new Edge(1, 2, 18);
        Edge edge9 = new Edge(6, 7, 19);
        Edge edge10 = new Edge(3, 4, 20);
        Edge edge11 = new Edge(3, 8, 21);
        Edge edge12 = new Edge(2, 3, 22);
        Edge edge13 = new Edge(3, 6, 24);
        Edge edge14 = new Edge(4, 5, 26);

        edges[0] = edge0;
        edges[1] = edge1;
        edges[2] = edge2;
        edges[3] = edge3;
        edges[4] = edge4;
        edges[5] = edge5;
        edges[6] = edge6;
        edges[7] = edge7;
        edges[8] = edge8;
        edges[9] = edge9;
        edges[10] = edge10;
        edges[11] = edge11;
        edges[12] = edge12;
        edges[13] = edge13;
        edges[14] = edge14;
//        Edge edge0 = new Edge(4, 6, 30);
//        Edge edge1 = new Edge(2, 6, 40);
//        Edge edge2 = new Edge(4, 5, 42);
//        Edge edge3 = new Edge(2, 5, 45);
//        Edge edge4 = new Edge(1, 2, 50);
//        Edge edge5 = new Edge(4, 5, 50);
//
//
//        Edge edge6 = new Edge(2, 4, 52);
//        Edge edge7 = new Edge(1, 2, 60);
//        Edge edge8 = new Edge(3, 4, 65);
//        Edge edge9 = new Edge(6, 7, 70);
//
//
//        edges[0] = edge0;
//        edges[1] = edge1;
//        edges[2] = edge2;
//        edges[3] = edge3;
//        edges[4] = edge4;
//        edges[5] = edge5;
//        edges[6] = edge6;
//        edges[7] = edge7;
//        edges[8] = edge8;
//        edges[9] = edge9;

    }


    /**
     * kruskal�㷨������С������
     */
    public void createMinSpanTreeKruskal() {
        // ����һ��һά���飬�±�Ϊ���ߵ���㣬ֵΪ���ߵ��յ�
        int[] parent = new int[edgeSize];
        for (int i = 0; i < edgeSize; i++) {
            parent[i] = 0;
        }

        int sum = 0;
        for (Edge edge : edges) {

            // �ҵ������յ�����ʱ���������е�������ӵ�
            int start = find(parent, edge.start);
            int end = find(parent, edge.end);

            // ͨ�������յ��ҵ���������ӵ��Ƿ�Ϊͬһ���㣬��������ػ�
            if (start != end) {

                // û�в����ػ�����ʱ�����У����Ϊ�±꣬�յ�Ϊֵ
                parent[start] = end;
                System.out.println("ѡ����С�ߣ�{" + start + "," + end + "}��Ȩֵ��" + edge.weight);
                sum += edge.weight;
            }
        }
        System.out.println("��С��������Ȩֵ�ܺͣ�" + sum);
    }


    /**
     * ��ȡ���ϵ����ڵ�
     */
    private int find(int parent[], int index) {
        while (parent[index] > 0) {
            index = parent[index];
        }
        return index;
    }


    /**
     * ���Ӷ���ı�
     */
    class Edge {

        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }


    public static void main(String[] args) {

        hw8_14Kruskal_1 graphKruskal = new hw8_14Kruskal_1(15);
        graphKruskal.createMinSpanTreeKruskal();

    }

}

