package chap2.SeqList;

//他是个接口，他需要别人实现他。
public interface List {
   public void insert(int i, Object obj) throws Exception;

   public Object delete(int i) throws Exception;

   public Object getData(int i) throws Exception;

   public int size();

   public boolean isEmpty();
}