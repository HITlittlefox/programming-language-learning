//package chap7.Hw;
//
////下面的所有求结点总数的，和求叶子结点个数的题，均使用的遍历方法是前序遍历
//
//
//public class Hw722 {
//    public static void main(String[] args) {
//        Hw722 hw722 = new Hw722();
//        Node root = hw722.buildTree();
//        hw722.getLeafSize(root);
//        System.out.println("叶子结点的个数为：" + leafSize);
//    }
//
//    // 1、构造二叉树
//    public Node buildTree() {
//        Node A = new Node('A');
//        Node B = new Node('B');
//        Node C = new Node('C');
//        Node D = new Node('D');
//        Node E = new Node('E');
//        Node F = new Node('F');
//        Node G = new Node('G');
//        Node H = new Node('H');
//        A.left = B;
//        A.right = C;
//        B.left = D;
//        B.right = E;//这里是构造二叉树的关键
//        C.left = F;
//        C.right = G;
//        E.right = H;
//        return A;
//    }
//
//
//    // 求二叉树里有多少个“叶结点”
//    public static int leafSize = 0;//记录“叶结点”的个数
//
//    public void getLeafSize(Node root) {
//        if (root == null) {
//            return;
//        }
//        if (root.left == null && root.right == null) {//当当前根结点的左右孩子均为空时，该根结点就是一个“叶结点”
//            leafSize++;//所以++
//        } else {//否则的话就继续遍历，继续找左右孩子均为空的结点，找到了就++
//            getLeafSize(root.left);
//            getLeafSize(root.right);
//        }
//    }
//
//}
//
//class Node {
//    public char val;
//    public Node left;//左孩子
//    public Node right;//右孩子
//
//    //输出字母,定义为字符类型
//    public Node(char val) {
//        this.val = val;
//    }
//}
