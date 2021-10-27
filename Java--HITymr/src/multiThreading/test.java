package multiThreading;

import java.util.*;

public class test {
    public static void main(String[] args) {
        //Collections
        List <Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }
}
