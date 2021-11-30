package chap5;

//三元组顺序表
public class SpaMatrix {
	int rows; // 行数
	int cols; // 列数
	int dNum; // 非零元个数
	MyVector v; // 数组

	SpaMatrix(int max) { // 构造函数
		rows = cols = dNum = 0;
		v = new MyVector(max);
	}

	public void evaluate(int r, int c, int d, Three[] item) throws Exception {
		// 给矩阵赋值
		rows = r;
		cols = c;
		dNum = d;

		for (int i = 0; i < d; i++) {
			v.add(i, item[i]);
		}
	}

	public SpaMatrix transpose() { // 转置
		SpaMatrix a = new SpaMatrix(v.size()); // 创建矩阵对象

		a.cols = rows; // 行数转为列数
		a.rows = cols; // 列数转为行数
		a.dNum = dNum; // 非零元个数不变

		for (int i = 0; i < dNum; i++) {
			Three t = (Three) v.get(i); //
			a.v.add(i, new Three(t.col, t.row, t.value));// 在数组中添加对象
		}
		return a; // 返回矩阵对象
	}

	public void print() { // 输出
		System.out.print("矩阵行数为：" + rows);
		System.out.print(" 矩阵列数为：" + cols);
		System.out.println("，非零元个数为：" + dNum);

		System.out.println("矩阵非零元三元组为：");
		for (int i = 0; i < dNum; i++) {
			System.out.println(
					"a<" + ((Three) v.get(i)).row + "," + ((Three) v.get(i)).col + ">=" + ((Three) v.get(i)).value);
		}
	}
}
