package chap8;

import java.util.ArrayList;

public class primModify3 {
    /*
     * 参数G：给定的图，其顶点分别为0~G.length-1，相应权值为具体元素的值
     * 函数功能：返回构造生成的最小生成树，以二维数组形式表示，其中元素为0表示最小生成树的边
     */
    public void getMinTree(int[][] G) {
        int[][] result = G;
        int[] vertix = new int[G.length];   //记录顶点是否被访问，如果已被访问，则置相应顶点的元素值为-2
        for (int i = 0; i < G.length; i++)
            vertix[i] = i;
        ArrayList<Integer> listV = new ArrayList<Integer>(); //保存已经遍历过的顶点
        listV.add(0);      //初始随意选择一个顶点作为起始点，此处选择顶点0
        vertix[0] = -2;    //表示顶点0被访问
        while (listV.size() < G.length) {  //当已被遍历的顶点数等于给定顶点数时，退出循环
            int minDistance = Integer.MAX_VALUE;    //用于寻找最小权值，初始化为int最大值，相当于无穷大的意思
            int minV = -1;   //用于存放未被遍历的顶点中与已被遍历顶点有最小权值的顶点
            int minI = -1;   //用于存放已被遍历的顶点与未被遍历顶点有最小权值的顶点  ；即G[minI][minV]在剩余的权值中最小
            for (int i = 0; i < listV.size(); i++) {   //i 表示已被访问的顶点
                int v1 = listV.get(i);
                for (int j = 0; j < G.length; j++) {
                    if (vertix[j] != -2) {    //满足此条件的表示，顶点j未被访问
                        if (G[v1][j] != -1 && G[v1][j] < minDistance) {//G[v1][j]值为-1表示v1和j是非相邻顶点
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
        System.out.println("使用Prim算法，对于给定图中的顶点访问顺序为：");
        System.out.println(listV);
        System.out.println("使用Prim算法，构造的最小生成树的二维数组表示如下（PS：元素为0表示树的边）：");
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
