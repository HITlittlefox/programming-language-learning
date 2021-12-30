package chap2.SingleList;

//��������Ķ�����̲�P27
//������
public class LinList implements List {
    Node head;
    Node current;
    int size;

    LinList() {
        head = current = new Node(null);
    }

    public void index(int i) throws Exception {
        if (i < -1 || i > size - 1) {
            throw new Exception("��������");
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
            throw new Exception("��������");
        }
        index(i - 1);
        //���������㡱����һ������һ����ǡ��������㡱�����������㡱����һ���������һ���ղŵ���һ���
        current.setNext(new Node(obj, current.next));
        size++;
    }

    public Object delete(int i) throws Exception {
        if (size == 0) {
            throw new Exception("�����ѿ���Ԫ�ؿ�ɾ��");
        }
        if (i < 0 || i > size - 1) {
            throw new Exception("��������");
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
            throw new Exception("��������");
        }
        index(i);
        return current.getElement();
    }
}
