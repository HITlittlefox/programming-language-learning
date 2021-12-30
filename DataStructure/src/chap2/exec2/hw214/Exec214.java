package chap2.exec2.hw214;

public class Exec214{
	public int listDelete(Node head,int x){
		Node pre = head;
		Node curr,q;
		int position = -1;
		curr = head.next;
		while(curr != null){
			position ++;
			if(curr.data == x){
				q = curr;
				curr = q.next;
				pre.next = curr;

				return position;
			}
			else{
				pre = curr;
				curr = curr.next;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		Exec214 ex = new Exec214();
		Node head = new Node();
		Node p = head;
		for(int i = 0; i < 10; i++){
			int m = (int)(Math.random() * 100);
			Node node = new Node();
			node.data = m % 10;
			System.out.println(m % 10);
			p.next = node;
			p = p.next;
		}


		int position = ex.listDelete(head,5);
		System.out.println("element 5 deleted position is:" + position);
	}
}

class Node{
	public int data;
	public Node next;
}
