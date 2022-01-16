package chap8;
public class RowColWeight{
	int row;
	int col;
	int weight;

	public RowColWeight(int r, int c, int w){
		row = r;
		col = c;
		weight = w;
	}

	public static void createGraph(AdjMWGraph g, Object[] v, int n, RowColWeight[] rc, int e) throws Exception{
		for(int i = 0; i < n; i ++)
			g.insertVertex(v[i]);
		for(int k = 0; k < e; k ++)
			g.insertEdge(rc[k].row, rc[k].col, rc[k].weight);
	}
}
