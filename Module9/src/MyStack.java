import java.util.Arrays;

public class MyStack<E> {
	private E[] elements;
	private int size = 0;
 
	@SuppressWarnings("unchecked")
	public MyStack() {
		elements = (E[]) new Object[10];
	}
	
	public void push(E elementToPush) {
		if (size == elements.length) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
		elements[size++] = elementToPush;
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
		elements = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public E peek() {
        return (E) elements[size - 1];
    }
	
	public E pop() {
        E topElement = (E) elements[size - 1];
        elements[--size] = null;
        return topElement;
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


