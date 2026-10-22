import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);

        Iterator<Integer> it = list.iterator();
        System.out.println("ArrayList");

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        linkedList.add(60);

        Iterator<Integer> linkedlist = linkedList.iterator();
        System.out.println("LinkedList");
        while (linkedlist.hasNext()) {
            System.out.println(linkedlist.next());
        }


        Collection<Integer> hasSet = new HashSet<>();
        hasSet.add(10);
        hasSet.add(20);
        hasSet.add(30);
        hasSet.add(40);
        hasSet.add(50);
        hasSet.add(60);

        Iterator<Integer> hasSetIterator = hasSet.iterator();
        System.out.println("HashSet");
        while (hasSetIterator.hasNext()) {
            System.out.println(hasSetIterator.next());
        }

        Collection<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(10);
        arrayDeque.add(20);
        arrayDeque.add(30);
        arrayDeque.add(40);
        arrayDeque.add(50);
        arrayDeque.add(60);

        Iterator<Integer> arrayDequeIterator = arrayDeque.iterator();
        System.out.println("arrayDeque");
        while (arrayDequeIterator.hasNext()) {
            System.out.println(arrayDequeIterator.next());
        }

    }
}
