import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Map_Print {
    public static void main(String[] agrs) {
        Map<String, String> map = new HashMap<String, String>(); 
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        //방법 1 
        Iterator<String> keys = map.keySet().iterator();
        while( keys.hasNext() ){
            String key = keys.next();
            String value = map.get(key);
            System.out.println("키 : "+key+", 값 : "+value);
        }
        
        //방법 2
        for( String key : map.keySet() ){
            String value = map.get(key);
            System.out.println( String.format("키 : "+key+", 값 : "+ value));
        }
        
        //방법 3
        for( Map.Entry<String, String> element : map.entrySet() ){
            String key = element.getKey();
            String value = element.getValue();
            System.out.println( String.format("키 : "+key + ", 값 : "+ value));
        }
    }
}