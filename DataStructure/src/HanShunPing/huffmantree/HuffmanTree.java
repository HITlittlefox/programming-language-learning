package HanShunPing.huffmantree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = creatHuffmanTree(arr);
        //测试一把
        preOrder(root);
    }

    //编写一个前序遍历的方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历~~");
        }
    }

    //创建赫夫曼树的方法

    /**
     * @param arr 需要创建成哈夫曼树的数组
     * @return 创建好后的赫夫曼树的root结点
     */
    public static Node creatHuffmanTree(int[] arr) {
        //第一遍为了操作方便
        //1. 遍历arr数组
        //2. 将arr的每个元素构成一个Node
        //3. 将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        //处理的过程是一个循环的过程
        //最后的时候nodes只剩一个结点
        while (nodes.size() > 1) {

            //排序从小到大
            Collections.sort(nodes);
            System.out.println("nodes=" + nodes);
            //取出根节点权值最小的两颗二叉树
            //1. 取出权值最小的结点(二叉树)
            Node leftNode = nodes.get(0);
            //2. 取出第二小的结点（二叉树）
            Node rightNode = nodes.get(1);
            //3. 构建一棵新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            //4. 从ArrayList中，删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //5. 将parent加入到nodes
            nodes.add(parent);

        }

//        System.out.println("第一次处理后" + nodes);
        //返回哈夫曼树的root结点
        return nodes.get(0);
    }

}

//创建结点类
//为了让Node对象支持排序Collections集合排序，往往需要Node实现Comparable接口
class Node implements Comparable<Node> {
    int value;//结点权值
    Node left;//左子结点
    Node right;//右子结点

    //写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大排序
        //我减它升序  它减我降序
        return this.value - o.value;
    }
}
