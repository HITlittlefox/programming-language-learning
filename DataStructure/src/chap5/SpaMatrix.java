package chap5;

//��Ԫ��˳���
public class SpaMatrix {
	int rows; // ����
	int cols; // ����
	int dNum; // ����Ԫ����
	MyVector v; // ����

	SpaMatrix(int max) { // ���캯��
		rows = cols = dNum = 0;
		v = new MyVector(max);
	}

	public void evaluate(int r, int c, int d, Three[] item) throws Exception {
		// ������ֵ
		rows = r;
		cols = c;
		dNum = d;

		for (int i = 0; i < d; i++) {
			v.add(i, item[i]);
		}
	}

	public SpaMatrix transpose() { // ת��
		SpaMatrix a = new SpaMatrix(v.size()); // �����������

		a.cols = rows; // ����תΪ����
		a.rows = cols; // ����תΪ����
		a.dNum = dNum; // ����Ԫ��������

		for (int i = 0; i < dNum; i++) {
			Three t = (Three) v.get(i); //
			a.v.add(i, new Three(t.col, t.row, t.value));// ����������Ӷ���
		}
		return a; // ���ؾ������
	}

	public void print() { // ���
		System.out.print("��������Ϊ��" + rows);
		System.out.print(" ��������Ϊ��" + cols);
		System.out.println("������Ԫ����Ϊ��" + dNum);

		System.out.println("�������Ԫ��Ԫ��Ϊ��");
		for (int i = 0; i < dNum; i++) {
			System.out.println(
					"a<" + ((Three) v.get(i)).row + "," + ((Three) v.get(i)).col + ">=" + ((Three) v.get(i)).value);
		}
	}
}
