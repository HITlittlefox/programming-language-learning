package chap5;

// ������
public class MySet {
	private MyVector values = new MyVector(); // ��Ա����

	public void add(Object obj) { // ���
		// ��֤����Ԫ�ز��ظ�
		if (obj == null)
			return;
		if (values.indexOf(obj) < 0)
			values.add(obj); // ����MyVector����������ӳ�Ա����
	}

	public void remove(Object obj) { // ɾ��
		values.remove(obj); // ����MyVector���ɾ������Ԫ�س�Ա����
	}

	public boolean contain(Object obj) { // ����
		return values.contain(obj); // ����MyVector��İ�����Ա����
	}

	public boolean include(Object obj) { // ����
		if (obj instanceof MySet) { // �ж�obj�Ƿ���MySet��ʵ��
			MySet set = (MySet) obj;

			MyIterator it = set.iterator(); // ����������it
			while (it.hasNext()) { // ѭ��
				Object temp = it.next(); // ��������һ��
				if (!contain(temp)) // �ж��Ƿ�����
					return false; // �������򷵻�false
			}
			return true; // ����Ԫ�ؾ������򷵻�true
		} else
			return false;
	}

	public boolean eqauls(Object obj) { // ���
		if (obj instanceof MySet) {
			MySet set = (MySet) obj;
			if (include(set) && set.include(this)) // �ж��Ƿ������
				return true; // ��������򷵻�true
			else
				return false; // ���򷵻�false
		} else
			return false;
	}

	public int size() { // Ԫ�ظ���
		return values.size();
	}

	public boolean isEmpty() { // ���Ͽշ�
		return values.size() > 0;
	}

	public MyIterator iterator() { // �ڲ��࣬����ʵ�ּ��ϵı���
		return new MyIterator() {
			int counter = 0; // �ڲ����Ա��������ʼֵΪ0

			public Object next() { // �ڲ���ı�������һ����Ա����
				Object temp = values.get(counter);
				counter++;
				return temp;
			}

			public boolean hasNext() { // �ڲ�����ж��Ƿ񻹴�����һ��Ԫ�س�Ա����
				return counter < values.size();
			}
		};
	}
}
