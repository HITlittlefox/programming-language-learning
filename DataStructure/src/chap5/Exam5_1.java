package chap5;
public class Exam5_1{
	public static void main(String[] args){
		try{
			DynamicArray a = new DynamicArray(10);
			int n = 10,temp;
			
			for(int i = 0; i < n; i++){
			temp = i + 1;
			a.arr[i] = new Integer(temp); 
			}
			System.out.println("a[6] = "+a.arr[6]);
			System.out.println("Size of a = "+a.size);
			
			DynamicArray b = new DynamicArray();
			b = a;
			System.out.println("b[6] = "+b.arr[6]);
			System.out.println("Size of b = "+b.size);
			
			a.reSize(40);
			a.arr[21] = new Integer(21);
			System.out.println("a[21] = "+a.arr[21]);
			System.out.println("Size of a = "+a.size);
			
			DynamicArray c = new DynamicArray(a);
			System.out.println("c[21] = "+c.arr[21]);
			System.out.println("Size of c = "+c.size);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}