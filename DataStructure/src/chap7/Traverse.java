package chap7;

public class Traverse {
	public static void preOrder(BiTreeNode t, Visit vs) {
		// ǰ�����������t�����ʽ�����Ϊvs.print(t.data)
		if (t != null) {
			vs.print(t.data);
			preOrder(t.getLeft(), vs);
			preOrder(t.getRight(), vs);
		}
	}

	public static void inOrder(BiTreeNode t, Visit vs) {
		// �������������t�����ʽ�����Ϊvs.print(t.data)
		if (t != null) {
			inOrder(t.getLeft(), vs);
			vs.print(t.data);
			inOrder(t.getRight(), vs);
		}
	}

	public static void postOrder(BiTreeNode t, Visit vs) {
		// �������������t�����ʽ�����Ϊvs.print(t.data)
		if (t != null) {
			postOrder(t.getLeft(), vs);
			postOrder(t.getRight(), vs);
			vs.print(t.data);
		}
	}

	public static void levelOrder(BiTreeNode t, Visit vs) throws Exception {
		// �������������t�����ʽ�����Ϊvs.print(t.data)
		LinQueue q = new LinQueue();
		if (t == null)
			return;
		BiTreeNode curr;
		q.append(t);
		while (!q.isEmpty()) {
			curr = (BiTreeNode) q.delete();
			vs.print(curr.data);
			if (curr.getLeft() != null)
				// ������Ӳ�Ϊ�գ��Ͱ��������
				q.append(curr.getLeft());
			if (curr.getRight() != null)
				q.append(curr.getRight());
		}
	}
}
