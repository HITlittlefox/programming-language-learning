package demo;

/**
 * @author Liu Xinlong
 */
public class Item {
    private String title;
    private int playTime;
    private boolean gotIt = false;
    private String comment;

    public Item() {
    }

    public Item(String title, int playTime, boolean gotIt, String comment) {
        this.title = title;
        this.playTime = playTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }

    public void print() {
        System.out.println(title);
    }
}
