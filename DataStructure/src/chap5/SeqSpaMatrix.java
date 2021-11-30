package chap5;
public class SeqSpaMatrix{
	int rows;
	int cols;
	int dNum;
	MyVector v;
	
	SeqSpaMatrix(int max){
		rows = cols = dNum = 0;
		v = new MyVector(max);
	}
	
	public void createMatrix(int r, int c, int d, Three[] item) throws Exception{
		rows = r;
		cols = c;
		dNum = d;
		
		for(int i = 0; i < d; i ++){
			v.add(i, item[i]);
		}
	}
	
	public SeqSpaMatrix transpose(){
		SeqSpaMatrix a = new SeqSpaMatrix(v.size());
		
		a.cols = rows;
		a.rows = cols;
		a.dNum = dNum;
		
		for(int i = 0; i < dNum; i ++){
			Three temp = new Three();
			temp.row = ((Three)v.get(i)).col;
			temp.col = ((Three)v.get(i)).row;
			temp.value = ((Three)v.get(i)).value;
			a.v.add(i,temp);
		}
		return a;
	}
	
	public void print(){
		System.out.print("矩阵行数为：" + rows);
		System.out.print(" 矩阵列数为：" + cols);
		System.out.println("，非零元个数为：" + dNum);
		
		System.out.println("矩阵非零元三元组为：");
		for(int i = 0; i < dNum; i ++){
			System.out.println("a<" + ((Three)v.get(i)).row + "," + ((Three)v.get(i)).col + ">=" + ((Three)v.get(i)).value);
		}	
	}
/*
	public void transpose2(SeqSpaMatrix a){
		if(a.maxSize < maxSize){
			a.listArray = new Object[maxSize];
			a.maxSize = maxSize;
		}
		
		a.cols = rows;
		a.rows = cols;
		a.dNum = dNum;
	    try{
			if(dNum == 0) return;
			else{
				int i = 0;
				for(int k = 1; k <= cols; k ++){
					for(int j = 0; j < a.dNum; j ++){
						if(((Three)listArray[j]).col == k){
							Three temp = new Three();
							temp.row = ((Three)listArray[j]).col;
							temp.col = ((Three)listArray[j]).row;
							temp.value = ((Three)listArray[j]).value;
							a.listArray[i] = temp;
							i ++;
						}
					}
				}
			}
	    }	
		catch(Exception e){
			e.printStackTrace();
		}
	}	
*/
}

class Three{
	int row;
	int col;
	double value;
	
	public Three(int r, int c, double v){
		row = r;
		col = c;
		value = v;
	}
	
	Three(){
	}
}