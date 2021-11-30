package chap5.myvector;
public class TestMyHashTable{
	public static void main(String[] args){
		MyHashTable mht = new MyHashTable();
		mht.put(new Integer(0));
		mht.put(new Integer(2));
		mht.put(new Integer(0));
		mht.put(new Integer(5));
		mht.put(null);
		mht.put(new Integer(5));
		mht.put(new Integer(8));
		mht.put(new Integer(2));
		mht.put(new Integer(9));
		mht.put(new Integer(16));
		mht.put(new Integer(9));
		mht.put("yjf");
		
		MySet ms = (MySet) mht.dataSet();
		MyIterator it = ms.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println("\nelement count is "+mht.count());
		
		System.out.println("5 exist "+mht.exist(new Integer(5)));
		mht.delete(new Integer(5));
		System.out.println("5 exist "+mht.exist(new Integer(5)));
		
		System.out.println("yjf exist "+mht.exist("yjf"));
		
		ms = (MySet) mht.dataSet();
		it = ms.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		System.out.println("\nelement count is "+mht.count());
		
	}
}