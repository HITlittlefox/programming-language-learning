package chap5;
public class DynamicArray{
	Object[] arr;
	int size;
	
	DynamicArray(){	
		arr = new Object[10];
		size = 10;
	}
	DynamicArray(int sz) throws Exception{
		if(sz <= 0){
			throw new Exception("无效的数组个数");
		}
		arr = new Object[sz];
		size = sz;
	}
	
	DynamicArray(DynamicArray a){
		arr = new Object[a.size];
		for(int i = 0; i < a.size; i ++){
			arr[i] = a.arr[i];
		}
		size = a.size;
	}
	
	public void reSize(int sz) throws Exception{
		if(sz <= 0){
			throw new Exception("无效的数组个数");
		}
		if(sz == size) return;
		Object[] newArray = new Object[sz];
		int n = (sz <= size) ? sz:size;
		for(int i = 0; i < n; i++){
			newArray[i] = this.arr[i];
		}
		arr = newArray;
		size = sz;
	}
}