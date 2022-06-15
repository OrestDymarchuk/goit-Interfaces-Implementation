
public class MyQueue<E> {
	private Node head;
	private Node tail;
	private int size;

	public MyQueue() {
		this.size = 0;
	}

	private class Node {
		private E element;
		Node next;
		Node prev;

		public Node(E element) {
			this.element = element;
		}
	}

	public void add(E element) {
		Node temp = new Node(element);
		if (head == null) {
			head = temp;
		} else {
			tail.next = temp;
			temp.prev = tail;
		}
		tail = temp;
		size++;
	}

	public void remove(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			head = head.next;
			head.prev = null;
			size--;
		} else if (index == size - 1) {
			tail = tail.prev;
			tail.next = null;
			size--;
		} else {
			Node toDelete = head;	
			for (int i = 0; i < index; i++) {
				toDelete = toDelete.next;
			}	
			if(toDelete != null) {
				if(toDelete.next != null) {
					toDelete.next.prev = toDelete.prev;
				}
				toDelete.prev.next = toDelete.next;
			}
			size--;		
		}
	}

	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return size;
	}

	public E peek() {
		return head == null ? null : head.element;
	}

	public E poll() {
		if (head == null) {
			return null;
		}
		E output = head.element;
		head = head.next;
		size--;
		return output;
	}

	@Override
	public String toString() {
		if (head == null) {
			return "[]";
		} else {
			String result = "[" + head.element;
			Node current = head.next;
			while (current != null) {
				result += ", " + current.element;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}
}