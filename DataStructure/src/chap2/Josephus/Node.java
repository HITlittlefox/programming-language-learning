package chap2.Josephus;

public class Node {
    //node类型的next对象
    private Node next;
    //编号
    private int num;
    //对应密码
    private int code;

    //Node对象有两个属性，一个编号，一个密码
    public Node(int num, int code) {
        this.num = num;
        this.code = code;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
