package JavaBook.chap10;

//例:创建一个书籍对象，并把它输出到一个文件book.dat中，然后再把该对象读出来，在屏幕上显示对象信息。

import java.io.*;

//对象要想实现序列化，其所属的类必须实现Serializable接口；
class Book implements Serializable {
    int id;
    String name, author;
    float price;

    public Book(int id, String name, String author, float price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }
}

public class Ex10_16 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Book book = new Book(100032,
                "Java Programming Skills",
                "Wang Sir",
                30);
        //建立一个输出流(信息从程序流向文件)
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"));
        //写入输出流
        oos.writeObject(book);
        //输出流关闭
        oos.close();

        book = null;
        //建立一个输入流(信息从文件流向程序)
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat"));
        //写入输入流
        book = (Book) ois.readObject();
        //输入流关闭
        ois.close();
        System.out.println("ID is:" + book.id);
        System.out.println("name is:" + book.name);
        System.out.println("author is:" + book.author);
        System.out.println("price is:" + book.price);
    }
}
