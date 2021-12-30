package chap9;

//��������
public class RadixSort{
public static void radixSort(int[] a, int m, int d) throws Exception{
// aΪҪ���������Ԫ�أ�dΪ���ƵĻ�����mΪ����Ԫ�ص����λ��
	int n = a.length;
	int i, j, k, l, power = 1;
	LinQueue[] myQueue = new LinQueue[d];

	//������ʽ�����������
	for(i = 0; i < d; i++){
		LinQueue temp = new LinQueue();
		myQueue[i] = temp;
	}

	//����m������
	for(i = 0; i < m; i++){
		if(i == 0) power = 1;
		else power = power * d;

		//���ν�n������Ԫ�ذ���kλ�Ĵ�С�ŵ���Ӧ�Ķ�����
		for(j = 0; j < n; j++){
			k = a[j] / power - (a[j] / (power * d)) * d;	//����kֵ
			myQueue[k].append(new Integer(a[j]));			// a[j]�����k
		}

		//˳����ո������е�����Ԫ�ص�����a��
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
