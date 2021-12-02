package chap3.LinQueueSeqQueue;

//链式队列类的设计见教材P60
public class LinQueue implements Queue {
    Node front;//队头
    Node rear;//队尾
    int count;//计数器

    //无参构造函数
    public LinQueue() {
        initiate();
    }

    //带参构造函数
    public LinQueue(int sz) {
        initiate();
    }

    //初始化
    private void initiate() {
        front = rear = null;
        count = 0;
    }

    //插入
    public void append(Object obj) {
        //创建新结点
        Node newNode = new Node(obj, null);

        if (rear != null)
            //链入新结点
            rear.next = newNode;
        //置队尾
        rear = newNode;
        if (front == null)
            //置队头
            front = newNode;
        count++;
    }

    public Object delete() throws Exception {
        if (count == 0)
            throw new Exception("队列已空！");

        Node temp = front;
        //原队头结点脱链
        front = front.next;
        count--;
        return temp.getElement();
    }

    //取队头数据元素
    public Object getFront() throws Exception {
        if (count == 0)
            throw new Exception("队列已空！");
        return front.getElement();
    }

    //非空否
    public boolean notEmpty() {
        return count != 0;
    }
}
