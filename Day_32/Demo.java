import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(10);                    // Add to end
        numbers.add(20);
        numbers.add(1, 15);                 // Insert at index 1: [10, 15, 20]
        numbers.addAll(List.of(30, 40));    // Add multiple: [10, 15, 20, 30, 40]

        System.out.println(numbers.get(0)); // 10
        numbers.set(0, 5);                  // Replace: [5, 15, 20, 30, 40]

        System.out.println(numbers.size());          // 5
        System.out.println(numbers.contains(20));    // true
        System.out.println(numbers.indexOf(30));     // 3
        System.out.println(numbers.lastIndexOf(20)); // 2

        numbers.remove(Integer.valueOf(15)); // Remove the value 15
        numbers.remove(0);                   // Remove the element at index 0

        numbers.replaceAll(n -> n * 2);
        numbers.sort(Integer::compareTo);
        System.out.println(numbers);         // [40, 60, 80]

        List<Integer> part = numbers.subList(0, 2);
        System.out.println(part);            // [40, 60]

        numbers.removeIf(n -> n > 50);
        System.out.println(numbers);         // [40]

        System.out.println(numbers.isEmpty()); // false
        numbers.clear();
        System.out.println(numbers.isEmpty()); // true
    }
}