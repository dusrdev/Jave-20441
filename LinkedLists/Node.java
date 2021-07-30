package LinkedLists;

public class Node<T> {
	private T _data;
	private Node<T> _next;

	public Node(T data, Node<T> next) {
		_data = data;
		_next = next;
	}

	public T getData() {
		return _data;
	}

	public void setData(T data) {
		_data = data;
	}

	public Node<T> getNext() {
		return _next;
	}

	public void setNext(Node<T> next) {
		_next = next;
	}
}
