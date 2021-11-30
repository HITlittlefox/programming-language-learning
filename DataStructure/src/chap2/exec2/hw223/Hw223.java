package chap2.exec2.hw223;

// 选做作业：2-23
// interface List {
// java 设计一个带头节点的循环双向链表类 
// 要求 带头节点双向循环链表类的成员函数包括
// 取数据元素个数、插入、删除、取数据元素
// 设计一个测试主函数验证各成员函数正确性
import java.util.Scanner;

//1、接口的定义：
interface List { // 线性表的抽象数据Java接口

    public boolean isEmpty();

    // 取数据元素个数
    public int size();

    // 取数据元素
    public Object getData(int i) throws Exception;

    // 插入
    public void insert(int i, Object x) throws Exception;

    // 删除
    public void delete(int i) throws Exception;

    // 遍历输出元素
    public void display();
}

// 2、结点的定义：
class DoubleNode {
    public Object data;
    public DoubleNode prior;
    public DoubleNode next;

    public DoubleNode() {
        this(null);
    }

    public DoubleNode(Object data) {
        this.data = data;
        this.prior = null;
        this.next = null;
    }
}

// 3、构造带头结点的双向循环链表：
class DoubleLinkList implements List {
    public DoubleNode head;

    public DoubleLinkList() {
        head = new DoubleNode();
        head.prior = head;
        head.next = head;
    }

    // 4、插入元素：
    public void insert(int i, Object x) throws Exception {
        DoubleNode p = head.next;
        int j = 0;
        while (!p.equals(head) && j < i) {
            p = p.next;
            ++j;
        }
        if (j != i && !p.equals(head))
            throw new Exception("插入位置不合法");
        DoubleNode s = new DoubleNode(x);
        p.prior.next = s;
        s.prior = p.prior;
        s.next = p;
        p.prior = s;
    }

    // 5、用头插法创建带头结点双向循环链表：
    public DoubleLinkList(int n) throws Exception {
        this();
        Scanner sc = new Scanner(System.in);
        for (int j = 0; j < n; j++)
            insert(0, sc.next());
    }

    // 7、判断双向循环链表是否为空：
    public boolean isEmpty() {
        return head.next == null;
    }

    // 8、返回双向循环链表的长度：
    public int size() {
        DoubleNode p = head;
        int len = 0;
        while (p.next != head) {
            p = p.next;
            ++len;
        }
        return len;
    }

    // 10、返回指定位置的元素：
    public Object getData(int i) throws Exception {
        DoubleNode p = head.next;
        int j = 0;
        while (p != null && j < i) {
            p = p.next;
            ++j;
        }
        if (j > i || p == null) {
            throw new Exception("第" + i + "个元素不存在");
        }
        return p.data;
    }

    // 11、删除指定位置的元素：
    public void delete(int i) throws Exception {
        DoubleNode p = head.next;
        int j = 0;
        while (!p.equals(head) && j < i) {
            p = p.next;
            ++j;
        }
        if (j != i)
            throw new Exception("删除位置不合理");
        p.prior.next = p.next;
        p.next.prior = p.prior;
    }

    // 13、遍历输出元素：
    public void display() {
        DoubleNode node = head.next;
        while (!node.equals(head)) {
            System.out.print(node.data + "");
            node = node.next;
        }
        System.out.println();
    }

}

public class Hw223 {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        Scanner cin = new Scanner(System.in);
        System.out.print("请手动输入双向循环链表的长度（如6）：");
        int n = cin.nextInt();

        System.out.println("==================");
        System.out.println("测试插入");
        System.out.println("==================");
        DoubleLinkList L = new DoubleLinkList();
        System.out.print("用头插法依次输入双向循环链表的值（如1，2，3，4，5，6）（需要输入和您刚才输入数量一样多的数字）：");
        for (int i = 0; i < n; i++)
            L.insert(0, cin.nextInt());
        System.out.print("此时双向循环链表各元素的值：");
        L.display();

        System.out.println("==================");
        System.out.println("测试取元素个数");
        System.out.println("==================");
        System.out.println("元素个数为：" + L.size());
        System.out.println("");
        System.out.println("==================");
        System.out.println("测试插入");
        System.out.println("==================");

        L.insert(1, 1);
        System.out.print("在1位置，插入元素'1'后的双向循环链表：");
        L.display();

        System.out.println("此时双向循环链表的长度：" + L.size());
        System.out.println("==================");
        System.out.println("测试删除");
        System.out.println("==================");
        L.delete(2);
        System.out.print("删除位置'2'后的双向循环链表：");
        L.display();
        System.out.println("");

        System.out.println("==================");
        System.out.println("测试取数据元素");
        System.out.println("==================");
        System.out.print("请输入要查找的位置（如0）：");
        int m = cin.nextInt();
        if (m > L.size() || L.getData(m) == null)
            System.out.println("该元素不存在！");
        else
            System.out.println("查找的位置上的值：" + L.getData(m));

    }
}