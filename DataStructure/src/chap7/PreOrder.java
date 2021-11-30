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
		LinStack s = new LinStack();				//创建链式堆栈类对象
		if(root == null) return;
		BiTreeNode curr;
		s.push(root);								//根结点入栈
		while(! s.isEmpty()){						//当堆栈不空时循环
			curr = (BiTreeNode)s.pop();				//出栈得到栈顶结点
			System.out.print("  " + curr.data);		//输出结点的数据元素值
			if(curr.getRight() != null)				//若右孩子结点非空
				s.push(curr.getRight());			//右孩子结点入栈
			if(curr.getLeft() != null) 				//若左孩子结点非空
				s.push(curr.getLeft());				//左孩子结点入栈
		}
	}
	
	public static void main(String[] args){
		BiTreeNode root;
		root = makeTree();
		System.out.print("前序遍历序列为：");
		try{
			preOrderNoRecur(root);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println();
	}
}