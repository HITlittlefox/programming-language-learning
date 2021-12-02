package chap3.LinQueueSeqQueue;

//��ʽ���������Ƽ��̲�P60
public class LinQueue implements Queue {
    Node front;//��ͷ
    Node rear;//��β
    int count;//������

    //�޲ι��캯��
    public LinQueue() {
        initiate();
    }

    //���ι��캯��
    public LinQueue(int sz) {
        initiate();
    }

    //��ʼ��
    private void initiate() {
        front = rear = null;
        count = 0;
    }

    //����
    public void append(Object obj) {
        //�����½��
        Node newNode = new Node(obj, null);

        if (rear != null)
            //�����½��
            rear.next = newNode;
        //�ö�β
        rear = newNode;
        if (front == null)
            //�ö�ͷ
            front = newNode;
        count++;
    }

    public Object delete() throws Exception {
        if (count == 0)
            throw new Exception("�����ѿգ�");

        Node temp = front;
        //ԭ��ͷ�������
        front = front.next;
        count--;
        return temp.getElement();
    }

    //ȡ��ͷ����Ԫ��
    public Object getFront() throws Exception {
        if (count == 0)
            throw new Exception("�����ѿգ�");
        return front.getElement();
    }

    //�ǿշ�
    public boolean notEmpty() {
        return count != 0;
    }
}
