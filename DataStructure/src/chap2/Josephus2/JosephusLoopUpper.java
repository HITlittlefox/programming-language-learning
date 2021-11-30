package chap2.Josephus2;

import chap2.Josephus2.JosephusArrayList;
/*
 * 编号为1~N的N个人按顺时针方向围坐一圈，每个人持有一个密码（正整数，可以自由输入），
 * 开始人选一个正整数做为报数上限值M，从第一个人按顺时针方向自1开始顺序报数，报到M时
 * 停止报数。报M的人出列，将他的密码作为新的M值，从他顺时针方向上的下一个人开始从1
 * 报数，如此下去，直到所有人出列为止。
 * */

public class JosephusLoopUpper {
    private Node head;// 头结点
    private Node rear;// 尾节点
    private int size;// 数组大小
    private int M;// 传入的第一个密码

    public JosephusLoopUpper(JosephusArrayList<Integer> list, int M) {
        head = new Node(list.get(0), 0, null);
        rear = head;
        rear.next = head;// 尾节点连接的头结点，形成循环链表
        for (int i = 1; i < list.getSize(); i++) {// 遍历所有人
            rear.next = new Node(list.get(i), i, rear.next);
            rear = rear.next;// 添加人进链表
        }
        size = list.getSize();
        this.M = M;
    }

    public void out() {// 删除人
        Node p = head;
        while (size > 0) {
            for (int i = 1; i <= M - 2; i++) {
                p = p.next;
            }
            Node del = p.next;
            p.next = del.next;
            p = p.next;
            M = del.password;

            System.out.println("del.position:" + del.position + " " + "del.password:" + del.password);
            size--;
        }

    }

    private static class Node {
        int password;// 密码
        int position;// 位置
        Node next;// 要删除的节点

        public Node() {
        }

        public Node(int password, int position, Node next) {
            this.password = password;
            this.next = next;// 链表的下一个节点
            this.position = position;
            System.out.println("nodePosition" + position + ";node内password" + password);
        }
    }

    public static void main(String[] args) {
        // 3 1 7 2 4 8 4
        JosephusArrayList<Integer> list = new JosephusArrayList<>();
        list.addLast(3);
        // 下一行add0.1.2，都会产生一个删除顺序
        // 1354620
        list.addLast(2);
        list.addLast(7);
        list.addLast(2);
        list.addLast(4);
        list.addLast(8);
        list.addLast(4);
        // list.addLast(4);
        JosephusLoopUpper ju = new JosephusLoopUpper(list, 1);
        ju.out();
    }
}
