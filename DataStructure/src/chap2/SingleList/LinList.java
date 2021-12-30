package chap2.SingleList;

//单链表类的定义见教材P27
//单链表
public class LinList implements List {
    Node head;
    Node current;
    int size;

    LinList() {
        head = current = new Node(null);
    }

    public void index(int i) throws Exception {
        if (i < -1 || i > size - 1) {
            throw new Exception("参数错误！");
        }
        if (i == -1)
            return;
        current = head.next;
        int j = 0;
        while ((current != null) && j < i) {
            current = current.next;
            j++;
        }
    }

    public void insert(int i, Object obj) throws Exception {
        if (i < 0 || i > size) {
            throw new Exception("参数错误！");
        }
        index(i - 1);
        //“待插入结点”的上一结点的下一结点是“待插入结点”，“待插入结点”的下一结点是其上一结点刚才的下一结点
        current.setNext(new Node(obj, current.next));
        size++;
    }

    public Object delete(int i) throws Exception {
        if (size == 0) {
            throw new Exception("链表已空无元素可删！");
        }
        if (i < 0 || i > size - 1) {
            throw new Exception("参数错误！");
        }

        index(i - 1);
        Object obj = current.next.getElement();
        current.setNext(current.next.next);
        size--;
        return obj;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object getData(int i) throws Exception {
        if (i < -1 || i > size - 1) {
            throw new Exception("参数错误！");
        }
        index(i);
        return current.getElement();
    }
}
