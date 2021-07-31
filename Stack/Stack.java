package Stack;

public class Stack<T> {
	private Node<T> _head;

	public Stack() {
		_head = null;
	}

	public boolean empty() {
		return _head == null;
	}

	public void push(T data) {
		Node<T> node = new Node<T>(data, _head);
		_head = node;
	}

	public T pop() {
		if (empty()) {
			return null;
		}
		else {
			Node<T> node = _head;
			_head = _head.getNext();
			return node.getData();
		}
	}
}
