package chap3.SeqPQueue;

//顺序优先级队列类设计见教材P62
public class SeqPQueue {
    static final int defaultSize = 10;
    int front; // 队头
    int rear; // 队尾
    int count; // 计数器
    int maxSize; // 元素最大个数
    Element[] data; // 数据元素

    public SeqPQueue() { // 无参构造函数
        this.initiate(10);
    }

    public SeqPQueue(int sz) { // 带参构造函数
        this.initiate(sz);
    }

    private void initiate(int sz) { // 初始化
        maxSize = sz;
        front = rear = 0;
        count = 0;
        data = new Element[sz];
    }

    public void append(Object obj) throws Exception { // 插入
        if (count >= maxSize) {
            throw new Exception("队列已满！");
        }
        data[rear] = (Element) obj; // 插在队尾
        rear = rear + 1;
        count++;
    }

    public Element delete() throws Exception { // 删除
        if (count == 0) {
            throw new Exception("队列已空！");
        }

        // 寻找优先级最小的数据元素，且保存在临时变量min中
        Element min = data[0];
        int minIndex = 0;
        for (int i = 0; i < count; i++) {
            if (data[i].getPriority() < min.getPriority()) {
                min = data[i];
                minIndex = i;
            }
        }

        // 从优先级最小数据元素的下标minIndex+1开始至count依次移位
        for (int i = minIndex + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        rear = rear - 1;
        count--;
        return min; // 返回优先级最小的数据元素
    }

    public Object getFront() throws Exception { // 取队头数据元素
        if (count == 0) {
            throw new Exception("队列已空！");
        }

        // 寻找优先级最小的数据元素，且保存在临时变量min中
        Element min = data[0];
        int minIndex = 0;
        for (int i = 0; i < count; i++) {
            if (data[i].getPriority() < min.getPriority()) {
                min = data[i];
                minIndex = i;
            }
        }
        return min; // 返回优先级最小的数据元素
    }

    public boolean notEmpty() { // 非空否
        return count != 0;
    }
}
