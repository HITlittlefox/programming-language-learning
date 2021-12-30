package chap2.Josephus2;

import chap2.Josephus2.JosephusArrayList;
/*
 * ���Ϊ1~N��N���˰�˳ʱ�뷽��Χ��һȦ��ÿ���˳���һ�����루�������������������룩��
 * ��ʼ��ѡһ����������Ϊ��������ֵM���ӵ�һ���˰�˳ʱ�뷽����1��ʼ˳����������Mʱ
 * ֹͣ��������M���˳��У�������������Ϊ�µ�Mֵ������˳ʱ�뷽���ϵ���һ���˿�ʼ��1
 * �����������ȥ��ֱ�������˳���Ϊֹ��
 * */

public class JosephusLoopUpper {
    private Node head;// ͷ���
    private Node rear;// β�ڵ�
    private int size;// �����С
    private int M;// ����ĵ�һ������

    public JosephusLoopUpper(JosephusArrayList<Integer> list, int M) {
        head = new Node(list.get(0), 0, null);
        rear = head;
        rear.next = head;// β�ڵ����ӵ�ͷ��㣬�γ�ѭ������
        for (int i = 1; i < list.getSize(); i++) {// ����������
            rear.next = new Node(list.get(i), i, rear.next);
            rear = rear.next;// ����˽�����
        }
        size = list.getSize();
        this.M = M;
    }

    public void out() {// ɾ����
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
        int password;// ����
        int position;// λ��
        Node next;// Ҫɾ���Ľڵ�

        public Node() {
        }

        public Node(int password, int position, Node next) {
            this.password = password;
            this.next = next;// �������һ���ڵ�
            this.position = position;
            System.out.println("nodePosition" + position + ";node��password" + password);
        }
    }

    public static void main(String[] args) {
        // 3 1 7 2 4 8 4
        JosephusArrayList<Integer> list = new JosephusArrayList<>();
        list.addLast(3);
        // ��һ��add0.1.2���������һ��ɾ��˳��
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
