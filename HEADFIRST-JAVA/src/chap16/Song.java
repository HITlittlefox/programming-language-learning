package chap16;

public class Song implements Comparable<Song> {
    //对应4种属性的4个实例变量
    String title;
    String artist;
    String rating;
    String bpm;


    public Song(String t, String a, String r, String b) {
        //变量都会在创建时从构造函数中设定
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }

    public int hashCode() {
        return title.hashCode();
    }

    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }

    public String getArtist() {
        return artist;
    }

    public String getBpm() {
        return bpm;
    }

    public String getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }

}
