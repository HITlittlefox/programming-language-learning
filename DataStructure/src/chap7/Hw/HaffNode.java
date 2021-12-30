package chap7.Hw;

//基于双亲孩子仿真指针存储结构的哈夫曼树结点类如下：

//每个结点包含以下五个域
public class HaffNode {                        //哈夫曼树的结点类
    public int weight;                            //权值
    int flag;                                //标记
    int parent;                            //双亲结点下标
    public int leftChild;                            //左孩子下标
    public int rightChild;                        //右孩子下标

    public HaffNode() {
    }
}
