
package chap7.Hw.tool;

public class Node{

	public Object data;
	public Node left;
	public Node right;
	Node next;

	public Node(Object obj, Node nextval){
		data = obj;
		next = nextval;
	}

	Node(Node nextval){
		next = nextval;
	}

	public Node getNext(){
		return next;
	}

	public void setNext(Node nextval){
		next = nextval;
	}

	public Object getElement(){
		return data;
	}

	public void setElement(Object obj){
		data = obj;
	}
	public String toString(){
		return data.toString();
	}
}
