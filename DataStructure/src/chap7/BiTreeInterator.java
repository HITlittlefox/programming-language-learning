package chap7;
public class BiTreeInterator{
	BiTreeNode root;
	BiTreeNode current;
	int iteComplete;
	
	BiTreeInterator(){
	}
	
	BiTreeInterator(BiTreeNode tree){
		root = tree;
		current = null;
		iteComplete = 1;
	}
	
	public void reset(){
	}
	
	public void next(){
	}
	
	public boolean endOfBiTree(){
		return iteComplete == 1;
	}
	
	public Object getData(){
		if(current == null)
			return null;
		else
			return current.data;	
	}
}