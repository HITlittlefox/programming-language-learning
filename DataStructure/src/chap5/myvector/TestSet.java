package chap5.myvector;
public class TestSet{
	public static void main(String[] args){		
		ObjectSet os1 = new ObjectSet();
		ObjectSet os2 = new ObjectSet();	
		//add null, 0, 2, 5
		os1.add(new Integer(0));
		os1.add(null);
		os1.add(new Integer(2));
		os1.add(new Integer(0));
		os1.add(new Integer(5));
		os1.add(null);
		
		os2.add(new Integer(5));
		os2.add(new Integer(0));
		os2.add(new Integer(2));
		os2.add(null);
		os2.add(new Integer(5));
		os2.add(new Integer(2));
	
		MyIterator it1 = os1.iterator();
		while(it1.hasNext()){
			System.out.print(it1.next()+" ");
		}
		
		System.out.println();		
		MyIterator it2 = os2.iterator();
		while(it2.hasNext()){
			System.out.print(it2.next()+" ");
		}
		
		System.out.println("\n"+os1.eqauls(os2));
	}
}