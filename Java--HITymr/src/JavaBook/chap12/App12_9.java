package JavaBook.chap12;//filename：App12_9.java

//将每个字符串添加到哈希集合中，集合中已有的元素不能添加，并将重复的元素输出。
//最后在对集合进行遍历，输出其所有元素。
//HashSet特点：不重复、无顺序

import java.util.HashSet;

public class App12_9 {
    public static void main(String[] args) {

        String[] input_thing = new String[]{
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "11", "12", "13", "14", "15"
        };

        HashSet<String> hs = new HashSet<String>(); //创建哈希集合对象hs，初始容量为16
        //LinkedHashSet<String> hs=new LinkedHashSet<String>();

        for (String a : input_thing)
            //如果hs没有添加成功a
            if (!hs.add(a))          //向哈希集合hs添加元素，但重复的元素不添加
            {
                System.out.println("element: " + a + " is duplicate");        //输出重复的元素
            }
        System.out.println("Content of HashSet is: " + hs.size() + ", whose element is ");
        //创建哈希集合hs的迭代器it
        //判断集合中是否还有后续元素
        for (String h : hs) {
            System.out.print(h + "  ");   //输出哈希集合中的元素
        }

    }
}
