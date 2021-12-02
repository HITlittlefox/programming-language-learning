package chap3.LinQueueSeqQueue;

//˳��ѭ�����������
public class SeqQueue implements Queue {
    final int defaultSize = 10;
    int front;//��ͷ
    int rear;//��β
    int count;//Ԫ�ظ���������
    int maxSize;//�������Ԫ�ظ���
    Object[] data;

    //�޲ι��캯��
    public SeqQueue() {
        this.initiate(defaultSize);
    }

    //���ι��캯��
    public SeqQueue(int sz) {
        this.initiate(sz);
    }

    //��ʼ��
    private void initiate(int sz) {
        maxSize = sz;
        front = rear = 0;
        count = 0;
        data = new Object[sz];
    }

    //�����
    public void append(Object obj) throws Exception {
        if (count > 0 && front == rear) {
            throw new Exception("����������");
        }

        data[rear] = obj;
        //��1����ģ
        rear = (rear + 1) % maxSize;
        count++;
    }

    //������
    public Object delete() throws Exception {
        if (count == 0) {
            throw new Exception("�����ѿգ�");
        }

        Object temp = data[front];
        //��1����ģ
        front = (front + 1) % maxSize;
        count--;
        return temp;
    }

    //ȡ��ͷ����Ԫ��
    public Object getFront() throws Exception {
        if (count == 0) {
            throw new Exception("�����ѿգ�");
        }

        return data[front];
    }

    //�ǿշ�
    public boolean notEmpty() {
        return count != 0;
    }

}
