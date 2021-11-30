package chap3.SeqPQueue;
public class Exam3_4{
	public static void main(String[] args) throws Exception{
		SeqPQueue myQueue = new SeqPQueue();
		Element temp;
		
		myQueue.append(new Element(new Integer(1),30));
	 	myQueue.append(new Element(new Integer(2),20));
	 	myQueue.append(new Element(new Integer(3),40));
	 	myQueue.append(new Element(new Integer(4),20));
	 	myQueue.append(new Element(new Integer(5),0));
	 	
		System.out.println("进程号  优先级");
		while(myQueue.notEmpty()){
			temp = myQueue.delete();
			System.out.print(temp.getElem()+"       ");
			System.out.println(temp.getPriority());
		}
	}
}

