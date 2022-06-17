
public class MyHashMap<K, V> {
	private Entry<K, V>[] bucket;
	private int size = 16;
	
	@SuppressWarnings("unchecked")
	public MyHashMap() {
		bucket = new Entry[size];
	}

	@SuppressWarnings("hiding")
	private class Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	private int hash(K key) {
		return Math.abs(key.hashCode()) % size;
	}

	public void put(K newKey, V data) {
		if (newKey == null)
		return;
		Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);
		int hash = hash(newKey);
		if (bucket[hash] == null) {
			bucket[hash] = newEntry;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = bucket[hash];

			while (current != null) {
				if (current.key.equals(newKey)) {
					if (previous == null) {
						newEntry.next = current.next;
						bucket[hash] = newEntry;
						return;
					} else {
						newEntry.next = current.next;
						previous.next = newEntry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}

	public V get(K key) {
		int hash = hash(key);
		if (bucket[hash] == null) {
			return null;
		} else {
			Entry<K, V> temp = bucket[hash];
			while (temp != null) {
				if (temp.key.equals(key))
					return temp.value;
				temp = temp.next;
			}
			return null;
		}
	}

	public boolean remove(K deleteKey) {

		int hash = hash(deleteKey);

		if (bucket[hash] == null) {
			return false;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = bucket[hash];

			while (current != null) {
				if (current.key.equals(deleteKey)) {
					if (previous == null) {
						bucket[hash] = bucket[hash].next;
						return true;
					} else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}
	}
	
	public int size() {
		int count = 0;
		for(int i = 0; i < size; i++) {
			if (bucket[i] != null) {
				count++;
			}
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		bucket = new Entry[bucket.length];
	}

	@Override
	public String toString() {		
		if (bucket == null) {
			return "{}";
		}

		for (int i = 0; i < size; i++) {
			if (bucket[i] != null) {
				Entry<K, V> entry = bucket[i];
				while (entry != null) {
					System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
					entry = entry.next;
				}
			}
		}
		return "";
	}
}