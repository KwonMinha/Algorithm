import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Map_Print {
	public static void main(String[] agrs) {
		HashMap<String, String> map = new HashMap<String, String>(); 
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");

		//방법 1-1 : keySet() & Iterator
		System.out.println("방법 1-1 : keySet() & Iterator");
		Iterator<String> keys = map.keySet().iterator();
		while(keys.hasNext() ){
			String key = keys.next();
			String value = map.get(key);
			System.out.println("키 : " + key + ", 값 : " + value);
		}

		//방법 1-2 : keySet() & for 
		System.out.println("\n방법 1-2 : keySet() & for");
		for(String key : map.keySet() ){
			String value = map.get(key);
			System.out.println("키 : " + key + ", 값 : " + value);
		}

		//방법 2 : entrySet() 
		System.out.println("\n방법 2 : entrySet()");
		for(Map.Entry<String, String> element : map.entrySet() ){
			String key = element.getKey();
			String value = element.getValue();
			System.out.println("키 : " + key + ", 값 : " + value);
		}

		//value값으로 key 찾기
		System.out.println("\nvalue값으로 key 찾기1 : " + getKey(map, "value1"));
		System.out.println("\nvalue값으로 key 찾기2 : " + getKey2(map, "value1"));

	}

	//value로 key 찾기 
	public static <K, V> K getKey(Map<K, V> map, V value) {
		for (K key : map.keySet()) {
			if (value.equals(map.get(key))) {
				return key;
			}
		}
		return null;
	}

	public static Object getKey2(HashMap<String, String> map, Object value) {
		for(Object o: map.keySet()) {
			if(map.get(o).equals(value)) { 
				return o; 
			}
		} return null;
	}
	
}