import java.util.TreeSet;

public class Demo2 {
    public static void main(String[] args) {
        // TreeSet

        TreeSet<Integer> set = new TreeSet<>();

        //Set<Integer> set2 = new TreeSet<>(List.of(2,5,7,9));

        set.add(80);
        set.add(23);
        set.add(10);
        set.add(90);
        set.add(50);

    //     // SortedSet Interface --> O(log N)
        System.out.println(set.first());
        System.out.println(set.last());

        System.out.println(set.headSet(80));

        //fromElement is inclusive
       System.out.println(set.tailSet(80));

       // fromELement is inclusice and toELement is Exclusive
        System.out.println(set.subSet(23, 80));

    // // Navigable Set

    // // largest number smaller then 80
    //     System.out.println(set.lower(10));

    //     // greatest element less thern or equal to 80
    //     System.out.println(set.floor(10));

    //     //smallest no. greater then 80
    //     System.out.println(set.higher(80));

    //     // smallest no. greater then or equal to 80
    //     System.out.println(set.ceiling(80));

        // System.out.println(set.pollFirst());
        // System.out.println(set.pollLast());

        // System.out.println(set.descendingSet());

        // Iterator<Integer> it = set.descendingIterator();

        // while(it.hasNext()) {
        //     System.out.println(it.next());
        // }

        System.out.println(set.headSet(80, true));
        set.tailSet(80, false);
        set.subSet(10, false, 80, true);



    }
}


// BST --> leftest most node --> smallest
// rightest most node. --> largest