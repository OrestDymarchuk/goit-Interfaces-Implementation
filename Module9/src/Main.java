
public class Main {

	public static void main(String[] args) {
		MyHashMap<Integer, Integer> map = new MyHashMap<>();
		
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		map.put(5, 5);
		map.put(6, 6);
		map.put(1, 7);
		
		System.out.println(map.size());
		
		System.out.println(map);
		
		

	}
}
