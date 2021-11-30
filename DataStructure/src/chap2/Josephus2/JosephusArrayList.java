package chap2.Josephus2;

import java.util.Iterator;

/*
创建线性表的顺序存储结构实现类ArrayList
 */
public class JosephusArrayList<E> implements JosephusList<E> {
    // 创建E类型的一维数组
    private E[] data;
    // 维护元素的个数
    private int size;
    // 默认最大容量为10
    private static int DEAFULT_CAOACITY = 10;

    // 创建一个默认大小的顺序表
    public JosephusArrayList() {
        // data =(E[]) (new Objects[DEAFULT_CAOACITY]);
        // 调用下面传参为一个参数的构造函数
        this(DEAFULT_CAOACITY);
    }

    // 创建一个容量由用户指定的顺序表
    public JosephusArrayList(int capacity) {
        if (capacity <= 0) {
            // 运行异常，创建异常对象，然后进行抛出
            throw new IllegalArgumentException("容量必须>0" + capacity);
        }
        // 对一维数组data进行初始化，类型先给Object再强转为E泛型
        data = (E[]) (new Object[capacity]);
        // 将有效元素个数初始赋值为0
        size = 0;
    }

    // 用户传入一个数组，将该数组封装成一个顺序表
    public JosephusArrayList(E[] data) {
        if (data == null) {// 如果为空，输入异常
            throw new IllegalArgumentException("数组不能为空");
        }
        this.data = (E[]) (new Object[data.length]);// 使用this关键字对该类中的data进行引用
        // 读取传入数组元素，放入类中的data
        for (int i = 0; i < data.length; i++) {
            this.data[i] = data[i];
        }
        // 更新有效元素个数
        size = data.length;
    }

    // 重写接口中的获取有效元素个数
    @Override
    public int getSize() {
        // 直接返回成员变量size
        return size;
    }

    // 重写判空方法
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) { // 角标index越界，提示异常
            throw new IllegalArgumentException("角标越界");
        }
        // 如果线性表已经=满，就进行扩容
        if (size == data.length) {
            // 扩容(扩二倍)
            resize(data.length * 2);// 使用到ArrayList中的扩容方法resize
        }
        // 插入元素
        for (int i = size; i > index; i--) { // 从size角标开始从后往前遍历
            data[i] = data[i - 1];// 把前一个角标对应的元素给当前角标
        }
        data[index] = e; // 把元素插到index位置
        // 有效元素个数更新
        size++;
    }

    // 扩缩容函数
    private void resize(int newLength) {
        // 创建新数组
        E[] newData = (E[]) (new Object[newLength]);
        for (int i = 0; i < size; i++) { // 循环继续条件 data.length 和size都一样
            newData[i] = data[i]; // 元素放入新数组
        }
        // 偷梁换柱
        data = newData;
    }

    @Override
    public void addFirst(E e) {
        // 表头插入元素，调用add，角标传0即可
        add(0, e);
    }

    @Override
    public void addLast(E e) {
        // 表尾插入元素，调用add，角标传size即可
        add(size, e);
    }

    // 重写获取线性表中指定角标index处的元素的方法
    @Override
    public E get(int index) {
        if (isEmpty()) { // 判空，为空时不能获取元素
            throw new IllegalArgumentException("线性表为空");
        }
        if (index < 0 || index >= size) { // 输入角标越界情况，抛异常
            throw new IllegalArgumentException("角标越界");
        }
        return data[index];
    }

    @Override
    public E getFirst() {
        // 获取表头，调用get方法,index给0
        return get(0);
    }

    @Override
    public E getLast() {
        // 获取表头，调用get方法,index给size-1
        return get(size - 1);
    }

    // 重写修改线性表中指定角标index处的元素为新元素e的方法
    @Override
    public void set(int index, E e) {
        if (isEmpty()) {
            throw new IllegalArgumentException("线性表为空");
        }
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("角标越界");
        }
        data[index] = e; // 把元素e给角标index对应位置
    }

    // 重写 判断线性表中是否包含元素e
    @Override
    public boolean contains(E e) {
        // 调用find方法，能找到就包含
        return find(e) != -1;
    }

    // 重写 查找元素e的角标
    @Override
    public int find(E e) {
        if (isEmpty()) { // 判空 抛异常
            throw new IllegalArgumentException("线性表为空");
        }
        // 遍历表中元素，与e对比，比的是内容
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) { // data里面都是对象 ==比的是地址 equals比的是内容
                return i;
            }
        }
        return -1;
    }

    // 重写 删除并返回线性表中指定角标index处的元素
    @Override
    public E remove(int index) {
        if (isEmpty()) { // 表为空时，不可删除
            throw new IllegalArgumentException("线性表为空");
        }
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("角标越界");
        }
        // 把index处元素给变量ret，当做返回
        E ret = data[index];
        // 把后面的元素前移
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        // 并将有效元素个数递减
        size--;
        // 缩容的情况，条件是自定义
        if (size <= data.length / 4 && data.length / 2 >= 10) { 
            // 如果有效长度小于等于现在长度的1/4，同时缩容之后的长度大于等于10，才可以缩容
            resize(data.length / 2);
        }
        // 返回被删除元素
        return ret;
    }

    @Override
    public E removeFirst() {
        // 删除表头，调用remove方法
        return remove(0);
    }

    @Override
    public E removeLast() {
        // 删除表尾
        return remove(size - 1);
    }

    // 重写 删除指定元素e
    @Override
    public void removeElement(E e) { // 从左到右删第一个
        // 先找到e，拿到角标
        int index = find(e);
        // 如果角标存在
        if (index != -1) {
            // 调用remove方法删除元素
            remove(index);
        } else { // 否则抛出异常
            throw new IllegalArgumentException("元素不存在");
        }
    }

    // 重写 清空线性表方法
    @Override
    public void clear() {
        // 把构造函数内容拿来用
        size = 0;
        data = (E[]) (new Object[DEAFULT_CAOACITY]);
    }

    // ArrayLis特有的方法 获取线性表容量
    public int getCapacity() {
        return data.length;
    }

    // toString方法
    /*
     * 打印这样的格式 ArrayList:10/20 []
     */
    public String toString() {
        // 创建StringBuilder对象，不需要额外创字符串，在原来的上加字符
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("ArrayList: %d/%d \n", size, data.length));
        // 用数组的形式输出
        sb.append('[');
        if (isEmpty()) { // 若为空，打印 []
            sb.append(']');
        } else { // 不为空，遍历线性表元素
            for (int i = 0; i < size; i++) {
                // 在原来上加字符
                sb.append(data[i]);
                if (i == size - 1) { // 遍历到最后一个元素打印']'
                    sb.append(']');
                } else { // 不然在每个元素中间打','
                    sb.append(',');
                }
            }
        }
        // 调用对象的tostring方法返回对象
        return sb.toString();
    }

    // 返回当前数据结构的一个迭代器对象
    // 迭代器用于在没有角标支持的环境下遍历元素
    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator(); // 创建并返回内部类对象
    }

    // 迭代器 内部类
    private class ArrayListIterator implements Iterator { //
        // index初始为-1
        private int index = -1;

        @Override
        public boolean hasNext() {
            return index < size - 1;
        }

        @Override
        public E next() {
            index++;
            return data[index];
        }
    }
}
