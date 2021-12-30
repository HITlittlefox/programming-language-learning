package chap7;
public class BiTreeInterator{
	public BiTreeNode root;
	public BiTreeNode current;
	public int iteComplete;

	BiTreeInterator(){
	}

	public BiTreeInterator(BiTreeNode tree){
		root = tree;
		current = null;
		iteComplete = 1;
	}

	public void reset(){
	}

	public BiTreeNode getRoot() {
		return root;
	}

	public void setRoot(BiTreeNode root) {
		this.root = root;
	}

	public BiTreeNode getCurrent() {
		return current;
	}

	public void setCurrent(BiTreeNode current) {
		this.current = current;
	}

	public int getIteComplete() {
		return iteComplete;
	}

	public void setIteComplete(int iteComplete) {
		this.iteComplete = iteComplete;
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
