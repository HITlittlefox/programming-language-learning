package chap10;

//������������������
public class BiTreeNode {
    private BiTreeNode leftChild;
    private BiTreeNode rightChild;
    private BiTreeNode parent;
    private int data;

    //ͷ���
    public BiTreeNode() {
        leftChild = null;
        rightChild = null;
    }

    //Ҷ���
    public BiTreeNode(int item) {
        leftChild = null;
        rightChild = null;
        data = item;
    }

    //��֧���
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
