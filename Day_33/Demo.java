import java.util.*;

public class Demo{
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("Ram");
        set.add("Rohit");
        set.add("Rohan");
        System.out.println(set);

        System.out.println(set.contains("Aditya"));

        Map<Integer,String> map = new HashMap<>();

        map.put(101,"Rampravesh");
        map.put(102,"shyam");
        map.put(103,"Aniket");

        System.out.println(map.containsKey(101));
        System.out.println(map.get(101));
    }
}