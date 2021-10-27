package JavaBook.chap12;
//����LinkedList<E>�๹��һ���Ƚ�����Ķ�ջ

import java.util.LinkedList;
import java.util.Scanner;

class StringStack {
    private LinkedList<String> ld = new LinkedList<>();

    //�������������ջ
    public void push(String name) {
        ld.addFirst(name);
    }

    //��ȡ��ɾ��ջ������
    public String pop() {
        return ld.removeFirst();
    }

    //��д��isEmpty()���������ж����Ա�ld�Ƿ�Ϊ��
    public boolean isEmpty() {
        return ld.isEmpty();
    }
}

public class App12_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringStack stack = new StringStack();
        System.out.println("plz input data (end with quit) : ");

        //�����������������ջ��֪������quit������ջ����
        while (true) {
            String input = sc.next();
            if (input.equals("quit")) {
                break;
            }
            stack.push(input);
        }
        System.out.println("first come late out: ");

        //����ѭ����ջ�е��������Ƚ������˳�����
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }
}
