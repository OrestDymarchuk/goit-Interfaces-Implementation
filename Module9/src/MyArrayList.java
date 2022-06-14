import java.util.Arrays;

public class MyArrayList<E> {
	private Object[] elements;
	private int size = 0;

	public MyArrayList() {
		elements = new Object[10];
	}

	public void add(E element) {
		if (size == elements.length) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
		elements[size++] = element;
	}

	public Object remove(int index) {
		if (index < size) {
			Object obj = elements[index];
			elements[index] = null;
			int tmp = index;
			while (tmp < size) {
				elements[tmp] = elements[tmp + 1];
				elements[tmp + 1] = null;
				tmp++;
			}
			size--;
			return obj;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	public int size() {
		return size;
	}

	public Object get(int index) {
		if (index < size) {
			return elements[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (elements == null) {
			return "[]";
		} else {

			for (int i = 0; i < size; i++) {
				sb.append(elements[i].toString());
				if (i != size - 1)
					sb.append(", ");
			}

			return "[" + sb.toString() + "]";
		}
	}
}
