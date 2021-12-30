package chap7;

public class BiTreeNode {
	private BiTreeNode leftChild;
	private BiTreeNode rightChild;
	public Object data;

	BiTreeNode() {
		leftChild = null;
		rightChild = null;
	}

	public BiTreeNode(Object item, BiTreeNode left, BiTreeNode right) {
		data = item;
		leftChild = left;
		rightChild = right;
	}

	public BiTreeNode getLeft() {
		return leftChild;
	}

	public BiTreeNode getRight() {
		return rightChild;
	}

	public Object getData() {
		return data;
	}

}
