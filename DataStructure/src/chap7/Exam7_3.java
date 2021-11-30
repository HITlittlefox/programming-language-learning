package chap7;
public class Exam7_3{
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
		BiTreeNode root;
		
		root = makeTree();
		BiTrInIterator myIter = new BiTrInIterator(root);
		
		System.out.print("中序遍历序列为：");
		for(myIter.reset(); ! myIter.endOfBiTree(); myIter.next())
			System.out.print(myIter.getData() + "    ");
	}
}