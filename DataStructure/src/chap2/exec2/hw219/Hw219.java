package chap2.exec2.hw219;

// 2-19带头节点单链表A中的元素序列，逆置后存储到带头节点单链表B中
public class Hw219 {
    // 传入一个head
    // 2-19带头节点单链表A中的元素序列，逆置后存储到带头节点单链表B中
    public void converse(Node head, Node head2) {
        Node p, q, p2;
        // 释放一个head
        p = head.next;
        p2 = head2.next;
        // 传入的节点后面有元素，如 head,1,2,3
        // p是1
        head.next = null;
        head2.next = null;
        while (p != null) {
            // q是1，p是2，
            q = p;
            p = p.next;
            // 原来的node，第一次循环后，也就是head->1->null
            // 插到B表中
            q.next = head2.next;
            // q.next = null;
            head2.next = q;
        }
    }

    public static void main(String[] args) {
        Hw219 ex = new Hw219();
        Node head = new Node();
        Node head2 = new Node();
        Node p = head;
        Node p2 = head2;
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
        ex.converse(head, head2);

        p2 = head2.next;
        System.out.println();
        System.out.println("Another Node with head, after converse");
        while (p2 != null) {
            System.out.print(p2.data + " ");
            p2 = p2.next;
        }
    }
}

class Node {
    public int data;
    public Node next;
}
