package chap8;

// 8-14设计克鲁斯卡尔类。
// 并以图8-10(a)所示的无向连通带权图为例,设计一个测试程序进行测试。
// 对比程序的运行结果是否和图8-12所示的结果一致。
public class hw8_14Kruskal {
    private int edges;
    private char[] vertexs;
    private int[][] arr;
    // private static final int INF = Integer.MAX_VALUE;
    private static final int INF = -1;

    public hw8_14Kruskal(char[] vertexs, int[][] arr) {
        // 顶点个数
        int v = vertexs.length;

        // 初始化顶点的值
        this.vertexs = new char[v];
        for (int i = 0; i < arr.length; i++) {
            this.vertexs[i] = vertexs[i];
        }
        // 边
        this.arr = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                this.arr[i][j] = arr[i][j];
            }
        }
        // 统计边
        for (int i = 0; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                if (this.arr[i][j] != INF) {
                    edges++;
                }
            }
        }
    }

    public void show() {
        System.out.println("邻接矩阵：");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }

    // 对边的权值进行排序
    public void sort(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }
    }

    // 根据顶点返回对应的下标
    public int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    // 获取图的边,放入数组当中,最后遍历数组
    public EData[] getEdges() {
        int index = 0;
        EData[] e = new EData[edges];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (this.arr[i][j] != INF) {
                    // 把这条边加入到数组当中
                    e[index++] = new EData(vertexs[i], vertexs[j], arr[i][j]);
                }
            }
        }
        return e;
    }

    // 获取下标为i的顶点的终点
    public int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public void kruskalAlgorithm() {
        int index = 0;// 最后结果数组的索引
        int[] ends = new int[edges]; // 用于保存已有的最小生成树中的终点
        // 创建结果数组
        EData[] res = new EData[edges];
        // 获取原始图所有边的集合
        EData[] elist = getEdges();
//        System.out.println("elist =" + Arrays.toString(elist) + " , 边 = " + elist.length);
        // 对边进行排序
        sort(elist);
        // 遍历数组,判断准备加入的边是否构成回路
        for (int i = 0; i < edges; i++) {
            // 获取第i条边的第一个顶点和终点
            int p1 = getPosition(elist[i].start);
            int p2 = getPosition(elist[i].end);
            // 对这第一个顶点在最小生成树当中的终点
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            // 判断是否会构成回路
            if (m != n) { //没有构成
                ends[m] = n;
                res[index++] = elist[i];  //把一条边加入
            }
        }
        //统计并打印最小生成树
        System.out.println("最小生成树 = ");
        for (int i = 0; i < index; i++) {
            System.out.println(res[i]);
        }

    }


    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] arr = {
                /* *///A    B   C    D     E   F   G
                /* A*/{0, 50, 60, INF, INF, INF, INF},
                /* B*/{50, 0, INF, 65, 40, INF, INF},
                /* C*/{60, INF, 0, 52, INF, INF, 45},
                /* D*/{INF, 65, 52, 0, 50, 30, 42},
                /* E*/{INF, 40, INF, 50, 0, 70, INF},
                /* F*/{INF, INF, INF, 30, 70, 0, INF},
                /* G*/{INF, INF, 45, 42, INF, INF, 0}};
        hw8_14Kruskal kruskal = new hw8_14Kruskal(vertexs, arr);
        kruskal.show();
        EData[] edges = kruskal.getEdges();
//        System.out.println("未排序 = " + Arrays.toString(edges));
        kruskal.sort(edges);
//        System.out.println("排序 = " + Arrays.toString(edges));
        kruskal.kruskalAlgorithm();
    }
}

//创建一个类,用于表示一条边,俩个顶点和权值
class EData {
    // 边的俩个点
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData[<" + start + " - " + end + "> =" + weight + "]";
    }
}
