package chap3.SeqStackLinStack;

public class PostExpression{

	public static void postExp(LinStack s) throws Exception{
		char ch;
		int x1,x2, b=0;

		System.out.println("�����׺���ʽ(���ʽ��#���Ž���)��");
		while((ch = (char)(b = System.in.read())) != '#'){
			if(Character.isDigit(ch)){
				s.push(new Integer(Character.toString(ch)));
			}

			else{
				x2 = ((Integer)s.pop()).intValue();
				x1 = ((Integer)s.pop()).intValue();
				switch(ch){
					case '+':
						x1 += x2;
						break;
					case '-':
						x1 -= x2;
						break;
					case '*':
						x1 *= x2;
						break;
					case '/':
						if(x2 == 0){
							throw new Exception("����Ϊ0��");
						}
						else{
							x1 /= x2;
							break;
						}
				}
				s.push(new Integer(x1));
			}
		}
		System.out.println("��׺���ʽ������Ϊ��"+s.pop());
	}
	public static void main(String[] args) throws Exception{

		LinStack myStack = new LinStack();
		try{
			postExp(myStack);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
