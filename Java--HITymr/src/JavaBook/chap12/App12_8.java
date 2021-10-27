package JavaBook.chap12;
//filename：App12_8.java

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class App12_8 {
    public static void main(String[] args) {
        //创建数组列表对象al
        List<Integer> al = new ArrayList<Integer>();
        //输出
        for (int i = 1; i < 5; i++) {
            //向数组列表al中添加元素
            al.add(i);
        }

        System.out.println("ArrayList origin data: " + al);

        //创建数组列表al的迭代器listIter
        ListIterator<Integer> listIter = al.listIterator();
        //在序号为0的元素前添加一个元素
        listIter.add(0);
        System.out.println("data after add: " + al);

        if (listIter.hasNext()) {
            System.out.println("listIter.hasNext()): " + listIter.hasNext());
//            System.out.println("listIter.previousIndex()): " + listIter.previousIndex());
            //指针会从第0个指向下一个
            System.out.println("listIter.next()): " + listIter.next());
            //指针会从第1个指向下一个
            System.out.println("listIter.next()): " + listIter.next());
            //指针会从第2个指向下一个，也就是listIter[3],是第四个数,值为3
            int i = listIter.nextIndex();    //执行该语句时i的值是1
            System.out.println("value of i is: " + i);
            listIter.next();             //返回序号为1的元素
            listIter.set(9);  //修改数组列表al中序号为1的元素
            System.out.println("data after edit: " + al);
        }

        listIter = al.listIterator(al.size());   //重新创建从al最后位置开始的迭代器listIter
        System.out.print("reverse: ");    //反向遍历数组列表

        while (listIter.hasPrevious()) {
            System.out.print(listIter.previous() + "  ");    //反向遍历数组列表
        }

    }
}
