package chap7;
public class PreOrder{
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
	
	public static void preOrderNoRecur(BiTreeNode root) throws Exception{
		LinStack s = new LinStack();				//������ʽ��ջ�����
		if(root == null) return;
		BiTreeNode curr;
		s.push(root);								//�������ջ
		while(! s.isEmpty()){						//����ջ����ʱѭ��
			curr = (BiTreeNode)s.pop();				//��ջ�õ�ջ�����
			System.out.print("  " + curr.data);		//�����������Ԫ��ֵ
			if(curr.getRight() != null)				//���Һ��ӽ��ǿ�
				s.push(curr.getRight());			//�Һ��ӽ����ջ
			if(curr.getLeft() != null) 				//�����ӽ��ǿ�
				s.push(curr.getLeft());				//���ӽ����ջ
		}
	}
	
	public static void main(String[] args){
		BiTreeNode root;
		root = makeTree();
		System.out.print("ǰ���������Ϊ��");
		try{
			preOrderNoRecur(root);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println();
	}
}