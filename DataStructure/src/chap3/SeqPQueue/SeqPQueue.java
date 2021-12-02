package chap3.SeqPQueue;

//˳�����ȼ���������Ƽ��̲�P62
public class SeqPQueue {
    static final int defaultSize = 10;
    int front; // ��ͷ
    int rear; // ��β
    int count; // ������
    int maxSize; // Ԫ��������
    Element[] data; // ����Ԫ��

    public SeqPQueue() { // �޲ι��캯��
        this.initiate(10);
    }

    public SeqPQueue(int sz) { // ���ι��캯��
        this.initiate(sz);
    }

    private void initiate(int sz) { // ��ʼ��
        maxSize = sz;
        front = rear = 0;
        count = 0;
        data = new Element[sz];
    }

    public void append(Object obj) throws Exception { // ����
        if (count >= maxSize) {
            throw new Exception("����������");
        }
        data[rear] = (Element) obj; // ���ڶ�β
        rear = rear + 1;
        count++;
    }

    public Element delete() throws Exception { // ɾ��
        if (count == 0) {
            throw new Exception("�����ѿգ�");
        }

        // Ѱ�����ȼ���С������Ԫ�أ��ұ�������ʱ����min��
        Element min = data[0];
        int minIndex = 0;
        for (int i = 0; i < count; i++) {
            if (data[i].getPriority() < min.getPriority()) {
                min = data[i];
                minIndex = i;
            }
        }

        // �����ȼ���С����Ԫ�ص��±�minIndex+1��ʼ��count������λ
        for (int i = minIndex + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        rear = rear - 1;
        count--;
        return min; // �������ȼ���С������Ԫ��
    }

    public Object getFront() throws Exception { // ȡ��ͷ����Ԫ��
        if (count == 0) {
            throw new Exception("�����ѿգ�");
        }

        // Ѱ�����ȼ���С������Ԫ�أ��ұ�������ʱ����min��
        Element min = data[0];
        int minIndex = 0;
        for (int i = 0; i < count; i++) {
            if (data[i].getPriority() < min.getPriority()) {
                min = data[i];
                minIndex = i;
            }
        }
        return min; // �������ȼ���С������Ԫ��
    }

    public boolean notEmpty() { // �ǿշ�
        return count != 0;
    }
}
