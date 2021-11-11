package JavaBook.chap12;//filename：App12_10.java
// 先创建一个哈希集合对象hs，并向其添加元素，
// 然后再用hs创建树集合对象ts，
// 之后利用树集合的相应方法输出某些元素。12_10

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class App12_10 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<>();   //创建哈希集合对象hs
        hs.add("唐  僧1");        //向哈希集合的对象hs添加元素
        hs.add("孙悟空2");
        hs.add("猪八戒3");
        hs.add("沙和尚4");
        hs.add("白龙马5");
        System.out.println("哈希集合：" + hs);
        //要你自己定义排序规则，TreeSet后面写个{}，重写orderBy
        TreeSet<String> ts = new TreeSet<>(hs);  //利用hs创建树集合对象ts
        System.out.println("树集合：" + ts);          //输出树集合
        System.out.println("树集合的第一个元素：" + ts.first());
        System.out.println("树集合最后一个元素：" + ts.last());
        System.out.println("headSet(孙悟空)的元素，孙悟空之前的：" + ts.headSet("孙悟空"));
        System.out.println("tailSet(孙悟空)的元素：孙悟空以及之后的" + ts.tailSet("孙悟空"));
        System.out.println("ceiling (沙)的元素：" + ts.ceiling("沙"));
        //floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
        //ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
    }
}
