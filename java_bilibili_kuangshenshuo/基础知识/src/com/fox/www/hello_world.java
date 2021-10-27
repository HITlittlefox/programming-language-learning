package com.fox.www;

/**
 * @author fox
 * @version 1.0
 * @since 1.8
 */
public class hello_world {
    String name;

    public static void main(String[] args) {
        hello_world first_call= new hello_world();
        first_call.name="ok";
        System.out.println(first_call.name);
    }
}
