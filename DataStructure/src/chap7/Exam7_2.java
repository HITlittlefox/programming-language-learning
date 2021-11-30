package chap7;
public class Exam7_2{
	public static void main(String[] args){
		BiTree g = new BiTree(new Character('G'), null, null);
		BiTree d = new BiTree(new Character('D'), null, g);
		BiTree b = new BiTree(new Character('B'), d, null);
		BiTree e = new BiTree(new Character('E'), null, null);
		BiTree f = new BiTree(new Character('F'), null, null);
		BiTree c = new BiTree(new Character('C'), e, f);
		BiTree a = new BiTree(new Character('A'), b, c);
		
		Visit vs = new Visit();
		System.out.print("前序遍历结点序列为：");
		a.preOrder(vs);
		System.out.println();
		
		System.out.print("中序遍历结点序列为：");
		a.inOrder(vs);
		System.out.println();
		
		System.out.print("后序遍历结点序列为：");
		a.postOrder(vs);
		System.out.println();
	}
}