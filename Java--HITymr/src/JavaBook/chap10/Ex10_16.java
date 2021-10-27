package JavaBook.chap10;

//��:����һ���鼮���󣬲����������һ���ļ�book.dat�У�Ȼ���ٰѸö��������������Ļ����ʾ������Ϣ��

import java.io.*;

//����Ҫ��ʵ�����л����������������ʵ��Serializable�ӿڣ�
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
        //����һ�������(��Ϣ�ӳ��������ļ�)
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"));
        //д�������
        oos.writeObject(book);
        //������ر�
        oos.close();

        book = null;
        //����һ��������(��Ϣ���ļ��������)
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat"));
        //д��������
        book = (Book) ois.readObject();
        //�������ر�
        ois.close();
        System.out.println("ID is:" + book.id);
        System.out.println("name is:" + book.name);
        System.out.println("author is:" + book.author);
        System.out.println("price is:" + book.price);
    }
}
