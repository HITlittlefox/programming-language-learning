//package chap7.Hw;
//
////������������������ģ�����Ҷ�ӽ��������⣬��ʹ�õı���������ǰ�����
//
//
//public class Hw722 {
//    public static void main(String[] args) {
//        Hw722 hw722 = new Hw722();
//        Node root = hw722.buildTree();
//        hw722.getLeafSize(root);
//        System.out.println("Ҷ�ӽ��ĸ���Ϊ��" + leafSize);
//    }
//
//    // 1�����������
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
//        B.right = E;//�����ǹ���������Ĺؼ�
//        C.left = F;
//        C.right = G;
//        E.right = H;
//        return A;
//    }
//
//
//    // ����������ж��ٸ���Ҷ��㡱
//    public static int leafSize = 0;//��¼��Ҷ��㡱�ĸ���
//
//    public void getLeafSize(Node root) {
//        if (root == null) {
//            return;
//        }
//        if (root.left == null && root.right == null) {//����ǰ���������Һ��Ӿ�Ϊ��ʱ���ø�������һ����Ҷ��㡱
//            leafSize++;//����++
//        } else {//����Ļ��ͼ������������������Һ��Ӿ�Ϊ�յĽ�㣬�ҵ��˾�++
//            getLeafSize(root.left);
//            getLeafSize(root.right);
//        }
//    }
//
//}
//
//class Node {
//    public char val;
//    public Node left;//����
//    public Node right;//�Һ���
//
//    //�����ĸ,����Ϊ�ַ�����
//    public Node(char val) {
//        this.val = val;
//    }
//}
