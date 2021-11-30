package chap2.Josephus2;

/*
定义线性表的接口List
List支持泛型E
该List线性表中所存储的具体数据类型由外界决定
*/
public interface JosephusList<E> extends Iterable<E> {

    //获取线性表中元素的有效个数
    int getSize();

    //判断线性表是否为空表
    boolean isEmpty();

    //在线性表指定的index角标处插入元素e
    void add(int index, E e);

    //在线性表的表头处插入元素e
    void addFirst(E e);

    //在线性表的表尾处插入元素e
    void addLast(E e);

    //获取线性表中指定角标index处的元素
    E get(int index);

    //获取表头元素
    E getFirst();

    //获取表尾元素
    E getLast();

    //修改线性表中指定角标index处的元素为新元素e
    void set(int index, E e);

    //判断线性表中是否包含元素e
    boolean contains(E e);

    //查找元素e的角标(从左到又默认第一个出现的元素角标)
    int find(E e);

    //删除并返回线性表中指定角标index处的元素
    E remove(int index);

    //删除并返回表头元素
    E removeFirst();

    //删除并返回表尾元素
    E removeLast();

    //删除指定元素e
    void removeElement(E e);

    //清空线性表
    void clear();
}


