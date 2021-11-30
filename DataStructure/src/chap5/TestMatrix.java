package chap5;
public class TestMatrix{
	public static void main(String[] args){
		Matrix mt1 = new Matrix(3,4);				//创建第一个矩阵
		for(int i = 0;i < mt1.height(); i++){
			for(int j = 0;j < mt1.width();j ++){
				mt1.set(i,j,new Integer(i+j));		//给矩阵元素赋值
			}			
		}
		
		Matrix mt2 = new Matrix(3,4); 				//创建第二个矩阵
		for(int i = 0;i < mt2.height(); i++){
			for(int j = 0;j < mt2.width();j ++){											mt2.set(i,j,new Integer((int)(Math.random() * 10)));
							//调用随机数函数产生随机数给矩阵元素赋值
			}			
		}
		
		System.out.println("Matrix 1:");
		mt1.print();							//输出第一个矩阵的元素
		System.out.println("Matrix 2:");
		mt2.print();							//输出第二个矩阵的元素

		Matrix mt3 = mt2.add(mt1);				//矩阵加
		System.out.println("results after adding :");
		mt3.print();							//输出矩阵加后的元素
	}
}
