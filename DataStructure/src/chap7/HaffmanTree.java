package chap7;
public class HaffmanTree{
	static final int maxValue = 10000;	//���Ȩֵ
	private int nodeNum;				//Ҷ������
	
	public HaffmanTree(int n){
		nodeNum = n;
	}
	
	public void haffman(int[] weight, HaffNode[] node){
	//����ȨֵΪweight�Ĺ�������haffTree
		int m1, m2, x1, x2;
		int n = nodeNum;

		//��������haffTree��ʼ����n��Ҷ���Ĺ�����������2n-1�����
		for(int i = 0; i < 2 * n - 1; i ++){
			HaffNode temp = new HaffNode();
			if(i < n) 
				temp.weight = weight[i];
			else
				temp.weight = 0;
			temp.parent = 0;	
			temp.flag = 0;
			temp.leftChild = -1;
			temp.rightChild = -1;
			node[i] = temp;
		}

		//�����������haffTree��n-1����Ҷ���
		for(int i = 0; i < n - 1; i++){
			m1 = m2 = maxValue;
			x1 = x2 = 0;
			for(int j = 0; j < n + i; j ++){
				if(node[j].weight < m1 && node[j].flag == 0){
					m2 = m1;
					x2 = x1;
					m1 = node[j].weight;
					x1 = j;
				}
				else if(node[j].weight < m2 && node[j].flag == 0){
					m2 = node[j].weight;
					x2 = j;
				}
			}

			//���ҳ�������Ȩֵ��С�������ϲ�Ϊһ������
			node[x1].parent  = n+i;   
			node[x2].parent  = n+i;
			node[x1].flag    = 1;
			node[x2].flag    = 1;
			node[n+i].weight = node[x1].weight+node[x2].weight;
			node[n+i].leftChild = x1;
			node[n+i].rightChild = x2;
		}
	}
	
	public void haffmanCode(HaffNode[] node, Code[] haffCode){
	//�ɹ�������haffTree�������������haffCode
		int n = nodeNum;
		Code cd = new Code(n);
		int child, parent;

		//��n��Ҷ���Ĺ���������
		for(int i = 0; i < n; i ++){
			cd.start = n - 1; 				//���ȳ���������һλΪn-1
			cd.weight = node[i].weight; 	//ȡ�ñ����Ӧ��Ȩֵ
			child = i;
			parent = node[child].parent;

			while(parent != 0){
			//��Ҷ�������ֱ�������ѭ��
				if(node[parent].leftChild == child)
					cd.bit[cd.start] = 0; 			//���ӽ�����0
				else
					cd.bit[cd.start] = 1; 			//�Һ��ӽ�����1
				cd.start --;
				child = parent;
				parent = node[child].parent;		
			}
			
			Code temp = new Code(n);

			//����Ҷ���ı���Ͳ��ȳ��������ʼλ
			for(int j = cd.start+1; j < n; j++) 
				temp.bit[j] = cd.bit[j];
			temp.start  = cd.start;
			temp.weight = cd.weight;
			haffCode[i] = temp;
		}
	}
}