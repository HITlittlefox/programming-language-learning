package demo;

public class VideoGame extends Item {
    private int numberOfPlayers;

    public VideoGame(String title, int playTime, boolean gotIt, String comment, int numberOfPlayers) {
        super(title, playTime, gotIt, comment);
        this.numberOfPlayers = numberOfPlayers;
    }

    public static void main(String[] args) {
    }

    @Override
    public void print() {
        System.out.println("VideoGame");
        super.print();
    }
}
