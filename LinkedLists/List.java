package LinkedLists;

public class List<T> {
	private Node<T> _head;

	public List() {
		_head = null;
	}

	public List(T data) {
		_head = new Node<T>(data);
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
