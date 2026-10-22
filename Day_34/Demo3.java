import java.util.*;

public class Demo3 {
    public static void main(String[] args) {
        // ROllNo, Names
        Map<Integer, String> map = new HashMap<>();
        map.put(101, "Aditya");
        map.put(102, "Rohit");
        map.put(103, "Rohan");

        map.size();
        map.isEmpty();

        //System.out.println(map.containsValue("Aditya"));

        // System.out.println(map.put(103, "Abhay"));
        // System.out.println(map.get(103));

        //map.remove(101);

        // Map<Integer, String> map2 = new HashMap<>();

        // map.putAll(map2);

        // map.clear();

        // Set<Integer> set = map.keySet();
        // System.out.println(set);

    //    Collection<String> c =  map.values();
    //    System.out.println(c);

    //    Set<Map.Entry<Integer, String>> entries = map.entrySet();
    //    System.out.println(entries);

        //System.out.println(map.getOrDefault(105, "Unknown"));

        // System.out.println(map.putIfAbsent(103, "Abhay"));

        // map.remove(101, "Abhay");

        //map.replace(101, "Sonu");
        //map.replace(101, "Aditya", "Sonu");

        // Set<Map.Entry<Integer, String>> entries = map.entrySet();

        // for(Map.Entry<Integer, String> entry : entries) {
        //     Integer key = entry.getKey();
        //     String value = entry.getValue();

        //     System.out.println(key + " , " + value);
        // }

        Map<Integer, String> map2 = Map.of(101, "Aditya", 102, "Rohit");
        map2.put(103, "Rohan");

        

    }
}

// put() --> always replaces
// putIfAbsent() --> does not replace existing value