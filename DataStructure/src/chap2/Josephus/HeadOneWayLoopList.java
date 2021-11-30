package chap2.Josephus;

//带头结点的循环单链表
public class HeadOneWayLoopList {
    private Node head;
    private int currentSize;

    public HeadOneWayLoopList() {
        head = null;
        currentSize = 0;
    }

    // 返回下标为 i 的那个结点的指针，结点编号从0开始；
    public Node index(int i) {
        if (i >= 0 && i < currentSize) {
            Node temp = head;
            for (int j = 0; j < i; j++) {
                temp = temp.getNext();
            }
            return temp;
        } else {
            System.out.println("下标超界！");
            return null;
        }
    }

    // 插入结点，使其成为第 i 个结点。
    public void insertNode(Node node, int i) {
        if (head == null) {
            head = node;
            head.setNext(head);
        } else {
            Node temp = index(i - 1);
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        currentSize++;
    }

    public void deleteNode(int i) {
        if (i == 0) {
            if (currentSize == 1) {
                head = null;
            } else {
                Node preNode = index(currentSize - 1);
                Node deletedNode = preNode.getNext();
                head = deletedNode.getNext();
                preNode.setNext(head);
                deletedNode.setNext(null);
            }
        } else {
            Node preNode = index(i - 1);
            Node deletedNode = preNode.getNext();
            head = deletedNode.getNext();
            preNode.setNext(head);
            deletedNode.setNext(null);
        }
        currentSize--;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }
}
