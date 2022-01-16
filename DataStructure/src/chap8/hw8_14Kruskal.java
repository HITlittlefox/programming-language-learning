package chap8;

// 8-14��ƿ�³˹�����ࡣ
// ����ͼ8-10(a)��ʾ��������ͨ��ȨͼΪ��,���һ�����Գ�����в��ԡ�
// �Աȳ�������н���Ƿ��ͼ8-12��ʾ�Ľ��һ�¡�
public class hw8_14Kruskal {
    private int edges;
    private char[] vertexs;
    private int[][] arr;
    // private static final int INF = Integer.MAX_VALUE;
    private static final int INF = -1;

    public hw8_14Kruskal(char[] vertexs, int[][] arr) {
        // �������
        int v = vertexs.length;

        // ��ʼ�������ֵ
        this.vertexs = new char[v];
        for (int i = 0; i < arr.length; i++) {
            this.vertexs[i] = vertexs[i];
        }
        // ��
        this.arr = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                this.arr[i][j] = arr[i][j];
            }
        }
        // ͳ�Ʊ�
        for (int i = 0; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                if (this.arr[i][j] != INF) {
                    edges++;
                }
            }
        }
    }

    public void show() {
        System.out.println("�ڽӾ���");
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = 0; j < vertexs.length; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }

    // �Աߵ�Ȩֵ��������
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

    // ���ݶ��㷵�ض�Ӧ���±�
    public int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    // ��ȡͼ�ı�,�������鵱��,����������
    public EData[] getEdges() {
        int index = 0;
        EData[] e = new EData[edges];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (this.arr[i][j] != INF) {
                    // �������߼��뵽���鵱��
                    e[index++] = new EData(vertexs[i], vertexs[j], arr[i][j]);
                }
            }
        }
        return e;
    }

    // ��ȡ�±�Ϊi�Ķ�����յ�
    public int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public void kruskalAlgorithm() {
        int index = 0;// ��������������
        int[] ends = new int[edges]; // ���ڱ������е���С�������е��յ�
        // �����������
        EData[] res = new EData[edges];
        // ��ȡԭʼͼ���бߵļ���
        EData[] elist = getEdges();
//        System.out.println("elist =" + Arrays.toString(elist) + " , �� = " + elist.length);
        // �Ա߽�������
        sort(elist);
        // ��������,�ж�׼������ı��Ƿ񹹳ɻ�·
        for (int i = 0; i < edges; i++) {
            // ��ȡ��i���ߵĵ�һ��������յ�
            int p1 = getPosition(elist[i].start);
            int p2 = getPosition(elist[i].end);
            // �����һ����������С���������е��յ�
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            // �ж��Ƿ�ṹ�ɻ�·
            if (m != n) { //û�й���
                ends[m] = n;
                res[index++] = elist[i];  //��һ���߼���
            }
        }
        //ͳ�Ʋ���ӡ��С������
        System.out.println("��С������ = ");
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
//        System.out.println("δ���� = " + Arrays.toString(edges));
        kruskal.sort(edges);
//        System.out.println("���� = " + Arrays.toString(edges));
        kruskal.kruskalAlgorithm();
    }
}

//����һ����,���ڱ�ʾһ����,���������Ȩֵ
class EData {
    // �ߵ�������
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
