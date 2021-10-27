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
//    Movie aMovie = new Movie("��ëŮ", "����Ƭ");
//    aMovie.addActor("�ﻪ");
//    aMovie.addActor("�����");
//    aMovie.addActor("��ǿ");
//    aStore.addMovie(aMovie);
//    aMovie = new Movie("����Ů��", "����Ƭ");
//    aMovie.addActor("�ﻪ");
//    aMovie.addActor("�¸�");
//    aStore.addMovie(aMovie);
//
//    aMovie = new Movie("��ɫ���Ӿ�", "����Ƭ");
//    aMovie.addActor("ףϣ��");
//    aMovie.addActor("���ĸ�");
//    aMovie.addActor("��ǿ");
//    aStore.addMovie(aMovie);
//    aMovie = new Movie("����", "����Ƭ");
//    aMovie.addActor("������");
//    aMovie.addActor("�Ե�");
//    aStore.addMovie(aMovie);
//
//    aMovie = new Movie("�ϸ���", "ս��Ƭ");
//    aMovie.addActor("��ǿ");
//    aMovie.addActor("�߱���");
//    aStore.addMovie(aMovie);
//    aMovie = new Movie("��·��ʹ", "ϲ��Ƭ");
//    aMovie.addActor("�Ե�");
//    aMovie.addActor("���");
//    aStore.addMovie(aMovie);
//
//    aMovie = new Movie("������", "���Ƭ");
//    aMovie.addActor("����");
//    aStore.addMovie(aMovie);
//    aMovie = new Movie("�ҵĸ���ĸ��", "����Ƭ");
//    aMovie.addActor("������");
//    aMovie.addActor("�����");
//    aStore.addMovie(aMovie);
//
//    aMovie = new Movie("�����", "����Ƭ");
//    aMovie.addActor("����");
//    aMovie.addActor("�w��");
//    aStore.addMovie(aMovie);
//   System.out.println("Here are the movies in: " + aStore);
//    aStore.listMovies();
//    System.out.println();
//    System.out.println("ɾ����ëŮ");
//    aStore.removeMovie("��ëŮ");
//    System.out.println("ɾ����մ��˾");
//    aStore.removeMovie("��մ��˾");
//    System.out.println("\n����Ƭ��");
//    aStore.listMoviesOfType("����Ƭ");
//    System.out.println("\n����Ƭ��");
//    aStore.listMoviesOfType("����Ƭ");
//    System.out.println("\n��ǿ�ĵ�Ӱ:");
//    aStore.listMoviesWithActor("��ǿ");
//    System.out.println("\n�Ե��ĵ�Ӱ:");
//    aStore.listMoviesWithActor("�Ե�");
//  }
//}