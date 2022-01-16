package chap8;
public class Exam8_1{
	public static void main(String[] args){
		int n = 5, e = 5;

		AdjMWGraph g = new AdjMWGraph(n);
		Character[] a = {new Character('A'),new Character('B'),new Character('C'),new Character('D'),new Character('E')};
		RowColWeight[] rcw = {new RowColWeight(0,1,10),new RowColWeight(0,4,20),new RowColWeight(1,3,30),new RowColWeight(2,1,40),new RowColWeight(3,2,50)};
		try{
			RowColWeight.createGraph(g,a,n,rcw,e);
			System.out.println("结点个数为：" + g.getNumOfVertices());
			System.out.println("边的个数为：" + g.getNumOfEdges());

			g.deleteEdge(0,4);

			System.out.println();
			System.out.println("结点个数为：" + g.getNumOfVertices());
			System.out.println("边的个数为：" + g.getNumOfEdges());

		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
}

