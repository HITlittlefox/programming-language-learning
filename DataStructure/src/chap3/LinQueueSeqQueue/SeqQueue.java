package chap3.LinQueueSeqQueue;

//顺序循环队列类设计
public class SeqQueue implements Queue {
    final int defaultSize = 10;
    int front;//队头
    int rear;//队尾
    int count;//元素个数计数器
    int maxSize;//最大数据元素个数
    Object[] data;

    //无参构造函数
    public SeqQueue() {
        this.initiate(defaultSize);
    }

    //带参构造函数
    public SeqQueue(int sz) {
        this.initiate(sz);
    }

    //初始化
    private void initiate(int sz) {
        maxSize = sz;
        front = rear = 0;
        count = 0;
        data = new Object[sz];
    }

    //入队列
    public void append(Object obj) throws Exception {
        if (count > 0 && front == rear) {
            throw new Exception("队列已满！");
        }

        data[rear] = obj;
        //加1后求模
        rear = (rear + 1) % maxSize;
        count++;
    }

    //出队列
    public Object delete() throws Exception {
        if (count == 0) {
            throw new Exception("队列已空！");
        }

        Object temp = data[front];
        //加1后求模
        front = (front + 1) % maxSize;
        count--;
        return temp;
    }

    //取队头数据元素
    public Object getFront() throws Exception {
        if (count == 0) {
            throw new Exception("队列已空！");
        }

        return data[front];
    }

    //非空否
    public boolean notEmpty() {
        return count != 0;
    }

}
