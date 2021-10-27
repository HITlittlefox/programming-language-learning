package HomeWork;
//作业11：音像店的出租电影业务综合例子,要求：代码中容器的使用采用泛型实现
//例:音像店的出租电影业务，在实际应用中，可能会通过以下方式查找需要的电影:
//1. 通过标题(title)查找电影；
//2. 可将电影分成不同的类型(type)，如喜剧片、悲剧片、战斗片等。因此在进行出租时，可在某一特定的类型中查找电影；
//3. 查找包括某一演员(actor/actress)的电影。
//如果使用向量(Vector/ArrayList)来存储所有的电影，在查找的时候很浪费时间；
//使用HashTable对电影进行有效存储，使得在需要时能够很快找到。


import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

//首先考虑电影类Movie，其属性包括：标题(title)、演员列表(actors)、类型(type)
class Movie {
    private String title;
    private String type;
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

    //无参构造函数，会把两个"???"传给后面的构造函数
    public Movie() {
        this("???", "???");
    }

    //构造函数
    public Movie(String aTitle, String aType) {
        title = aTitle;
        type = aType;
        actors = new Vector();
    }

    @Override
    public String toString() {
        return ("Movie: " + "\"" + title + "\"");
    }

    public void addActor(String anActor) {
        actors.add(anActor);
    }
}

//下面考虑MovieStore类，
//为了达到能按开始提到的不同条件进行快速查找的目的，在MovieStore类中，可以建立下面三个哈希表(HashTable对象)：
//电影表(movieList)：以标题(title)为关键字(key)，以具有此标题的Movie对象为值(value)；
//演员表(actorList)：以演员的名字为关键字，其值为此演员参与的所有电影（以向量存储）；
//类型表(typeList)：以类型名为关键字，其值为属于此类型的所有电影（以向量存储）。
//@SuppressWarnings("all")
class MovieStore {
    private Hashtable movieList, actorList, typeList;

    public Hashtable getMovieList() {
        return movieList;
    }

    public Hashtable getActorList() {
        return actorList;
    }

    public Hashtable getTypeList() {
        return typeList;
    }

    //构造函数
    public MovieStore() {
        movieList = new Hashtable();
        actorList = new Hashtable();
        typeList = new Hashtable();
    }

    @Override
    public String toString() {
        return ("MovieStore with " + movieList.size() + " movies.");
    }

    //当我们向MovieStore对象中增加一个Movie对象时，
    //该对象需要增加到电影表、类型表及演员表中。
    //为MovieStore类添加一个addMovie方法：
    public void addMovie(Movie aMovie) {

        //在电影清单中放入电影名和电影的信息
        movieList.put(aMovie.getTitle(), aMovie);

        //如果没有类型键，就放入类型键，和一个vector的实例化对象
        if (!typeList.containsKey(aMovie.getType())) {
            typeList.put(aMovie.getType(), new Vector());
        }
        ((Vector) typeList.get(aMovie.getType())).add(aMovie);

        //如果没有角色键，就放入角色键，和一个vector的实例化对象
        for (int i = 0; i < aMovie.getActors().size(); i++) {
            String anActor = (String) aMovie.getActors().get(i);
            if (!actorList.containsKey(anActor)) {
                actorList.put(anActor, new Vector());
            }
            ((Vector) actorList.get(anActor)).add(aMovie);
        }
    }

    //从MovieStore中删除一个Movie对象
    private void removeMovie(Movie aMovie) {
        movieList.remove(aMovie.getTitle());
        ((Vector) typeList.get(aMovie.getType())).remove(aMovie);

        if (((Vector) typeList.get(aMovie.getType())).isEmpty())
            typeList.remove(aMovie.getType());
        for (int i = 0; i < aMovie.getActors().size(); i++) {
            String anActor = (String) aMovie.getActors().get(i);
            //使用remove方法，删除内容
            ((Vector) actorList.get(anActor)).remove(aMovie);
            if (((Vector) actorList.get(anActor)).isEmpty())
                actorList.remove(anActor);
        }
    }

    //已知一个Movie对象的title，将其从MovieStore对象中删除：
    public void removeMovie(String aTitle) {
        if (movieList.get(aTitle) == null)
            System.out.println("No movie with that title");
        else
            removeMovie((Movie) movieList.get(aTitle));
    }

    //输出所有Movie对象的标题：
    public void listMovies() {
        Enumeration titles = movieList.keys();
        while (titles.hasMoreElements())
            System.out.println(titles.nextElement());
    }

    //输出给定演员参加的所有电影：
    public void listMoviesWithActor(String anActor) {
        Enumeration someMovies = ((Vector) actorList.get(anActor)).elements();
        while (someMovies.hasMoreElements())
            System.out.println(someMovies.nextElement());
    }

    //输出属于给定类型的所有电影：
    public void listMoviesOfType(String aType) {
        Enumeration someMovies = ((Vector) typeList.get(aType)).elements();
        while (someMovies.hasMoreElements())
            System.out.println(someMovies.nextElement());
    }


}

//编写测试类，对上面定义的方法进行测试
public class MovieStoreTester {
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
