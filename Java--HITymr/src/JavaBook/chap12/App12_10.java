package JavaBook.chap12;//filename：App12_10.java

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class App12_10 {
    public static void main(String[] args) {
        Set<String> hs = new HashSet<String>();   //创建哈希集合对象hs
        hs.add("唐  僧1");        //向哈希集合的对象hs添加元素
        hs.add("孙悟空2");
        hs.add("猪八戒3");
        hs.add("沙和尚4");
        hs.add("白龙马5");
        System.out.println("哈希集合：" + hs);
        //要你自己定义排序规则，TreeSet后面写个{}，重写orderBy
        TreeSet<String> ts = new TreeSet<String>(hs);  //利用hs创建树集合对象ts
        System.out.println("树集合：" + ts);          //输出树集合
        System.out.println("树集合的第一个元素：" + ts.first());
        System.out.println("树集合最后一个元素：" + ts.last());
        System.out.println("headSet(孙悟空)的元素：" + ts.headSet("孙悟空"));
        System.out.println("tailSet(孙悟空)的元素：" + ts.tailSet("孙悟空"));
        System.out.println("ceiling (沙)的元素：" + ts.ceiling("沙"));
    }
}
