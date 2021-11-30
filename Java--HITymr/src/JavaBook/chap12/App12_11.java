package JavaBook.chap12;

import java.util.*;

public class App12_11 {
    public static void main(String[] args) {
        Map<String, String> hm = new HashMap<>();   //创建HashMap对象hm
        hm.put("006", "唐  僧");    //将元素添加到映射hm中
        hm.put("008", "孙悟空");
        hm.put("009", "猪八戒");
        hm.put("007", "沙和尚");
        hm.put("010", "白龙马");
        hm.put("011", "白龙马");
        hm.put("01255", "白龙马");
        hm.put("01344", "白龙马");
        hm.put("01433", "白龙马");
        hm.put("01522", "白龙马");
        System.out.println("哈希映射中的内容如下：\n" + hm);   //输出hm中的元素


        String str = hm.remove("010");   //在hm中删除键值为“010”的元素

        //从Map转Set
        Set<String> keys = hm.keySet();     //获取哈希映射hm的键对象集合
        System.out.println("键对象集合keys: " + keys);

        //从Set转Iterator
        Iterator<String> it = keys.iterator();   //获取键对象集合keys的迭代器
        System.out.println("keys的迭代器iterator: " + it);

        System.out.println("==================");
        //HashMap类实现的Map映射，无序
        System.out.println("HashMap类实现的Map映射，无序：");
        while (it.hasNext())        //判断是否还有后续元素
        {
            String xh = it.next();        //返回键
            String name = hm.get(xh);   //返回键所对应的值
            System.out.println(xh + "  " + name);
        }

        //创建TreeMap对象tm
        TreeMap<String, String> tm = new TreeMap<>(hm);                  //向树映射对象tm添加元素
        Iterator<String> iter = tm.keySet().iterator();  //获取迭代器
        System.out.println("TreeMap类实现的Map映射，键值升序：");
        while (iter.hasNext())                //判断是否还有后续元素
        {
            String xh = iter.next();       //返回键
            String name = hm.get(xh);    //返回键所对应的值
            System.out.println(xh + "  " + name);
        }
    }
}
