package chap6.seqstack2maze;

public class MazePath {
    int count = 1; // 路径数计数器，记录共有多少条路径
    int MaxSize;// 迷宫中方格总数
    int minlen; // 记录最短路径长度（即经历的方块个数最少）
    int M, N;// M迷宫行数，N迷宫列数
    int i, j, di, find, k;
    Mazeunit[] path; // 记录路径数组（存放最短路径）
    Mazeunit temp1 = new Mazeunit(i, j, di); // 工作单元
    Mazeunit temp2 = new Mazeunit(i, j, di);
    Mazeunit temp3 = new Mazeunit();
    SeqStack mystack;

    public MazePath(int x1, int y1, int x2, int y2, int[][] maze) {// 路径为从<x1,y1>到<x2,y2>
        M = x2;
        N = y2;
        MaxSize = (M + 2) * (N + 2);
        minlen = MaxSize;
        mystack = new SeqStack(MaxSize);
        path = new Mazeunit[MaxSize];
        for (int h = 0; h < MaxSize; h++)
            path[h] = new Mazeunit();
        temp1.i = x1;
        temp1.j = y1;
        temp1.di = -1;
        mystack.Push(temp1);// 初始化方块进栈
        maze[x1][y1] = -1;
        while (mystack.NotEmpty()) {// 栈不空时循环
            temp2.i = mystack.GetTop().i;
            temp2.j = mystack.GetTop().j;
            temp2.di = mystack.GetTop().di;
            i = temp2.i;
            j = temp2.j;
            di = temp2.di;
            if (i == M && j == N) { // 找到了出口路径
                System.out.println("第" + count++ + "条路径是：");
                for (k = 0; k < mystack.top; k++) {
                    temp1 = mystack.GetElement(k);
                    System.out.print("(" + temp1.i + "," + temp1.j + ")");
                }
                System.out.println();
                if (mystack.top < minlen) {// 比较最短路径
                    for (k = 0; k < mystack.top; k++) {
                        path[k].i = mystack.GetElement(k).i;
                        path[k].j = mystack.GetElement(k).j;
                        path[k].di = mystack.GetElement(k).di;
                    }
                    minlen = mystack.top;
                }
                temp1 = mystack.Pop();// 栈顶元素出栈
                maze[temp1.i][temp1.j] = 0; // 让该方块变为其它路径可走方块
                temp2.i = mystack.GetTop().i;
                temp2.j = mystack.GetTop().j;
                temp2.di = mystack.GetTop().di;
                i = temp2.i;
                j = temp2.j;
                di = temp2.di;
            }
            find = 0;
            while (di < 4 && find == 0) {// 找下一个可走方块
                di++;
                switch (di) {
                case 0:
                    i = temp2.i - 1;
                    j = temp2.j;
                    break;
                case 1:
                    i = temp2.i;
                    j = temp2.j + 1;
                    break;
                case 2:
                    i = temp2.i + 1;
                    j = temp2.j;
                    break;
                case 3:
                    i = temp2.i;
                    j = temp2.j - 1;
                    break;
                }
                if (maze[i][j] == 0)
                    find = 1;
            }
            if (find == 1) { // 找到了下一个可走方案
                mystack.GetTop().di = di;
                // +++++++++++++++++++++++++++++++++
                temp3.i = i;
                temp3.j = j;
                temp3.di = -1;
                mystack.Push(temp3); // 下一个可走方块进栈
                maze[i][j] = -1; // 避免重复走到该方块
            } else { // 没有路径可走,则退栈
                temp1 = mystack.Pop();
                maze[temp1.i][temp1.j] = 0; // 让该位置变为其他路径可走方块
            }
        }

        System.out.println("最短路径如下：");
        System.out.println("长度" + minlen);
        System.out.println("路径：   ");
        for (k = 0; k < minlen; k++)
            System.out.print("(" + path[k].i + "," + path[k].j + ")");
    }
}
