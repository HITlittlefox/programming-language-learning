package chap7;
//即例7-5
class ESetNode{							//结点类
	int data;							//数据元素
	int parent;							//双亲结点	
	public 	ESetNode()
		{}
}

public class ESet{						//集合（树）类
	private ESetNode []x;				//集合元素
	private int n;						//元素个数
			
	public ESet(int nn)
	//构造函数。初始时，每个树都只有一个子树
	{
		this.n = nn;
		this.x = new ESetNode[n];
		
		for(int e = 1; e < n; e++)
		{
			x[e] = new ESetNode();   
			x[e].data = e;
			x[e].parent = -1;			//初始时无父结点
		}
	}

	int Find(int i)
	//查。函数返回包含结点i的树的根结点
	{
		int e = i;
		while(x[e].parent >= 0)
			e = x[e].parent;			//上移一层
		return e;						//返回结点i所在子树的根结点
	}

	void Union(int i, int j)
	//并。将根为j的树并到根为i的树上
	{
		x[j].parent = i;

		int e = Find(i);
		x[e].parent = x[e].parent - 1;	//累加根为i的树的元素个数
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

		//输出
		for(int i = 1; i <= n; i++)
			System.out.print(e.x[i].data +"    " + e.x[i].parent + "\n");
	}	
}
		


