package chap3.LinQueueSeqQueue;

//˳��ѭ����������� ������
public class SeqQueueTest {
    public static void main(String[] args) {

        LinQueue myQueue = new LinQueue();

        int[] test = {1, 3, 5, 7, 9};
        int n = 5;

        try {
            for (int i = 0; i < n; i++) {
                System.out.print(test[i]);
                myQueue.append(test[i]);
            }

            System.out.println("��ǰ��ͷԪ��Ϊ��" + myQueue.getFront());

            System.out.print("������Ԫ������Ϊ��");
            while (myQueue.notEmpty())
                System.out.print(myQueue.delete() + "  ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}