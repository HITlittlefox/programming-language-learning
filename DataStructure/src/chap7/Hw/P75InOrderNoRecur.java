package chap7.Hw;


import chap7.Hw.tool.BiTreeNode;
import chap7.Hw.tool.LinStack;
import chap7.Hw.tool.Visit;

class Node{
    public char val;
    public Node left;//����
    public Node right;//�Һ���
    //Ϊʲô��val�����Ͷ���Ϊchar���ͣ�����ľ�����ĸ�أ���������Ϊint��������ľ���ASCII���Ӧ��ֵ������
    //������Ϊ�������Σ�һ�ö���������ֵ��������ĸ�����val����Ϊ���͵ģ�����������֣��ѵ������ĸ��
    //Ҫ�����ĸ�϶�Ҫ����Ϊ�ַ����Ͱ�������<=�ҷ��Ĵ���=>�ر����׺��ӵ����⣡
    public Node(char val){
        this.val=val;
    }
}
public class P75InOrderNoRecur {
    public static void main(String[] args) throws Exception {

        //Hw722
        Node root = buildTree();
        P75InOrderNoRecur.getLeafSize(root);
        System.out.println("Hw722��");
        System.out.println("Ҷ�ӽ��ĸ���Ϊ��" + leafSize);

        System.out.println("==================");
        //P75
        BiTreeNode root1;
        BiTreeNode temp = null;
        Visit vs = new Visit();//����Visit�����vs
        root1 = makeTree();
        System.out.println("����̲�p75��");
        inOrderNoRecur(root1, vs);
    }

    // ����������ж��ٸ���Ҷ��㡱
    public static int leafSize = 0;//��¼��Ҷ��㡱�ĸ���

    public static void getLeafSize(Node root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {//����ǰ���������Һ��Ӿ�Ϊ��ʱ���ø�������һ����Ҷ��㡱
            leafSize++;//����++
        } else {//����Ļ��ͼ������������������Һ��Ӿ�Ϊ�յĽ�㣬�ҵ��˾�++
            getLeafSize(root.left);
            getLeafSize(root.right);
        }
    }

    public static BiTreeNode getTreeNode(Object item, BiTreeNode left, BiTreeNode right) {
        BiTreeNode temp = new BiTreeNode(item, left, right);
        return temp;
    }

    // Hw722���������
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
        B.right = E;//�����ǹ���������Ĺؼ�
        C.left = F;
        C.right = G;
        E.right = H;
        return A;
    }

    //p75���������
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


    //�ǵݹ���������������ң�
    private static void inOrderNoRecur(BiTreeNode t, Visit vs) throws Exception {
        LinStack s = new LinStack();
        BiTreeNode curr = t;
        while (curr != null || s.notEmpty()) {
            //���Ӷ���ջ
            while (curr != null) {
                s.push(curr);
                curr = curr.getLeft();
            }

            //�����ջ��Ϊ�գ���Ҫ���ʳ�ջ
            if (s.notEmpty()) {
                curr = (BiTreeNode) s.pop();
                vs.print(curr.data);
                curr = curr.getRight();
            }
        }
    }

}
