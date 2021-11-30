package chap7;

public class Traverse {
	public static void preOrder(BiTreeNode t, Visit vs) {
		// 前序遍历二叉树t，访问结点操作为vs.print(t.data)
		if (t != null) {
			vs.print(t.data);
			preOrder(t.getLeft(), vs);
			preOrder(t.getRight(), vs);
		}
	}

	public static void inOrder(BiTreeNode t, Visit vs) {
		// 中序遍历二叉树t，访问结点操作为vs.print(t.data)
		if (t != null) {
			inOrder(t.getLeft(), vs);
			vs.print(t.data);
			inOrder(t.getRight(), vs);
		}
	}

	public static void postOrder(BiTreeNode t, Visit vs) {
		// 后序遍历二叉树t，访问结点操作为vs.print(t.data)
		if (t != null) {
			postOrder(t.getLeft(), vs);
			postOrder(t.getRight(), vs);
			vs.print(t.data);
		}
	}

	public static void levelOrder(BiTreeNode t, Visit vs) throws Exception {
		// 层序遍历二叉树t，访问结点操作为vs.print(t.data)
		LinQueue q = new LinQueue();
		if (t == null)
			return;
		BiTreeNode curr;
		q.append(t);
		while (!q.isEmpty()) {
			curr = (BiTreeNode) q.delete();
			vs.print(curr.data);
			if (curr.getLeft() != null)
				// 如果左孩子不为空，就把左孩子入队
				q.append(curr.getLeft());
			if (curr.getRight() != null)
				q.append(curr.getRight());
		}
	}
}
