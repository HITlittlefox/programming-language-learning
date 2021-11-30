package chap7;
public class Exec7_20{
	
	public static int leafNum(BiTreeNode t){
		if(t == null) return 0;
		if(t.getLeft() == null && t.getRight() == null) return 1;
		return (leafNum(t.getLeft()) + leafNum(t.getRight()));
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
		Visit vs = new Visit();						//创建Visit类对象vs
		
		root1 = makeTree();
		System.out.println("二叉树为：");
//		printBiTree(root1,0);
		System.out.println();
		
		System.out.print("前序遍历结点序列为：");
		Traverse.preOrder(root1,vs);
		System.out.println();
		
		System.out.print("中序遍历结点序列为：");
		Traverse.inOrder(root1,vs);
		System.out.println();
		
		System.out.print("后序遍历结点序列为：");
		Traverse.postOrder(root1,vs);
		System.out.println();
		
		System.out.print("层序遍历结点序列为：");
		try{
			Traverse.levelOrder(root1,vs);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println();
		
		int count = leafNum(root1);
		System.out.print("count = " + count);
		
	}		
}