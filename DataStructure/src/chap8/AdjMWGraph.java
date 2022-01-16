package chap8;
public class AdjMWGraph{
	static final int maxWeight = 10000;

	private SeqList vertices; 					//�洢����˳���
	int[][] edge;						//�洢�ߵĶ�ά����
	private int numOfEdges;						//�ߵĸ���

	public AdjMWGraph(int maxV){			//���캯����maxVΪ������
		vertices = new SeqList(maxV);
		edge = new int[maxV][maxV];
		for(int i = 0; i < maxV; i ++){
			for(int j = 0; j < maxV; j ++){
				if(i == j)
					edge[i][j] = 0;
				else
					edge[i][j] = maxWeight;
			}
		}
		numOfEdges = 0;
	}

	public int getNumOfVertices(){						//���ؽ�����
		return vertices.size;
	}

	public int getNumOfEdges(){							//���رߵĸ���
		return numOfEdges;
	}

	public Object getValue(int v) throws Exception{
//���ؽ��v������Ԫ��
		return vertices.getData(v);
	}

	public int getWeight(int v1, int v2) throws Exception{
//���ر�<v1,v2>��Ȩֵ
		if(v1 < 0 || v1 >= vertices.size || v2 < 0 || v2 >= vertices.size)
			throw new Exception("����v1��v2Խ�����");
		return edge[v1][v2];
	}

	public void insertVertex(Object vertex) throws Exception{
//������
		vertices.insert(vertices.size, vertex);
	}

	public void insertEdge(int v1, int v2, int weight) throws Exception{
	//�����<v1,v2>��ȨֵΪweight
		if(v1 < 0 || v1 >= vertices.size || v2 < 0 || v2 >= vertices.size)
			throw new Exception("����v1��v2Խ�����");
		edge[v1][v2] = weight; 							//�ñߵ�Ȩֵ
		numOfEdges ++;									//�ߵĸ�����1
	}

	public void deleteEdge(int v1, int v2) throws Exception{
	//ɾ����<v1,v2>
		if(v1 < 0 || v1 > vertices.size || v2 < 0 || v2 > vertices.size)
			throw new Exception("����v1��v2Խ�����");
		if(edge[v1][v2] == maxWeight || v1 == v2)
			throw new Exception("�ñ߲����ڣ�");

		edge[v1][v2] = maxWeight;				//�ñߵ�ȨֵΪ�����
		numOfEdges --;									//�ߵĸ�����1
	}

	public int getFirstNeighbor(int v) throws Exception{
//ȡ���v�ĵ�һ���ڽӽ�㡣�����ڷ��ظý����±���ţ����򷵻�-1
		if(v < 0 || v >= vertices.size)
			throw new Exception("����vԽ�����");
		for(int col = 0; col < vertices.size; col ++)
			if(edge[v][col] > 0 && edge[v][col] < maxWeight)
				return col;
		return - 1;
	}

	public int getNextNeighbor(int v1, int v2) throws Exception{
//ȡ���v1���ڽӽ��v2����ڽӽ��
//�����ڷ��ظý����±���ţ����򷵻�-1
		if(v1 < 0 || v1 >= vertices.size || v2 < 0 || v2 >= vertices.size)
			throw new Exception("����v1��v2Խ�����");
		for(int col = v2 + 1; col < vertices.size; col ++)
			if(edge[v1][col] > 0 && edge[v1][col] < maxWeight)
				return col;
		return - 1;
	}

	private void depthFirstSearch(int v, boolean[] visited, Visit vs) throws Exception{
//��ͨͼ��vΪ��ʼ�����š����ʲ���Ϊvs��������ȱ���
//����visited�������Ӧ����Ƿ��ѷ��ʹ���0��ʾδ���ʣ�1��ʾ�ѷ���
		vs.print(getValue(v)); 						//���ʸý��
		visited[v] = true; 							//���ѷ��ʱ��

		int w = getFirstNeighbor(v); 				//ȡ��һ���ڽӽ��
		while(w != -1){ 						//���ڽӽ�����ʱѭ��
			if(! visited[w])						//���û�з��ʹ�
				depthFirstSearch(w, visited, vs); //��wΪ��ʼ���ݹ����
			w = getNextNeighbor(v, w);				//ȡ��һ���ڽӽ��
		}
	}

	private void broadFirstSearch(int v, boolean[] visited, Visit vs) throws Exception{
//��ͨͼ��vΪ��ʼ�����š����ʲ���Ϊvs�Ĺ�����ȱ���
//����visited�������Ӧ����Ƿ��ѷ��ʹ���0��ʾδ���ʣ�1��ʾ�ѷ���
		int u, w;
		SeqQueue queue = new SeqQueue();			//����˳�����queue

		vs.print(getValue(v));						//���ʽ��v
		visited[v] = true; 							//���ѷ��ʱ��

		queue.append(new Integer(v)); 				//���v�����
		while(! queue.isEmpty()){					//���зǿ�ʱѭ��
			u = ((Integer)queue.delete()).intValue();	//������
			w = getFirstNeighbor(u); 		//ȡ���u�ĵ�һ���ڽӽ��
			while(w != - 1){ 					//���ڽӽ�����ʱѭ��
				if(! visited[w]){ 				//���ý��û�з��ʹ�
					vs.print(getValue(w)); 			//���ʽ��w
					visited[w] = true; 				//���ѷ��ʱ��
					queue.append(new Integer(w)); 		//���w�����
				}

				//ȡ���u���ڽӽ��w����һ���ڽӽ��
				w = getNextNeighbor(u, w);
			}
		}
	}

	public void depthFirstSearch(Visit vs) throws Exception{
	//����ͨͼ��������ȱ���
		boolean[] visited = new boolean[getNumOfVertices()];

		for(int i = 0; i < getNumOfVertices(); i ++)
			visited[i] = false; 				//�����н���δ���ʹ�

		for(int i = 0; i < getNumOfVertices(); i ++)//��ÿ�����ѭ��
			if(! visited[i]) 						//����ý��δ����
				depthFirstSearch(i, visited, vs);//�Խ��iΪ��ʼ���������ȱ���
	}

	public void broadFirstSearch(Visit vs) throws Exception{
	//����ͨͼ�Ĺ�����ȱ���
		boolean[] visited = new boolean[getNumOfVertices()];

		for(int i = 0; i < getNumOfVertices(); i ++)
			visited[i] = false;					//�����н���δ���ʹ�

		for(int i = 0; i < getNumOfVertices(); i ++)//��ÿ�����ѭ��
			if(! visited[i])						//����ý��δ���ʹ�
				broadFirstSearch(i, visited, vs);//�Խ��iΪ��ʼ��������ȱ���
	}
}
