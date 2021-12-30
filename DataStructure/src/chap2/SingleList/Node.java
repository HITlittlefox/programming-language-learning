package chap2.SingleList;

//�������Ƽ��̲�
public class Node {
    Object data; // ����Ԫ��
    Node next; // ��ʾ��һ�����Ķ�������

    Node(Node nextval) { // ����ͷ���Ĺ��캯��1
        next = nextval;
    }

    Node(Object obj, Node nextval) { // �����������Ĺ��캯��2
        data = obj;
        next = nextval;
    }

    public Node getNext() { // ȡnext
        return next;
    }

    public void setNext(Node nextval) { // ��next
        next = nextval;
    }

    public Object getElement() { // ȡdata
        return data;
    }

    public void setElement(Object obj) { // ��data
        data = obj;
    }

    public String toString() { // ת��dataΪString����
        return data.toString();
    }
}
