package chap7;
public class Exer7_20{
	public static void printBiTree(BiTreeNode root, int level){
	//������root��level��������Ԫ��ֵ�ĺ������
		if(root != null){
			//�Ӷ�����root.getRight()��level+1��������Ԫ��ֵ�ĺ������
			printBiTree(root.getRight(),level + 1);

			if(level != 0){
				//�߹�6*(level-1)���ո�
				for(int i = 0; i < 6 * (level - 1); i ++){
					System.out.print(" ");
				}
				System.out.print("---");		//�������
			}
			System.out.println(root.data); 		//�����������Ԫ��ֵ

			//�Ӷ�����root.getLeft()��level+1��������Ԫ��ֵ�ĺ������
			printBiTree(root.getLeft(),level + 1);
		}
	}
	
	public static BiTreeNode search(BiTreeNode t, Object x){
		BiTreeNode temp;
	
		if(t == null) return null; 					//����ʧ�ܳ���
		if(t.data.equals(x)) return t; 				//���ҳɹ�����
	
		if(t.getLeft() != null){
			temp = search(t.getLeft(),x); 			//������������
			if(temp != null) return temp; 			//���ҳɹ�������ݹ�
		}
	
		if(t.getRight() != null){
			temp = search(t.getRight(),x); 			//������������
			if(temp != null) return temp; 			//���ҳɹ�������ݹ�
		}
		
		return null; 								//����ʧ�ܳ���
	}

	
	public static BiTreeNode getTreeNode(Object item, BiTreeNode left, BiTreeNode right){
		BiTreeNode temp = new BiTreeNode(item,left,right);
		return temp;
	}

	public static BiTreeNode makeTree(){
		BiTreeNode b, c, d, e, f, g;
		
		g = getTreeNode(new Character('G'), null, null);
		d = getTreeNode(new Character('D'), null, g);
		b = getTreeNode(new Character('B'), d, null);
		e = getTreeNode(new Character('E'), null, null);
		f = getTreeNode(new Character('F'), null, null);
		c = getTreeNode(new Character('C'), e, f);
		return getTreeNode(new Character('A'), b, c);
	}
	
public static int leafNum(BiTreeNode t){
	if(t == null) return 0;
	if(t.getLeft() == null && t.getRight() == null) return 1;
	return (leafNum(t.getLeft()) + leafNum(t.getRight()));
}
	
	public static void main(String[] args){
		BiTreeNode root1;
		BiTreeNode temp;
		Visit vs = new Visit();						//����Visit�����vs
		
		root1 = makeTree();
		System.out.println("������Ϊ��");
		printBiTree(root1,0);
		System.out.println();
		
		System.out.print("ǰ������������Ϊ��");
		Traverse.preOrder(root1,vs);
		System.out.println();
		
		int t = leafNum(root1);
		System.out.println("t = " + t);
	}
}