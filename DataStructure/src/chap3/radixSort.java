package chap3;

//基数排序
//要求进出桶中的数据元素序列满足先进先出FIFO的原则，所以这里说的桶就是序列
//设计时把所需的10个队列设计成一个队列数组
public class radixSort {
    //a为要排序的数据元素，d为进制的基数，m为数据元素的最大位数
    public static int[] radixSort(int[] a, int m, int d) throws Exception {
        int n = a.length;
        int i, j, k, l, power = 1;
        LinQueue[] myQueue = new LinQueue[d];

        //创建链式队列数组对象
        for (i = 0; i < d; i++) {
            LinQueue temp = new LinQueue();
            myQueue[i] = temp;
        }
        //进行m次排序
        for (i = 0; i < m; i++) {
            if (i == 0) {
                power = 1;
            } else {
                power = power * d;
            }
            //依次将n个数据元素按第k位的大小放到相应的队列中
            for (j = 0; j < n; j++) {
                //计算k值
                k = a[j] / power - (a[j] / (power * d)) * d;
                //a[j]入队列k
                myQueue[k].append(new Integer(a[j]));
            }
            //顺序回收各队列中的数据元素到数组a中
            l = 0;
            for (j = 0; j < d; j++) {
                while (myQueue[j].notEmpty()) {
                    a[l] = ((Integer) myQueue[j].delete()).intValue();
                    l++;
                }
            }
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        int[] a = new int[]{710, 342, 45, 686, 6, 841, 429, 134, 68, 264};
//        int[] a = new int[]{138, 178, 138, 178, 178, 178, 133, 178, 137, 133};
        for (int i : radixSort(a, 3, 10)) {
            System.out.println(i);
        }
    }
}

//结点
class Node {
    Object data;
    Node next;

    Node(Object obj, Node nextval) {
        data = obj;
        next = nextval;
    }

    Node(Node nextval) {
        next = nextval;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nextval) {
        next = nextval;
    }

    public Object getElement() {
        return data;
    }

    public void setElement(Object obj) {
        data = obj;
    }

    public String toString() {
        return data.toString();
    }
}

//队列接口
interface Queue {
    public void append(Object obj) throws Exception;

    public Object delete() throws Exception;

    public Object getFront() throws Exception;

    public boolean notEmpty();
}

//链式队列类的设计见教材P60
class LinQueue implements Queue {
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
