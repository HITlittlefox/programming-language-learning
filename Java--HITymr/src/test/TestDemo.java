package test;

//将代码进行构造性改写。声明Book类的属性使用了private关键字，这样就表示title与price两个属性只能在Book类忠告被访问，而其它类无法访问。Book类又设置构造方法让其的数据进行保护性。而java对象封装的本质也就是为了对象的保护和用户方便处理做到业务分明
class Book {
    private String title;
    private double price;

    public void setTitle(String t) {
        title = t;
    }

    public void setPrice(double p) {
        if (p > 0.0)
            price = p;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void getInfo() {
        System.out.println("图书名称:" + title + ",价格：" + price);
    }
}

public class TestDemo {
    public static void main(String args[]) {
        Book book = new Book();
        book.setTitle("Java开发");
        book.setPrice(-89.9);
        book.getInfo();
    }
}
