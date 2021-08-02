package LinkedLists;

public class List<T> {
	private Node<T> _head;

	public List() {
		_head = null;
	}

	public List(T data) {
		_head = new Node<T>(data);
	}

	public List(T[] arr) {
		if (arr.length == 0) {
			return;
		}
		_head = new Node<T>(arr[0]);
		Node<T> node = _head;
		for (int i = 1; i < arr.length; i++) {
			node.setNext(new Node<T>(arr[i]));
			node = node.getNext();
		}
	}

	public Node<T> getHead() {
		return _head;
	}

	public void setHead(Node<T > node) {
		_head = node;
	}

	public String toString() {
		String str = "";
		Node<T> node = _head;
		while (node != null) {
			str += node.getData() + " -> ";
			node = node.getNext();
		}
		str += "null";
		return str;
	}
}
