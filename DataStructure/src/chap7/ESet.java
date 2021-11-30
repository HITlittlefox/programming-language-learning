package chap7;
//����7-5
class ESetNode{							//�����
	int data;							//����Ԫ��
	int parent;							//˫�׽��	
	public 	ESetNode()
		{}
}

public class ESet{						//���ϣ�������
	private ESetNode []x;				//����Ԫ��
	private int n;						//Ԫ�ظ���
			
	public ESet(int nn)
	//���캯������ʼʱ��ÿ������ֻ��һ������
	{
		this.n = nn;
		this.x = new ESetNode[n];
		
		for(int e = 1; e < n; e++)
		{
			x[e] = new ESetNode();   
			x[e].data = e;
			x[e].parent = -1;			//��ʼʱ�޸����
		}
	}

	int Find(int i)
	//�顣�������ذ������i�����ĸ����
	{
		int e = i;
		while(x[e].parent >= 0)
			e = x[e].parent;			//����һ��
		return e;						//���ؽ��i���������ĸ����
	}

	void Union(int i, int j)
	//��������Ϊj����������Ϊi������
	{
		x[j].parent = i;

		int e = Find(i);
		x[e].parent = x[e].parent - 1;	//�ۼӸ�Ϊi������Ԫ�ظ���
	}
	
	public static void main(String[] args){
		final int n = 10;
		ESet e = new ESet(n+1);

		//R = {(1,3),(3,5),(3,7),(2,4),(4,6),(2,8)}
		if( e.Find(1) != e.Find(3)) 
			e.Union(1, 3);
		if( e.Find(3) != e.Find(5)) 
			e.Union(3, 5);
		if( e.Find(3) != e.Find(7)) 
			e.Union(3, 7);
		if( e.Find(2) != e.Find(4)) 
			e.Union(2, 4);
		if( e.Find(4) != e.Find(6)) 
			e.Union(4, 6);
		if( e.Find(2) != e.Find(8)) 
			e.Union(2, 8);

		//���
		for(int i = 1; i <= n; i++)
			System.out.print(e.x[i].data +"    " + e.x[i].parent + "\n");
	}	
}
		


