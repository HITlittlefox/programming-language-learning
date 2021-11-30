package chap7;
public class Exer7_20{
	public static void printBiTree(BiTreeNode root, int level){
	//二叉树root第level层结点数据元素值的横向输出
		if(root != null){
			//子二叉树root.getRight()第level+1层结点数据元素值的横向输出
			printBiTree(root.getRight(),level + 1);

			if(level != 0){
				//走过6*(level-1)个空格
				for(int i = 0; i < 6 * (level - 1); i ++){
					System.out.print(" ");
				}
				System.out.print("---");		//输出横线
			}
			System.out.println(root.data); 		//输出结点的数据元素值

			//子二叉树root.getLeft()第level+1层结点数据元素值的横向输出
			printBiTree(root.getLeft(),level + 1);
		}
	}
	
	public static BiTreeNode search(BiTreeNode t, Object x){
		BiTreeNode temp;
	
		if(t == null) return null; 					//查找失败出口
		if(t.data.equals(x)) return t; 				//查找成功出口
	
		if(t.getLeft() != null){
			temp = search(t.getLeft(),x); 			//在左子树查找
			if(temp != null) return temp; 			//查找成功则结束递归
		}
	
		if(t.getRight() != null){
			temp = search(t.getRight(),x); 			//在右子树查找
			if(temp != null) return temp; 			//查找成功则结束递归
		}
		
		return null; 								//查找失败出口
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
		Visit vs = new Visit();						//创建Visit类对象vs
		
		root1 = makeTree();
		System.out.println("二叉树为：");
		printBiTree(root1,0);
		System.out.println();
		
		System.out.print("前序遍历结点序列为：");
		Traverse.preOrder(root1,vs);
		System.out.println();
		
		int t = leafNum(root1);
		System.out.println("t = " + t);
	}
}