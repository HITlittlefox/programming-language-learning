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

        System.out.println("构造完成后：");
        System.out.print("中序遍历序列为：");
        searchTree.inOrder(vs);
        System.out.print("\n前序遍历序列为：");
        searchTree.preOrder(vs);
        System.out.println();

        System.out.print("循环查找的数据元素为：");
        System.out.println(searchTree.find(9).getData());
        System.out.print("递归查找的数据元素为：9，结果为");
        System.out.println(searchTree.searchBST(temp, 9));

        searchTree.insertBST(0);
        System.out.println("循环添加结点0后：");
        System.out.print("中序遍历序列为：");
        searchTree.inOrder(vs);
        System.out.print("\n前序遍历序列为：");
        searchTree.preOrder(vs);
        System.out.println();

        searchTree.delete(searchTree.getRoot(), 4);

        System.out.println("删除结点4后：");
        System.out.print("中序遍历序列为：");
        searchTree.inOrder(vs);
        System.out.print("\n前序遍历序列为：");
        searchTree.preOrder(vs);
        System.out.println();
    }
}
