package JavaBook.chap12;
//利用LinkedList<E>类构造一个先进后出的堆栈

import java.util.LinkedList;
import java.util.Scanner;

class StringStack {
    private LinkedList<String> ld = new LinkedList<>();

    //将输入的数组入栈
    public void push(String name) {
        ld.addFirst(name);
    }

    //获取并删除栈顶数据
    public String pop() {
        return ld.removeFirst();
    }

    //重写了isEmpty()方法用于判断线性表ld是否为空
    public boolean isEmpty() {
        return ld.isEmpty();
    }
}

public class App12_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringStack stack = new StringStack();
        System.out.println("plz input data (end with quit) : ");

        //将键盘输入的数据入栈，知道输入quit结束入栈操作
        while (true) {
            String input = sc.next();
            if (input.equals("quit")) {
                break;
            }
            stack.push(input);
        }
        System.out.println("first come late out: ");

        //利用循环将栈中的数据以先进后出的顺序输出
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }
}
