package chap7;

public class BiTree{
	private BiTreeNode root;
	
	private void preOrder(BiTreeNode t, Visit vs){
		if(t != null){
			vs.print(t.data);
			preOrder(t.getLeft(),vs);
			preOrder(t.getRight(),vs);
		}
	}
	
	private void inOrder(BiTreeNode t, Visit vs){
		if(t != null){
			inOrder(t.getLeft(),vs);
			vs.print(t.data);
			inOrder(t.getRight(),vs);
		}
	}
	
	private void postOrder(BiTreeNode t, Visit vs){
		if(t != null){
			postOrder(t.getLeft(),vs);
			postOrder(t.getRight(),vs);
			vs.print(t.data);
		}
	}
	
	BiTree(){
		root = null;
	}
	
	BiTree(Object item, BiTree left, BiTree right){
		BiTreeNode l, r;
		if(left == null) 
			l = null;
		else
			l = left.root;
		if(right == null) 
			r = null;
		else 
			r = right.root;		
		root = new BiTreeNode(item, l, r);	
	}
	
	public void preOrder(Visit vs){
		preOrder(root, vs);
	}
	
	public void inOrder(Visit vs){
		inOrder(root, vs);
	}
	
	public void postOrder(Visit vs){
		postOrder(root,vs);
	}
}