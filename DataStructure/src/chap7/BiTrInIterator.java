package chap7;

public class BiTrInIterator extends BiTreeInterator {
    private LinStack s = new LinStack();            //创建堆栈类对象s

    public BiTrInIterator(BiTreeNode t) {                //构造函数
        super(t);                                //调用父类的构造函数
    }

    private BiTreeNode goFarLeft(BiTreeNode t) {    //寻找最左孩子结点
        if (t == null) return null;
        while (t.getLeft() != null) {
            s.push(t);
            t = t.getLeft();
        }
        return t;
    }

    public void reset() {                        //覆盖基类的重置成员函数
        if (root == null) iteComplete = 1;        //置结束标记
        else iteComplete = 0;

        if (root == null) return;
        current = goFarLeft(root);
    }

    public void next() {                        //覆盖基类的下一个结点成员函数
        if (iteComplete == 1) {
            System.out.println("已到二叉树尾！");
            return;
        }

        if (current.getRight() != null) {
            current = goFarLeft(current.getRight());
//寻找当前结点右孩子结点的最左孩子结点
        } else if (s.notEmpty()) {                                //若堆栈非空
            try {
                current = (BiTreeNode) s.pop();                //退栈
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            iteComplete = 1;                                //置结束标记
    }
}
