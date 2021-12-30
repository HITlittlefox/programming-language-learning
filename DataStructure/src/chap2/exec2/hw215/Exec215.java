package chap2.exec2.hw215;

public class Exec215 {
    public int listDeleteMore(Node head, int x) {
        Node pre = head;
        Node curr, q;
        int tag = 0;
        curr = head.next;
        while (curr != null) {
            System.out.println(curr.data);
            if (curr.data == x) {
                q = curr;
                curr = q.next;
                pre.next = curr;
                tag++;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        return tag;
    }

    public static void main(String[] args) {
        Exec215 ex = new Exec215();
        Node head = new Node();
        Node p = head;
        for (int i = 0; i < 10; i++) {
            int m = (int) (Math.random() * 100);
            Node node = new Node();
            node.data = m % 10;
            p.next = node;
            p = p.next;
        }
        int count = ex.listDeleteMore(head, 5);
        System.out.println("deleted counts is:" + count);
    }
}

class Node {
    public int data;
    public Node next;
}
