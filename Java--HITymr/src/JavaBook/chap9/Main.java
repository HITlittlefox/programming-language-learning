package JavaBook.chap9;

import java.util.Scanner;

class SomeException extends Exception {
    SomeException() {
    }
}

public class Main {
    public static void someFunction(int number) throws SomeException {
        if (number == 123) {
            // 嘤
            throw new SomeException();
        }
        System.err.println("some greetings");
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            someFunction(scanner.nextInt());
        } catch (SomeException e) {
            e.printStackTrace();
            System.err.println("嘤嘤嘤");
        }
    }
}
