package HomeWork;

/*
具有排序数组的类SortedIntArray
search方法运用二分查找算法：
在给定的数组范围内查找某一元素，
如果存在，返回元素所在的下标位置，
如果不存在，则返回元素应该在的位置
（如果要将此元素插入到数组中，且保持数组仍然有序的位置）
将此功能与插入功能相结合，实现对数组元素进行排序。
*/

public class SortedIntArray {
    private int capacity;
    private Integer[] rep;
    private int size;

    //单参构造函数，被调用
    public SortedIntArray(int n) {
        capacity = n;
        rep = new Integer[capacity];
    }


    //无参构造函数，调用SortedIntArray(int n)，调用另一个构造函数来完成初始化
    public SortedIntArray() {
        this(100);
    }


    //二分法
    //在给定的数组范围内查找某一元素，
    //方法重载 overload
    private int search(int i, int lower, int upper) {
        int index = lower;
        if (upper >= lower) {
            int middle = (upper + lower) / 2;
            //取出数组中间的那个元素
            int current = rep[middle];


            //把insert的数字与已有的数组中最中间的那个数进行比较
            //如果相同，就返回中间这个数的下标
            if (current == i) {
                index = middle;
            } else if (current < i) { //如果insert的数字大于中间数字，就再来一遍，把insert的数 和 数组中大于中间数字的数的中间数进行比较！
                index = search(i, middle + 1, upper);
            } else { //如果insert的数字小于中间数字，也再来一遍，把insert的数 和 数组中小于中间数字的数的中间数进行比较！
                index = search(i, lower, middle - 1);
            }
        }
        return index;
    }

    //方法重载 overload
    public int search(int i) {
        return search(i, 0, size - 1);
    }

    //返回自身的insert方法
    public SortedIntArray insert(int i) {
        int index = search(i);
        for (int j = size; j > index; --j)
            rep[j] = rep[j - 1];
        rep[index] = i;
        ++size;
        return this;
    }

    //返回自身的remove方法
    public SortedIntArray remove(int i) {

        int index = search(i);
        if (rep[index].intValue() == i) {
            --size;
            for (int j = index; j < size; ++j) {
                rep[j] = rep[j + 1];
            }
        }
        return this;
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < size; ++i)
            //拼接字符串
            toReturn += rep[i].toString() + ", ";
        return toReturn;
    }

    public static void main(String[] args) {
        SortedIntArray anArray = new SortedIntArray();
        anArray.insert(4).insert(9).insert(7).insert(1).insert(3).
                insert(2).insert(8).insert(7);
        System.out.println("test1:" + anArray);
        anArray.remove(1).remove(8).remove(7).remove(3);
        System.out.println("test2:" + anArray);
    }


}
