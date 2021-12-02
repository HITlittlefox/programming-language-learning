package chap3.SeqStackLinStack;

//˳���ջ����Ƽ��̲�P45
//�ŵ㣺�ڴ������ʸ�
//ȱ�㣺��������Ԫ�ظ���
public class SeqStack implements Stack {
    final int defaultSize = 10;
    int top;//ջ��λ��
    Object[] stack;//�������
    int maxStackSize;//�������Ԫ�ظ���

    //�޲ι��캯��
    public SeqStack() {
        initiate(defaultSize);
    }

    //���ι��캯��
    public SeqStack(int sz) {
        initiate(sz);
    }

    //��ʼ��
    private void initiate(int sz) {
        maxStackSize = sz;
        top = 0;
        stack = new Object[sz];
    }

    //��ջ
    public void push(Object obj) throws Exception {
        if (top == maxStackSize) {
            throw new Exception("��ջ������");
        }
        //����Ԫ��
        stack[top] = obj;
        //������ջ��λ��
        top++;
    }

    //��ջ
    public Object pop() throws Exception {
        if (top == 0) {
            throw new Exception("��ջ�ѿգ�");
        }
        //����ԭջ��λ��
        top--;
        //����ԭջ��Ԫ��
        return stack[top];
    }

    //ȡջ��Ԫ��
    public Object getTop() throws Exception {
        if (top == 0) {
            throw new Exception("��ջ�ѿգ�");
        }
        //����ԭջ��Ԫ��
        return stack[top - 1];
    }

    //�ǿշ�
    public boolean notEmpty() {
        return (top > 0);
    }
}
