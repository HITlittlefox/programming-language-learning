package chap2.Josephus;

public class TestClass {
    private static HeadOneWayLoopList list;

    public static void main(String[] args) {
        //在list中把节点都加入，带着各自的编号与密码
        list = new HeadOneWayLoopList();
        list.insertNode(new Node(1, 3), 0);
        list.insertNode(new Node(2, 1), 1);
        list.insertNode(new Node(3, 7), 2);
        list.insertNode(new Node(4, 2), 3);
        list.insertNode(new Node(5, 4), 4);
        list.insertNode(new Node(6, 8), 5);
        list.insertNode(new Node(7, 4), 6);
        f(list.index(list.getCurrentSize() - 1), 20);
    }

    public static void f(Node first, int m) {
        if (first.getNext() != first) {
            //应被选出人的上一个人
            for (int i = 0; i < m - 1; i++) {
                first = first.getNext();
            }
            //应被选出人
            Node deletedNode = first.getNext();
            int code = deletedNode.getCode();
            System.out.print("选出" + deletedNode.getNum() + "   ");
            //把“被选出人”的上一个和下一个连上
            first.setNext(deletedNode.getNext());
            //被选出人
            deletedNode.setNext(null);
            list.setCurrentSize(list.getCurrentSize() - 1);
            f(first, code);
        } else {
            System.out.print(first.getNum() + "   ");
        }
    }
}
