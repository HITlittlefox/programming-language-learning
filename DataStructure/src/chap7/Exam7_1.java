package chap7;
public class Exam7_1{
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
		
		System.out.print("��������������Ϊ��");
		Traverse.inOrder(root1,vs);
		System.out.println();
		
		System.out.print("��������������Ϊ��");
		Traverse.postOrder(root1,vs);
		System.out.println();
		
		System.out.print("��������������Ϊ��");
		try{
			Traverse.levelOrder(root1,vs);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println();
		
		temp = search(root1,new Character('C'));
		if(temp != null)
			System.out.println("���ҵ��Ľ������ֵΪ��" + temp.data);
		else
			System.out.println("����ʧ��");
	}
}