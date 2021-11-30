package chap5;

//������
public class Matrix {
	private MyVector values; // ��Ա����������Ԫ��
	private int h; // ��Ա��������������
	private int w; // ��Ա��������������

	public Matrix(int h, int w) { // ���캯����hΪ������wΪ����
		if (!(h > 0 && w > 0))
			throw new ArrayIndexOutOfBoundsException("h or w  < " + 1);
		// ʹ��������洢����
		values = new MyVector(h); // ������h�еĶ���
		for (int i = 0; i < h; i++) {
			MyVector row = new MyVector(w); // ������w�еĶ���
			values.add(row); // ����Ԫ�����õ���row
			for (int j = 0; j < w; j++) {
				row.add(null); // ��ʼ������Ԫ��Ϊnull
			}
		}
		this.h = h;
		this.w = w;
	}

	public void set(int row, int col, Object value) { // ��Ԫ��
		if (!(row >= 0 && w >= 0 && row < h && col < w))
			throw new ArrayIndexOutOfBoundsException("h or w  < " + "-1");
		// ���
		MyVector selrow = (MyVector) values.get(row);
		selrow.set(col, value);
	}

	public Object get(int row, int col) { // ȡԪ��
		if (!(row >= 0 && w >= 0 && row < h && col < w))
			throw new ArrayIndexOutOfBoundsException("h or w  < " + "-1");
		MyVector selrow = (MyVector) values.get(row);
		return selrow.get(col);
	}

	public int width() { // ��������
		return w;
	}

	public int height() { // ��������
		return h;
	}

	public Matrix add(Matrix b) { // �����
		if (height() != b.height() || width() != b.width()) {
			throw new ArrayIndexOutOfBoundsException("Matrix h and w error");
		}

		Matrix result = new Matrix(height(), width());

		for (int i = 0; i < height(); i++) {
			for (int j = 0; j < width(); j++) {
				Integer i1 = (Integer) get(i, j);
				Integer i2 = (Integer) (b.get(i, j));
				result.set(i, j, new Integer(i1.intValue() + i2.intValue()));
			}
		}
		return result;
	}

	public void print() { // �������Ԫ��
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(get(i, j) + " ");// (get(i,j)����Object������Ҫ����toString()��������
			}
			System.out.println();
		}
	}
}
