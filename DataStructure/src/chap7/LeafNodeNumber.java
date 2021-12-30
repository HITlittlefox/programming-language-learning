package chap7;


public class LeafNodeNumber {
    static int count = 0;

    public static void main(String[] args) {
        //����Ҫ����һ�Ŷ�����
        BinaryTree binaryTree = new BinaryTree();
        //������Ҫ�Ľ��
        NodeTest root = new NodeTest(1, "�ν�");
        NodeTest node2 = new NodeTest(2, "����");
        NodeTest node3 = new NodeTest(3, "¬����");
        NodeTest node4 = new NodeTest(4, "�ֳ�");
        NodeTest node5 = new NodeTest(5, "��ʤ");

        //˵�������ֶ������ö�������������ѧϰʹ�õݹ鷽ʽ����������
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        //����
        System.out.println("ǰ�����");//1,2,3,4
        //1,2,3,5,4
        binaryTree.preOrder();
        System.out.println("Ҷ������" + count);
    }
}

//����BinaryTree������
class BinaryTree {
    private NodeTest root;

    public void setRoot(NodeTest root) {
        this.root = root;
    }


    //ǰ�����
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("������Ϊ�գ��޷�����");
        }

    }

}

//�ȴ���NodeTest���
class NodeTest {
    private int no;
    private String name;
    private NodeTest left;
    private NodeTest right;

    public NodeTest(int no, String name) {
        this.no = no;
        this.name = name;

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeTest getLeft() {
        return left;
    }

    public void setLeft(NodeTest left) {
        this.left = left;
    }

    public NodeTest getRight() {
        return right;
    }

    public void setRight(NodeTest right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "NodeTest{" + "no=" + no + ", name='" + name + '\'' + '}';
    }


    //��дǰ������ķ���
    public void preOrder() {

        //��������ڵ�
        System.out.println(this);
        //�ݹ���������ǰ�����
        if (this.left != null) {
            this.left.preOrder();
        }
        //�жϣ��ݹ���������ǰ�����
        if (this.right != null) {
            this.right.preOrder();
        }

    }



}

