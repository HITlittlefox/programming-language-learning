package chap5.myvector;
//public class ObjectSet implements MySet{
public class ObjectSet{
	private MyVector values = new MyVector();
	private static final Object nullObject = new Object();
	
	public void add(Object o){
		if(o == null)
			o = nullObject;
		if(values.indexOf(o)<0)
			values.add(o);
	}
	
//	public void clear(){
//		values.removeAll();
//	}
	
	public boolean contain(Object o){
		if(o == null)
			o = nullObject;
		return values.contain(o);
	}
	
	public boolean eqauls(Object o){	
		if(o instanceof ObjectSet){
			ObjectSet set = (ObjectSet)o;
			
			MyIterator it = set.iterator();
			while(it.hasNext()){
				Object temp = it.next();
				if(!contain(temp == null ? nullObject : temp))
					return false;
			}
			MyIterator thisit = this.iterator();
			while(thisit.hasNext()){
				Object temp = thisit.next();
				if(!set.contain(temp == null ? nullObject : temp))
					return false;
			}
			return true;
		}
		else
			return false;
		
	}
	
	public boolean isEmpty(){
		return values.size() > 0;
	}
	public void remove(Object o){
		if(o == null)
			o = nullObject;
		values.remove(o);
	}
	public int size(){
		return values.size();
	}
//	public Object[] toArray(){
//		return values.toArray();
//	}
	
	public MyIterator iterator(){
		return new MyIterator(){
			int counter = 0;
			public boolean hasNext(){
				return counter < values.size();
			}
		
			public Object next(){
				Object temp = values.get(counter);
				counter ++;
				if(temp == nullObject)
					temp = null;
				return temp;
			}
		};
	}	
}