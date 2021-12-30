package chap7;


public class LeafNodeNumber {
    static int count = 0;

    public static void main(String[] args) {
        //现需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        NodeTest root = new NodeTest(1, "宋江");
        NodeTest node2 = new NodeTest(2, "吴用");
        NodeTest node3 = new NodeTest(3, "卢俊义");
        NodeTest node4 = new NodeTest(4, "林冲");
        NodeTest node5 = new NodeTest(5, "关胜");

        //说明：先手动创建该二叉树，后面再学习使用递归方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
        //测试
        System.out.println("前序遍历");//1,2,3,4
        //1,2,3,5,4
        binaryTree.preOrder();
        System.out.println("叶结点个数" + count);
    }
}

//定义BinaryTree二叉树
class BinaryTree {
    private NodeTest root;

    public void setRoot(NodeTest root) {
        this.root = root;
    }


    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }

    }

}

//先创建NodeTest结点
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


    //编写前序遍历的方法
    public void preOrder() {

        //先输出父节点
        System.out.println(this);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        //判断，递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }

    }



}

