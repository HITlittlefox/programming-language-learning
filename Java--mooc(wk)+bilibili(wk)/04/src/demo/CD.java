package demo;

public class CD extends Item {
    private String artist;
    private int numofTracks;

    public CD(String title, String artist, int numofTracks, int playTime, String comment) {
        //title在父类中构造，并且让父类去管理
        super(title, playTime, false, comment);

        //this.title = title;
        this.artist = artist;
        this.numofTracks = numofTracks;
        //this.playTime = playTime;
        //this.comment = comment;
    }

    @Override
    public void print() {
        //System.out.println(Item.title +
        //       ":" +
        //     artist);
    }


}