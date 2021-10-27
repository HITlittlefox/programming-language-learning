package chap16;


import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put("kathy", 42);
        scores.put("bert", 343);
        scores.put("skyler", 420);
        System.out.println(scores);
        System.out.println(scores.get("bert"));


    }
}
