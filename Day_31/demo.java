import java.util.*;

public class demo {
    public static void main(String[] args){

        Collection<Integer> c = new ArrayList<>();

        c.add(1);
        c.add(2);
        c.add(3);
        // System.out.println(c.size());
        // System.out.println(c.isEmpty());
        // System.out.println(c.contains(2));

        // iterate() --> Iterator

        //Object[] toArray();

        // Object[] obj = c.toArray();
        // for(Object o:obj){
        //     System.out.println(o);
        // }

        // T[] toArray(T[] a)

        // Integer[] arr = c.toArray(new Integer[0]);
        // for(Integer i : arr){
        //     System.out.println(i);
        // }

        // bollean add(E e);

        boolean b = c.add(4);
        // System.out.println(b);

        // boolean remove(Object obj);

        // System.out.println(c.remove(4));

        //boolean addAll(collection<? extends E>c)

        c.addAll(List.of(5,6,7,8,9));
        
        // System.out.println(c);

        // boolean cntainsAll(Collection<?> c);
        // System.out.println(c.containsAll(List.of(1,2,3)));

        //boolean removeAll(Collection<?> c)

        // System.out.println(c.removeAll(List.of(1,2,3)));

        // boolean retainAll(Collection<?> c); -->Intersection

        System.out.println(c.retainAll(List.of(1,2,67)));








    }    

    
}
