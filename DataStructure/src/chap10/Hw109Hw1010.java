package chap10;

public class Hw109Hw1010 {
    public static void main(String[] args) {
        BiSearchTree searchTree = new BiSearchTree();
        int[] a = {4, 5, 7, 2, 1, 9, 8, 11, 3};
        int n = 9;
        Visit vs = new Visit();
        BiTreeNode temp = new BiTreeNode(a[0]);

        for (int i = 1; i < n; i++) {
            searchTree.insert(temp, a[i]);
        }
        searchTree.setRoot(temp);

        System.out.println("������ɺ�");
        System.out.print("�����������Ϊ��");
        searchTree.inOrder(vs);
        System.out.print("\nǰ���������Ϊ��");
        searchTree.preOrder(vs);
        System.out.println();

        System.out.print("ѭ�����ҵ�����Ԫ��Ϊ��");
        System.out.println(searchTree.find(9).getData());
        System.out.print("�ݹ���ҵ�����Ԫ��Ϊ��9�����Ϊ");
        System.out.println(searchTree.searchBST(temp, 9));

        searchTree.insertBST(0);
        System.out.println("ѭ����ӽ��0��");
        System.out.print("�����������Ϊ��");
        searchTree.inOrder(vs);
        System.out.print("\nǰ���������Ϊ��");
        searchTree.preOrder(vs);
        System.out.println();

        searchTree.delete(searchTree.getRoot(), 4);

        System.out.println("ɾ�����4��");
        System.out.print("�����������Ϊ��");
        searchTree.inOrder(vs);
        System.out.print("\nǰ���������Ϊ��");
        searchTree.preOrder(vs);
        System.out.println();
    }
}
