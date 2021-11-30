package chap5.myvector;
public class Matrix{
	private MyVector values;
	private int h,w;
	
	public Matrix(int h,int w){
		if(!(h > 0 && w > 0))
			throw new ArrayIndexOutOfBoundsException("h or w  < " + 1);
		values = new MyVector(h);
		for(int i = 0; i < h; i++){
			MyVector row = new MyVector(w);
			values.add(row);
			for(int j = 0; j < w; j++){
				row.add(null);
			}
		}
		this.h = h;
		this.w = w;
	}
	
	public void set(int row,int col,Object value){
		if(!(row >= 0 && w >= 0 && row < h && col <w))
			throw new ArrayIndexOutOfBoundsException("h or w  < " + "-1");
		MyVector selrow = (MyVector)values.get(row);
		selrow.set(col,value); 
	}
	
	public Object get(int row,int col){
		if(!(row >= 0 && w >= 0 && row < h && col <w))
			throw new ArrayIndexOutOfBoundsException("h or w  < " + "-1");
		MyVector selrow = (MyVector)values.get(row);
		return selrow.get(col); 
	}
	
	public int width(){
		return w;
	}
	
	public int height(){
		return h;
	}
	
	public Matrix matrixAdd(Matrix anotherMatrix){
		if(height() != anotherMatrix.height() || width()!= anotherMatrix.width()){
			throw new ArrayIndexOutOfBoundsException("Matrix h and w error");
		}
		
		Matrix result = new Matrix(height(),width());
		
		for(int i = 0;i < height();i ++){
			for(int j = 0;j < width(); j ++){
				Integer i1 = (Integer)get(i,j);
				Integer i2 = (Integer)(anotherMatrix.get(i,j));				
				result.set(i,j,new Integer(i1.intValue()+i2.intValue()));				
			}
		}
		
		return result;
	}
	
	public void print(){
		for(int i = 0; i < h; i++){
			for(int j = 0; j < w; j++){
				System.out.print(get(i,j)+" ");
			}
			System.out.println();
		}
	}	

/*	
	public void addRow(int r){
		if(r < 0 || r >= h)
			throw new ArrayIndexOutOfBoundsException("r  error " + r);
		h = h + 1;		
		values.add(r,new MyVector(w));
	}
	
	public void addCol(int c){
		if(c < 0 || c >= w)
			throw new ArrayIndexOutOfBoundsException("c  error " + c);
		w = w + 1;
		for(int i = 0; i < h; i++){
			MyVector selrow = (MyVector)values.get(i);
			selrow.add(i,null);
		}
	}
	
*/
	public MyVector removeRow(int r){
		if(r < 0 || r >= h)
			throw new ArrayIndexOutOfBoundsException("r  erorr " + r);
		h = h - 1;
		MyVector removed = (MyVector)values.get(r);
		values.remove(r);
		return removed;
	}
	
	public MyVector removeCol(int c){
		if(c < 0 || c >= w)
			throw new ArrayIndexOutOfBoundsException("c  erorr " + c);
		w = w - 1;
		MyVector removed = new MyVector(h);
		for(int i = 0; i < h; i++){
			MyVector selrow = (MyVector)values.get(i);
			removed.add(selrow.get(c));
			selrow.remove(c);
		}
		return removed;
	}
}