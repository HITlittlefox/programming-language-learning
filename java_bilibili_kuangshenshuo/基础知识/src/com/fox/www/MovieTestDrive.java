package com.fox.www;

class Movie {
    String title;
    String genre;
    int rating;

    void playIt() {
        System.out.println("Playing the movie");
        System.out.println("The " + rating + " rating " + genre + " movie " + title + " is playing.");
    }
}

public class MovieTestDrive {
    public static void main(String[] args) {
        Movie one = new Movie();
        one.title = "Harry Potter";
        one.genre = "Growth";
        one.rating = 100;
        one.playIt();
        Movie two = new Movie();
        two.title = "Let the Bullets Fly";
        two.genre = "Growth";
        two.rating = 100;
        two.playIt();
        Movie three = new Movie();
        three.title = "TheTrumanShow";
        three.genre = "Growth";
        three.rating = 100;
        three.playIt();

    }
}
