package chap5.myvector;
public class MyHashTable{
	private Entry[] values;
	private int count = 0;
	
	public MyHashTable(){
		this(13);
	}
	public MyHashTable(int length){
		values = new Entry[length];
	}
	
	public void put(Object o){
		if(o == null){
			System.out.println("object is null");
			return;
		} 
		if(count == values.length){
			System.out.println("hashtable is full");
			return;
		}
		int index = find(o);
		if(exist(o)) return;
		values[index] = new Entry(o,values[index]);
		count ++;
	}
	
	public Object delete(Object o){
		if(o == null) return null;
		int index = find(o);
		Entry prev = values[index];
		Entry e = prev;
		while (e != null) {
            Entry next = e.next;
            if (o.equals(e.data)) {               
                if (prev == e) 
                    values[index] = next;
                else
                    prev.next = next;
                count --;                
                return e;
            }
            prev = e;
            e = next;
        }   
        return e;		
	}
	
	public boolean exist(Object o){
		if(o == null) return false;
		int index = find(o);
		Entry e = values[index];
		while(e != null){
			if(o.equals(e.data)) return true;
			e = e.next;
		}
		return false;
	}
	
	public int count(){
		return count;
	}
	
	public ObjectSet dataSet(){
		ObjectSet result = new ObjectSet();
		for(int i = 0; i< values.length; i ++){
			Entry temp = values[i];
			while(temp != null){
				result.add(temp.data);
				temp = temp.next;
			}
		}
		return result;
	}
	
	private int find(Object o){		
		return o.hashCode() % values.length;		
	}

	private class Entry{
		Object data;
		Entry next;
	
		Entry(Object data,Entry next){
			this.data = data;
			this.next = next;
		}
	}
}