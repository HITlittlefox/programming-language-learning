package demo;

public class DVD extends Item {

    private String director;

    public DVD(String title, String director, int playTime, String comment) {
        //title在父类中构造，并且让父类去管理
        super(title, playTime, false, comment);

        this.director = director;
    }

    @Override
    public void print() {
        System.out.println("DVD: " + ":");
        super.print();
        System.out.println(director);
    }

    public static void main(String[] args) {
        DVD dvd = new DVD("1", "2", 3, "1");
        dvd.print();
    }
}
