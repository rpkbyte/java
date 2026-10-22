import java.util.*;

public class Demo4 {
    public static void main(String[] args) {
        // HashMap / LinkedHashMap

        Map<Integer, String> map = new LinkedHashMap<>();

        Map<Integer, String> map2 = new LinkedHashMap<>(100);

        Map<Integer, String> map3 = new LinkedHashMap<>(100, 0.8f);

        Map<Integer, String> map4 = new LinkedHashMap<>(map3);
    }
}