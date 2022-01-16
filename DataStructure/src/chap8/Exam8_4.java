package chap8;
public class Exam8_4{
	static final int maxVertices = 100;

	public static void createGraph(AdjMWGraph g, Object[] v, int n, RowColWeight[] rc, int e) throws Exception{
		for(int i = 0; i < n; i ++)
			g.insertVertex(v[i]);
		for(int k = 0; k < e; k ++)
			g.insertEdge(rc[k].row, rc[k].col, rc[k].weight);
	}

	public static void main(String[] args){
		AdjMWGraph g = new AdjMWGraph(maxVertices);
		Character[] a = {new Character('A'),new Character('B'),new Character('C'),new Character('D'),
		new Character('E'),new Character('F')};
		RowColWeight[] rcw = {new RowColWeight(0,2,5),new RowColWeight(0,3,30),new RowColWeight(1,0,2),
		new RowColWeight(1,4,8),new RowColWeight(2,1,15),new RowColWeight(2,5,7),new RowColWeight(4,3,4),
		new RowColWeight(5,3,10),new RowColWeight(5,4,18)};
		int n = 6, e = 9;

		try{
			createGraph(g,a,n,rcw,e);

			int[] distance = new int[n];
			int[] path = new int[n];

			Dijkstra.dijkstra(g, 0, distance, path);

			System.out.println("�Ӷ���A���������������̾���Ϊ��");
			for(int i = 1; i < n; i ++)
				System.out.println("������" + g.getValue(i) + "����̾���Ϊ��" + distance[i]);

			System.out.println("�Ӷ���A�������������ǰһ����ֱ�Ϊ��");
			for(int i = 0; i < n; i ++)
				if(path[i] != -1)
					System.out.println("������" + g.getValue(i) + "��ǰһ����Ϊ��" + g.getValue(path[i]));
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
