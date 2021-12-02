package chap3.SeqStackLinStack;

//˳���ջ�����
public class SeqStackTest {
    public static void main(String[] args) {

        SeqStack myStack = new SeqStack();

        int[] test = {1, 3, 5, 7, 9};
        int n = 5;

        try {
            for (int i = 0; i < n; i++) {
                System.out.print(test[i]);
                myStack.push(test[i]);
            }

            System.out.println("��ǰջ��Ԫ��Ϊ��" + myStack.getTop());

            System.out.print("��ջԪ������Ϊ��");
            while (myStack.notEmpty())
                System.out.print(myStack.pop() + "  ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
