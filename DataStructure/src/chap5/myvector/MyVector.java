package chap5.myvector;

public class MyVector {
	private Object[] elementData;
	private int elementCount;

	// 容量扩充
	private void ensureCapacity(int minCapacity) {
		int oldCapacity = elementData.length;
		if (minCapacity > oldCapacity) {
			Object oldData[] = elementData;
			int newCapacity = oldCapacity * 2;
			if (newCapacity < minCapacity) {
				newCapacity = minCapacity;
			}
			elementData = new Object[newCapacity];
			System.arraycopy(oldData, 0, elementData, 0, elementCount);
		}
	}

	// 无参构造方法
	public MyVector() {
		this(10);
	}

	public MyVector(int initialCapacity) {
		elementData = new Object[initialCapacity];
		elementCount = 0;
	}

	public void add(int index, Object element) {
		// 抛出异常
		if (index >= elementCount + 1) {
			throw new ArrayIndexOutOfBoundsException(index + " > " + elementCount);
		}
		ensureCapacity(elementCount + 1);
		System.arraycopy(elementData, index, elementData, index + 1, elementCount - index);
		elementData[index] = element;
		elementCount++;
	}

	// 在最后添加
	public void add(Object element) {
		add(elementCount, element);
	}

	public void set(int index, Object element) {
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
		}
		elementData[index] = element;
	}

	public Object get(int index) {
		if (index >= elementCount)
			throw new ArrayIndexOutOfBoundsException(index);
		return elementData[index];
	}

	public int size() {
		return elementCount;
	}

	public int indexOf(Object element) {
		if (element == null) {
			for (int i = 0; i < elementCount; i++)
				if (elementData[i] == null)
					return i;
		} else {
			for (int i = 0; i < elementCount; i++)
				if (element.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	public void remove(Object obj) {
		int i = indexOf(obj);
		if (i >= 0) {
			remove(i);
		}
	}

	public boolean contain(Object element) {
		return indexOf(element) >= 0;
	}

	// public void trimToSzie(){
	// int oldCapacity = elementData.length;
	// if (elementCount < oldCapacity) {
	// Object oldData[] = elementData;
	// elementData = new Object[elementCount];
	// System.arraycopy(oldData, 0, elementData, 0, elementCount);
	// }
	// }

	// public Object[] toArray(){
	// Object[] result = new Object[elementCount];
	// System.arraycopy(elementData, 0, result, 0, elementCount);
	// return result;
	// }
	/*
	 * public void removeAll(){ for (int i = 0; i < elementCount; i++)
	 * elementData[i] = null; elementCount = 0; }
	 */
	public void remove(int index) {
		if (index >= elementCount) {
			throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
		} else if (index < 0) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		int j = elementCount - index - 1;
		if (j > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, j);
		}
		elementCount--;
		elementData[elementCount] = null;
	}

	// public static void vectorCopy(MyVector src,int possrc,MyVector dst,int
	// posdst,int count){
	// int length1 = src.size();
	// int length2 = dst.size();
	// if(length1 - possrc < count || length2 - posdst < count)
	// throw new ArrayIndexOutOfBoundsException(count);
	// for(int i = 0;i < src.size();i ++){
	// dst.add(src.get(i));
	// }
	// }

	// public String toString(){
	// String str="";
	// for(int i = 0;i < elementCount;i ++){
	// str = str + get(i).toString() + " ";
	// }
	// return str;
	// }
}