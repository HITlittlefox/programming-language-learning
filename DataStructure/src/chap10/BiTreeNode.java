package chap10;

//三叉链结点类设计如下
public class BiTreeNode {
    private BiTreeNode leftChild;
    private BiTreeNode rightChild;
    private BiTreeNode parent;
    private int data;

    //头结点
    public BiTreeNode() {
        leftChild = null;
        rightChild = null;
    }

    //叶结点
    public BiTreeNode(int item) {
        leftChild = null;
        rightChild = null;
        data = item;
    }

    //分支结点
    public BiTreeNode(int item, BiTreeNode left, BiTreeNode right) {
        leftChild = left;
        rightChild = right;
        data = item;
    }

    public void setParent(BiTreeNode parent) {
        this.parent = parent;
    }

    public BiTreeNode getParent() {
        return parent;
    }

    public void setLeftChild(BiTreeNode left) {
        leftChild = left;
    }

    public void setRightChild(BiTreeNode right) {
        rightChild = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BiTreeNode getLeftChild() {
        return leftChild;
    }

    public BiTreeNode getRightChild() {
        return rightChild;
    }

    public int getData() {
        return data;
    }
}
