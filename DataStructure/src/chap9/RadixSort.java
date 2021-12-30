package chap9;

//基数排序
public class RadixSort{
public static void radixSort(int[] a, int m, int d) throws Exception{
// a为要排序的数据元素，d为进制的基数，m为数据元素的最大位数
	int n = a.length;
	int i, j, k, l, power = 1;
	LinQueue[] myQueue = new LinQueue[d];

	//创建链式队列数组对象
	for(i = 0; i < d; i++){
		LinQueue temp = new LinQueue();
		myQueue[i] = temp;
	}

	//进行m次排序
	for(i = 0; i < m; i++){
		if(i == 0) power = 1;
		else power = power * d;

		//依次将n个数据元素按第k位的大小放到相应的队列中
		for(j = 0; j < n; j++){
			k = a[j] / power - (a[j] / (power * d)) * d;	//计算k值
			myQueue[k].append(new Integer(a[j]));			// a[j]入队列k
		}

		//顺序回收各队列中的数据元素到数组a中
		l = 0;
		for(j = 0; j < d; j++){
			while(myQueue[j].notEmpty()){
				a[l] = ((Integer)myQueue[j].delete()).intValue();
				l++;
			}
		}
	}
}


	public static void main(String[] args){
		int[] test = {710,342,045,686,6,841,429,134,68,264};
		int n = test.length;
		int m = 3, d = 10;

		try{
			radixSort(test, m, d);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		for(int i = 0; i < n; i++)
			System.out.print(test[i] + "  ");
	}
}
