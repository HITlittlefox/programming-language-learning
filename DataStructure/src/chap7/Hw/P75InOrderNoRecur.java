package chap7.Hw;


import chap7.Hw.tool.BiTreeNode;
import chap7.Hw.tool.LinStack;
import chap7.Hw.tool.Visit;

class Node{
    public char val;
    public Node left;//左孩子
    public Node right;//右孩子
    //为什么把val的类型定义为char类型，输出的就是字母呢？？？定义为int类型输出的就是ASCII码对应的值？？？
    //首先因为你蠢，其次，一棵二叉树结点的值本来是字母，你把val定义为整型的，它不输出数字，难道输出字母吗？
    //要输出字母肯定要定义为字符类型啊！！！<=我犯的错误=>特别容易忽视的问题！
    public Node(char val){
        this.val=val;
    }
}
public class P75InOrderNoRecur {
    public static void main(String[] args) throws Exception {

        //Hw722
        Node root = buildTree();
        P75InOrderNoRecur.getLeafSize(root);
        System.out.println("Hw722：");
        System.out.println("叶子结点的个数为：" + leafSize);

        System.out.println("==================");
        //P75
        BiTreeNode root1;
        BiTreeNode temp = null;
        Visit vs = new Visit();//创建Visit类对象vs
        root1 = makeTree();
        System.out.println("补充教材p75：");
        inOrderNoRecur(root1, vs);
    }

    // 求二叉树里有多少个“叶结点”
    public static int leafSize = 0;//记录“叶结点”的个数

    public static void getLeafSize(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {//当当前根结点的左右孩子均为空时，该根结点就是一个“叶结点”
            leafSize++;//所以++
        } else {//否则的话就继续遍历，继续找左右孩子均为空的结点，找到了就++
            getLeafSize(root.left);
            getLeafSize(root.right);
        }
    }

    public static BiTreeNode getTreeNode(Object item, BiTreeNode left, BiTreeNode right) {
        BiTreeNode temp = new BiTreeNode(item, left, right);
        return temp;
    }

    // Hw722构造二叉树
    public static Node buildTree() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;//这里是构造二叉树的关键
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    //p75构造二叉树
    public static BiTreeNode makeTree() {
        BiTreeNode b, c, d, e, f, g;

        g = getTreeNode(new Character('G'), null, null);
        d = getTreeNode(new Character('D'), null, g);
        b = getTreeNode(new Character('B'), d, null);
        e = getTreeNode(new Character('E'), null, null);
        f = getTreeNode(new Character('F'), null, null);
        c = getTreeNode(new Character('C'), e, f);
        return getTreeNode(new Character('A'), b, c);
    }


    //非递归中序遍历（中左右）
    private static void inOrderNoRecur(BiTreeNode t, Visit vs) throws Exception {
        LinStack s = new LinStack();
        BiTreeNode curr = t;
        while (curr != null || s.notEmpty()) {
            //左孩子都入栈
            while (curr != null) {
                s.push(curr);
                curr = curr.getLeft();
            }

            //如果堆栈不为空，就要访问出栈
            if (s.notEmpty()) {
                curr = (BiTreeNode) s.pop();
                vs.print(curr.data);
                curr = curr.getRight();
            }
        }
    }

}
