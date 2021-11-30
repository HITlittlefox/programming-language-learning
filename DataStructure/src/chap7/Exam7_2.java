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
		System.out.print("ǰ������������Ϊ��");
		a.preOrder(vs);
		System.out.println();
		
		System.out.print("��������������Ϊ��");
		a.inOrder(vs);
		System.out.println();
		
		System.out.print("��������������Ϊ��");
		a.postOrder(vs);
		System.out.println();
	}
}