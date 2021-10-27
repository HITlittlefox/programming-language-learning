package demo;

import java.util.ArrayList;

//增加内容 DVD
public class DataBase {
    //    private ArrayList<CD> listCD = new ArrayList<CD>();
    //    private ArrayList<DVD> listDVD = new ArrayList<DVD>();
    private ArrayList<Item> listItem = new ArrayList<Item>();

    //public void add(CD cd) {
    //    listCD.add(cd);
    //}

    //public void add(DVD dvd) {
    //    listDVD.add(dvd);
    //}
    public void add(Item item) {
        listItem.add(item);
    }

    public void list() {
        //for (CD cd : listCD) {
        //    cd.print();
        //}
        //for (DVD dvd : listDVD) {
        //    dvd.print();
        //}
        for (Item item : listItem) {
            item.print();
        }
    }

    public static void main(String[] args) {
        DataBase db = new DataBase();

        db.add(new CD("a", "d", 2, 60, "..."));
        db.add(new CD("b", "e", 2, 60, "..."));
        db.add(new DVD("c", "f", 2, "..."));
        db.add(new VideoGame("2077",200,false,"a",1));

        db.list();
    }


}
