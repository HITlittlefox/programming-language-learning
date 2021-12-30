package chap2.exec2.hw216;

// 单文件，直接把List接口、SeqList类集成在这个文件中。
//2-16编写一个函数,要求把顺序表A中的数据元素序列逆置后存储到顺序表B中
//seqList是要逆序的表
public class Hw216 {
    public static void main(String[] args) {
        // String[] table = new String[] { "A", "B", "C", "*", "1", "2", "3" };
        SeqList seqList = new SeqList(100);
        int n = 10;
        try {
            for (int i = 0; i < n; i++) {
                seqList.insert(i, new Integer(i + 1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("逆序前的seqList：");
        try {
            for (int i = 0; i < seqList.size(); i++) {

                System.out.print(seqList.getData(i) + "   ");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            seqList = reversedOrder(seqList);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } // 开始逆序

        System.out.println("逆序后的seqList：");
        try {
            for (int i = 0; i < seqList.size(); i++) {

                System.out.print(seqList.getData(i) + "   ");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //把顺序表A中的数据元素序列逆置后存储到顺序表B
    public static SeqList reversedOrder(SeqList seqList) throws Exception {
        for (int i = 0; i < (seqList.size() + 1) / 2; i++) {
            //拿出来最前面的
            int t = (int) seqList.getData(i);
            //删除最前面的
            seqList.delete(i);
            //把后面的塞到前面
            seqList.insert(i, seqList.getData(seqList.size() - 1 - i));
            // seqList(i) = seqList[seqList.size() - 1 - i];
            //删除后面的
            seqList.delete(seqList.size() - 1 - i);
            //把前面的塞到后面
            seqList.insert(seqList.size() - i, t);

        }
        return seqList;
    }

}

// 他是个接口，他需要别人实现他。
interface List {
    public void insert(int i, Object obj) throws Exception;

    public Object delete(int i) throws Exception;

    public Object getData(int i) throws Exception;

    public int size();

    public boolean isEmpty();
}

// 顺序表类实现**接口List**。
class SeqList implements List {
    final int defaultSize = 10;

    int maxSize;
    int size;
    Object[] listArray;

    public SeqList() {
        initiate(defaultSize);
    }

    public SeqList(int size) {
        initiate(size);
    }

    private void initiate(int sz) {
        maxSize = sz;
        size = 0;
        listArray = new Object[sz];
    }

    public void insert(int i, Object obj) throws Exception {
        if (size == maxSize) {
            throw new Exception("顺序表已满无法插入！");
        }
        if (i < 0 || i > size) {
            throw new Exception("参数错误！");
        }

        for (int j = size; j > i; j--) {
            listArray[j] = listArray[j - 1];
        }

        listArray[i] = obj;
        size++;
    }

    public Object delete(int i) throws Exception {
        if (size == 0) {
            throw new Exception("顺序表已空无法删除！");
        }
        if (i < 0 || i > size - 1) {
            throw new Exception("参数错误！");
        }
        Object it = listArray[i];
        for (int j = i; j < size - 1; j++) {
            listArray[j] = listArray[j + 1];
        }

        size--;
        return it;
    }

    public Object getData(int i) throws Exception {
        if (i < 0 || i >= size) {
            throw new Exception("参数错误！");
        }
        return listArray[i];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int MoreDataDelete(SeqList L, Object x) throws Exception {

        int i, j;
        int tag = 0;

        for (i = 0; i < L.size; i++) {
            if (x.equals(L.getData(i))) {
                L.delete(i);
                i--;
                tag = 1;
            }
        }

        return tag;
    }
}
