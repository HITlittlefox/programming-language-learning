package chap5;
public class TestMatrix{
	public static void main(String[] args){
		Matrix mt1 = new Matrix(3,4);				//������һ������
		for(int i = 0;i < mt1.height(); i++){
			for(int j = 0;j < mt1.width();j ++){
				mt1.set(i,j,new Integer(i+j));		//������Ԫ�ظ�ֵ
			}			
		}
		
		Matrix mt2 = new Matrix(3,4); 				//�����ڶ�������
		for(int i = 0;i < mt2.height(); i++){
			for(int j = 0;j < mt2.width();j ++){											mt2.set(i,j,new Integer((int)(Math.random() * 10)));
							//����������������������������Ԫ�ظ�ֵ
			}			
		}
		
		System.out.println("Matrix 1:");
		mt1.print();							//�����һ�������Ԫ��
		System.out.println("Matrix 2:");
		mt2.print();							//����ڶ��������Ԫ��

		Matrix mt3 = mt2.add(mt1);				//�����
		System.out.println("results after adding :");
		mt3.print();							//�������Ӻ��Ԫ��
	}
}
