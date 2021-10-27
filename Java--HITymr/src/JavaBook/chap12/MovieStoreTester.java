//package JavaBook.chap12;
//
//import java.util.*;
// class Movie {
//   private String  title, type;
//   private Vector  actors;
//   public String getTitle() { return title; }
//   public String getType() { return type; }
//   public Vector getActors() { return actors; }
//   public void setTitle(String aTitle) { title = aTitle; }
//   public void setType(String aType) { type = aType; }
//   public Movie() {   this("???", "???");  }
//   public Movie(String aTitle, String aType) {
//        title = aTitle;
//        type = aType;
//        actors = new Vector();
//    }
//    public String toString() {
//        return("Movie: " + "\"" + title + "\"");
//    }
//    public void addActor(String anActor) {
//        actors.add(anActor);
//    }
//}
//
//class MovieStore {
//    private Hashtable movieList, actorList, typeList;
//     public Hashtable getMovieList() { return movieList; }
//     public Hashtable getActorList() { return actorList; }
//     public Hashtable getTypeList() { return typeList; }
//    public MovieStore() {
//        movieList = new Hashtable();
//        actorList = new Hashtable();
//        typeList  = new Hashtable();
//     }
//   public String toString() {
//        return ("MovieStore with " + movieList.size() + " movies.");
//    }
//
//    public void addMovie(Movie aMovie) {
//        movieList.put(aMovie.getTitle(), aMovie);
//        if (!typeList.containsKey(aMovie.getType()))
//            typeList.put(aMovie.getType(), new Vector());
//        ((Vector)typeList.get(aMovie.getType())).add(aMovie);
//        for (int i=0; i<aMovie.getActors().size(); i++) {
//            String anActor = (String)aMovie.getActors().get(i);
//            if (!actorList.containsKey(anActor))
//               actorList.put(anActor, new Vector());
//           ((Vector)actorList.get(anActor)).add(aMovie);
//        }
//    }
//
//    private void removeMovie(Movie aMovie) {
//        movieList.remove(aMovie.getTitle());
//        ((Vector)typeList.get(aMovie.getType())).remove(aMovie);
//         if (((Vector)typeList.get(aMovie.getType())).isEmpty())
//            typeList.remove(aMovie.getType());
//        for(int i=0; i<aMovie.getActors().size(); i++) {
//            String anActor = (String)aMovie.getActors().get(i);
//            ((Vector)actorList.get(anActor)).remove(aMovie);
//            if (((Vector)actorList.get(anActor)).isEmpty())
//                actorList.remove(anActor);
//         }
//    }
//
//    public void removeMovie(String aTitle) {
//        if (movieList.get(aTitle) == null)
//            System.out.println("No movie with that title");
//        else
//            removeMovie((Movie)movieList.get(aTitle));
//    }
//
//    public void listMovies() {
//        Enumeration  titles = movieList.keys();
//        while(titles.hasMoreElements())
//            System.out.println(titles.nextElement());
//    }
//
//   public void listMoviesWithActor(String anActor) {
//        Enumeration someMovies = ((Vector)actorList.get(anActor)).elements();
//        while(someMovies.hasMoreElements())
//             System.out.println(someMovies.nextElement());
//   }
//
//   public void listMoviesOfType(String aType) {
//       Enumeration  someMovies = ((Vector)typeList.get(aType)).elements();
//       while(someMovies.hasMoreElements())
//           System.out.println(someMovies.nextElement());
//   }
//}
//
//public class MovieStoreTester{
//public static void main(String args[]) {
//    MovieStore  aStore = new MovieStore();
//    Movie aMovie = new Movie("白毛女", "悲剧片");
//    aMovie.addActor("田华");
//    aMovie.addActor("李百万");
//    aMovie.addActor("陈强");
//    aStore.addMovie(aMovie);
//    aMovie = new Movie("党的女儿", "教育片");
//    aMovie.addActor("田华");
//    aMovie.addActor("陈戈");
//    aStore.addMovie(aMovie);
//
//    aMovie = new Movie("红色娘子军", "教育片");
//    aMovie.addActor("祝希娟");
//    aMovie.addActor("王心刚");
//    aMovie.addActor("陈强");
//    aStore.addMovie(aMovie);
//    aMovie = new Movie("五朵金花", "爱情片");
//    aMovie.addActor("陈丽坤");
//    aMovie.addActor("赵丹");
//    aStore.addMovie(aMovie);
//
//    aMovie = new Movie("上甘岭", "战斗片");
//    aMovie.addActor("陈强");
//    aMovie.addActor("高保成");
//    aStore.addMovie(aMovie);
//    aMovie = new Movie("马路天使", "喜剧片");
//    aMovie.addActor("赵丹");
//    aMovie.addActor("周璇");
//    aStore.addMovie(aMovie);
//
//    aMovie = new Movie("少林寺", "武打片");
//    aMovie.addActor("葛优");
//    aStore.addMovie(aMovie);
//    aMovie = new Movie("我的父亲母亲", "爱情片");
//    aMovie.addActor("章子怡");
//    aMovie.addActor("孙红雷");
//    aStore.addMovie(aMovie);
//
//    aMovie = new Movie("红高粮", "艺术片");
//    aMovie.addActor("巩俐");
//    aMovie.addActor("葁文");
//    aStore.addMovie(aMovie);
//   System.out.println("Here are the movies in: " + aStore);
//    aStore.listMovies();
//    System.out.println();
//    System.out.println("删除白毛女");
//    aStore.removeMovie("白毛女");
//    System.out.println("删除秋菊打官司");
//    aStore.removeMovie("秋菊打官司");
//    System.out.println("\n教育片：");
//    aStore.listMoviesOfType("教育片");
//    System.out.println("\n爱情片：");
//    aStore.listMoviesOfType("爱情片");
//    System.out.println("\n陈强的电影:");
//    aStore.listMoviesWithActor("陈强");
//    System.out.println("\n赵丹的电影:");
//    aStore.listMoviesWithActor("赵丹");
//  }
//}