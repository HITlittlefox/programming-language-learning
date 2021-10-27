package JavaBook.chap12;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

class Movie {
    private String title, type;
    private Vector<String> actors;

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public Vector<String> getActors() {
        return actors;
    }

    public void setTitle(String aTitle) {
        title = aTitle;
    }

    public void setType(String aType) {
        type = aType;
    }

    public Movie() {
        this("???", "???");
    }

    public Movie(String aTitle, String aType) {
        title = aTitle;
        type = aType;
        actors = new Vector<String>();
    }

    public String toString() {
        return ("Movie: " + "\"" + title + "\"");
    }

    public void addActor(String anActor) {
        actors.add(anActor);
    }

}
//@java.lang.reflect.Constructor
//@java.lang.reflect.Constructor
//@java.lang.reflect.Constructor
//@java.lang.annotation.Annotation
@SuppressWarnings("unchecked")
class MovieStore {
    private Hashtable<String, Movie> movieList;
    private Hashtable<String, Vector<Movie>> actorList;
    private Hashtable<String, Vector<Movie>> typeList;

    public Hashtable<String, Movie> getMovieList() {
        return movieList;
    }

    public Hashtable<String, Vector<Movie>> getActorList() {
        return actorList;
    }

    public Hashtable<String, Vector<Movie>> getTypeList() {
        return typeList;
    }

    public MovieStore() {
        movieList = new Hashtable<String, Movie>();
        actorList = new Hashtable<String, Vector<Movie>>();
        typeList = new Hashtable<String, Vector<Movie>>();
    }

    public String toString() {
        return ("MovieStore with " + movieList.size() + " movies.");
    }

    public void addMovie(Movie aMovie) {
        movieList.put(aMovie.getTitle(), aMovie);
        //如果没有这个类型，就创建这个类型；否则，直接加
        if (!typeList.containsKey(aMovie.getType())) {
            typeList.put(aMovie.getType(), new Vector());
        }
        (typeList.get(aMovie.getType())).add(aMovie);
        for (int i = 0; i < aMovie.getActors().size(); i++) {
            String anActor = (aMovie.getActors()).get(i);
            if (!actorList.containsKey(anActor))
                actorList.put(anActor, new Vector());
            (actorList.get(anActor)).add(aMovie);
        }
    }

    private void removeMovie(Movie aMovie) {
        movieList.remove(aMovie.getTitle());
        (typeList.get(aMovie.getType())).remove(aMovie);
        if ((typeList.get(aMovie.getType())).isEmpty())
            typeList.remove(aMovie.getType());
        for (int i = 0; i < aMovie.getActors().size(); i++) {
            String anActor = aMovie.getActors().get(i);
            (actorList.get(anActor)).remove(aMovie);
            if ((actorList.get(anActor)).isEmpty())
                actorList.remove(anActor);
        }
    }

    public void removeMovie(String aTitle) {
        if (movieList.get(aTitle) == null)
            System.out.println("No movie with that title");
        else
            removeMovie((Movie) movieList.get(aTitle));
    }

    public void listMovies() {
        Enumeration<String> titles = movieList.keys();
        while (titles.hasMoreElements())
            System.out.println(titles.nextElement());
    }

    public void listMoviesWithActor(String anActor) {
        Enumeration<Movie> someMovies = (actorList.get(anActor)).elements();
        while (someMovies.hasMoreElements())
            System.out.println(someMovies.nextElement());
    }

    public void listMoviesOfType(String aType) {
        Enumeration<Movie> someMovies = (typeList.get(aType)).elements();
        while (someMovies.hasMoreElements())
            System.out.println(someMovies.nextElement());
    }
}

public class MovieStoreTester1 {
    public static void main(String args[]) {
        MovieStore aStore = new MovieStore();
        Movie aMovie = new Movie("白毛女", "悲剧片");
        aMovie.addActor("田华");
        aMovie.addActor("李百万");
        aMovie.addActor("陈强");
        aStore.addMovie(aMovie);
        aMovie = new Movie("党的女儿", "教育片");
        aMovie.addActor("田华");
        aMovie.addActor("陈戈");
        aStore.addMovie(aMovie);

        aMovie = new Movie("红色娘子军", "教育片");
        aMovie.addActor("祝希娟");
        aMovie.addActor("王心刚");
        aMovie.addActor("陈强");
        aStore.addMovie(aMovie);
        aMovie = new Movie("五朵金花", "爱情片");
        aMovie.addActor("陈丽坤");
        aMovie.addActor("赵丹");
        aStore.addMovie(aMovie);

        aMovie = new Movie("上甘岭", "战斗片");
        aMovie.addActor("陈强");
        aMovie.addActor("高保成");
        aStore.addMovie(aMovie);
        aMovie = new Movie("马路天使", "喜剧片");
        aMovie.addActor("赵丹");
        aMovie.addActor("周璇");
        aStore.addMovie(aMovie);

        aMovie = new Movie("少林寺", "武打片");
        aMovie.addActor("葛优");
        aStore.addMovie(aMovie);
        aMovie = new Movie("我的父亲母亲", "爱情片");
        aMovie.addActor("章子怡");
        aMovie.addActor("孙红雷");
        aStore.addMovie(aMovie);

        aMovie = new Movie("红高粮", "艺术片");
        aMovie.addActor("巩俐");
        aMovie.addActor("葁文");
        aStore.addMovie(aMovie);
        System.out.println("Here are the movies in: " + aStore);
        aStore.listMovies();
        System.out.println();
        System.out.println("删除白毛女");
        aStore.removeMovie("白毛女");
        System.out.println("删除秋菊打官司");
        aStore.removeMovie("秋菊打官司");
        System.out.println("\n教育片：");
        aStore.listMoviesOfType("教育片");
        System.out.println("\n爱情片：");
        aStore.listMoviesOfType("爱情片");
        System.out.println("\n陈强的电影:");
        aStore.listMoviesWithActor("陈强");
        System.out.println("\n赵丹的电影:");
        aStore.listMoviesWithActor("赵丹");
    }
}