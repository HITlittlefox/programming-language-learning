package chap3.queue;
public class Exam3_3{
	public static void huiWen(String str) throws Exception{
		int n = str.length();
		SeqStack myStack = new SeqStack(n);
		SeqQueue myQueue = new SeqQueue(n);
//		LinQueue myQueue = new LinQueue(n);		
		for(int i = 0; i < n; i ++){
			myQueue.append(str.substring(i,i+1));
			myStack.push(str.substring(i,i+1));
		}
		
		while(myQueue.notEmpty() && myStack.notEmpty()){
			if(!myQueue.delete().equals(myStack.pop())){
				System.out.println(str+"不是回文！");
				return;
			}	
		}
		System.out.println(str+"是回文！");
	}
	
	public static void main(String[] args){
		String str1 = "ABCDEDCBA";
		String str2 = "ABCDEDBAC";
		try{
			huiWen(str1);
			huiWen(str2);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}