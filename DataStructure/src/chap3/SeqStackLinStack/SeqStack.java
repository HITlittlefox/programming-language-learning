package chap3.SeqStackLinStack;

//顺序堆栈类设计见教材P45
//优点：内存利用率高
//缺点：需给出最大元素个数
public class SeqStack implements Stack {
    final int defaultSize = 10;
    int top;//栈顶位置
    Object[] stack;//数组对象
    int maxStackSize;//最大数据元素个数

    //无参构造函数
    public SeqStack() {
        initiate(defaultSize);
    }

    //带参构造函数
    public SeqStack(int sz) {
        initiate(sz);
    }

    //初始化
    private void initiate(int sz) {
        maxStackSize = sz;
        top = 0;
        stack = new Object[sz];
    }

    //入栈
    public void push(Object obj) throws Exception {
        if (top == maxStackSize) {
            throw new Exception("堆栈已满！");
        }
        //保存元素
        stack[top] = obj;
        //产生新栈顶位置
        top++;
    }

    //出栈
    public Object pop() throws Exception {
        if (top == 0) {
            throw new Exception("堆栈已空！");
        }
        //产生原栈顶位置
        top--;
        //返回原栈顶元素
        return stack[top];
    }

    //取栈顶元素
    public Object getTop() throws Exception {
        if (top == 0) {
            throw new Exception("堆栈已空！");
        }
        //返回原栈顶元素
        return stack[top - 1];
    }

    //非空否
    public boolean notEmpty() {
        return (top > 0);
    }
}
