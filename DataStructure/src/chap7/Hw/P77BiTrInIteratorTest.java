package chap7.Hw;


import chap7.Hw.tool.BiTrInIterator;
import chap7.Hw.tool.BiTreeInterator;
import chap7.Hw.tool.BiTreeNode;


public class P77BiTrInIteratorTest {
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

		System.out.print("�����������Ϊ��");
		for(myIter.reset(); ! myIter.endOfBiTree(); myIter.next())
			System.out.print(myIter.getData() + "    ");
	}
}
