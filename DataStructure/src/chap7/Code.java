package chap7;

public class Code{							//哈夫曼编码类
	public int[] bit; 								//数组
	public int start; 								//编码的起始下标
	public int weight; 							//字符的权值

	public	Code(int n){
		bit = new int[n];
		start = n - 1;
	}
}
