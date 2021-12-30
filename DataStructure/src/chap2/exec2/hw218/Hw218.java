package chap2.exec2.hw218;

// 2-18带头节点单链表A中的元素序列就地逆置
public class Hw218 {
    // 传入一个head

    // 2-18带头节点单链表A中的元素序列就地逆置
    public void converse(Node head) {
        Node p, q;
        // 释放一个head
        p = head.next;
        // 传入的节点后面有元素，如 head,1,2,3
        // p是1
        head.next = null;
        while (p != null) {
            // q是1，p是2，
            q = p;
            // p是下一位
            p = p.next;
            // 原来的node，第一次循环后，也就是head->1->null
            //q往前走
            q.next = head.next;
            //head置最前
            head.next = q;
        }
    }

    public static void main(String[] args) {
        Hw218 ex = new Hw218();
        Node head = new Node();
        Node p = head;
        for (int i = 0; i < 10; i++) {
            // 随机数
            int m = (int) (Math.random() * 100);
            Node node = new Node();
            node.data = m % 10;
            System.out.print(m % 10 + " ");
            p.next = node;
            p = p.next;
        }
        // 传入一个head
        ex.converse(head);

        p = head.next;
        System.out.println();
        System.out.println("after converse");
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
    }
}

class Node {
    public int data;
    public Node next;
}
