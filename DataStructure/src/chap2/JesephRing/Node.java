package chap2.JesephRing;

public class Node{
	int code;
	Node next;
	
	public Node(int codeVal){
		code = codeVal;
		next = null;
	}
	
	public Node(int codeVal, Node nextVal){
		code = codeVal;
		next = nextVal;
	}
	
	public Node(Node nextVal){
		next = nextVal;
	}
	
	public boolean equlas(Node node){
		if(code == node.code){
			return true;
		}
		else{
			return false;
		}
	}
}