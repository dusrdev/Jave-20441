package BinaryTrees;

public class BinaryNode<T> {
	private T _data;
	private BinaryNode<T> _leftChild;
	private BinaryNode<T> _rightChild;

	public BinaryNode(T data) {
		this(data, null, null);
	}

	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		_data = data;
		_leftChild = left;
		_rightChild = right;
	}

	public T getData() {
		return _data;
	}

	public void setData(T data) {
		_data = data;
	}

	public BinaryNode<T> getLeftChild() {
		return _leftChild;
	}

	public void setLeftChild(BinaryNode<T> node) {
		_leftChild = node;
	}

	public BinaryNode<T> getRightChild() {
		return _rightChild;
	}

	public void setRightChild(BinaryNode<T> node) {
		_rightChild = node;
	}
}