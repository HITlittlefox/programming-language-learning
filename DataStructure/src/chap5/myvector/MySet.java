package chap5.myvector;

public interface MySet {
	public void add(Object o);

	// public void clear();
	public boolean contain(Object o);

	public boolean eqauls(Object o);

	public boolean isEmpty();

	public void remove(Object o);

	public int size();

	// public Object[] toArray();
	public MyIterator iterator();
}