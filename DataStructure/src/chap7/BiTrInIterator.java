package chap7;

public class BiTrInIterator extends BiTreeInterator {
    private LinStack s = new LinStack();            //������ջ�����s

    public BiTrInIterator(BiTreeNode t) {                //���캯��
        super(t);                                //���ø���Ĺ��캯��
    }

    private BiTreeNode goFarLeft(BiTreeNode t) {    //Ѱ�������ӽ��
        if (t == null) return null;
        while (t.getLeft() != null) {
            s.push(t);
            t = t.getLeft();
        }
        return t;
    }

    public void reset() {                        //���ǻ�������ó�Ա����
        if (root == null) iteComplete = 1;        //�ý������
        else iteComplete = 0;

        if (root == null) return;
        current = goFarLeft(root);
    }

    public void next() {                        //���ǻ������һ������Ա����
        if (iteComplete == 1) {
            System.out.println("�ѵ�������β��");
            return;
        }

        if (current.getRight() != null) {
            current = goFarLeft(current.getRight());
//Ѱ�ҵ�ǰ����Һ��ӽ��������ӽ��
        } else if (s.notEmpty()) {                                //����ջ�ǿ�
            try {
                current = (BiTreeNode) s.pop();                //��ջ
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            iteComplete = 1;                                //�ý������
    }
}
