package chap5;

//矩阵类
public class Matrix {
	private MyVector values; // 成员变量，矩阵元素
	private int h; // 成员变量，矩阵行数
	private int w; // 成员变量，矩阵列数

	public Matrix(int h, int w) { // 构造函数，h为行数，w为列数
		if (!(h > 0 && w > 0))
			throw new ArrayIndexOutOfBoundsException("h or w  < " + 1);
		// 使用向量类存储数据
		values = new MyVector(h); // 创建有h行的对象
		for (int i = 0; i < h; i++) {
			MyVector row = new MyVector(w); // 创建有w列的对象
			values.add(row); // 让行元素引用等于row
			for (int j = 0; j < w; j++) {
				row.add(null); // 初始化矩阵元素为null
			}
		}
		this.h = h;
		this.w = w;
	}

	public void set(int row, int col, Object value) { // 置元素
		if (!(row >= 0 && w >= 0 && row < h && col < w))
			throw new ArrayIndexOutOfBoundsException("h or w  < " + "-1");
		// 获得
		MyVector selrow = (MyVector) values.get(row);
		selrow.set(col, value);
	}

	public Object get(int row, int col) { // 取元素
		if (!(row >= 0 && w >= 0 && row < h && col < w))
			throw new ArrayIndexOutOfBoundsException("h or w  < " + "-1");
		MyVector selrow = (MyVector) values.get(row);
		return selrow.get(col);
	}

	public int width() { // 矩阵列数
		return w;
	}

	public int height() { // 矩阵行数
		return h;
	}

	public Matrix add(Matrix b) { // 矩阵加
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

	public void print() { // 输出矩阵元素
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(get(i, j) + " ");// (get(i,j)返回Object，不需要调用toString()函数？？
			}
			System.out.println();
		}
	}
}
