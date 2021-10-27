package com.fox.www;

class Books {
    String title;
    String author;
}

public class BooksTestDrive {
    String name;
    public static void main(String[] args) {
        Books[] myBooks = new Books[3];
        myBooks[0] = new Books();
        myBooks[1] = new Books();
        myBooks[2] = new Books();
        Dog dog1 = new Dog();
        myBooks[0].title = "The book number0";
        myBooks[1].title = "The book number1";
        myBooks[2].title = "The book number2";
        myBooks[0].author = "The book number3";
        myBooks[1].author = "The book number4";
        myBooks[2].author = "The book number5";
        int x = 0;

        while (x < 3) {
            System.out.println(myBooks[x].title + " by " + myBooks[x].author);
            x = x + 1;
        }
    }
}