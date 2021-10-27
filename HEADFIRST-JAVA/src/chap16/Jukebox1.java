package chap16;

import java.util.*;
import java.io.*;

public class Jukebox1 {
    //歌曲名称会存在String的ArrayList上
    ArrayList<String> songList = new ArrayList<String>();

    public static void main(String[] args) {
        new Jukebox1().go();
    }

    //这个方法会载入文件并列出内容
    public void go() {
        getSongs();
        System.out.println(songList);

        //调用Collection静态的sort()然后再列出清单，
        //第二次的输出会依照字母排序！
        Collections.sort(songList);
        System.out.println(songList);
    }

    //读取文件的程序
    void getSongs() {
        try {
            File file = new File("C:\\Users\\96361\\Desktop\\programming-language-learning2\\HEADFIRST-JAVA\\src\\chap16\\SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                addSong(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //split()方法会用反斜线来拆开歌曲内容
    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        //因为只需要歌名，所以只取第一项加入Songlist
        songList.add(tokens[0]);
    }
}
