import java.util.ArrayDeque;

public class Demo{
    public static void main(String[] args) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        // simgle ended queue

        //enqueue

        queue.add(1); //exception
        queue.offer(2); //false
        queue.offer(3);
        queue.poll();

        System.out.println(queue.peek()); //return null
        System.out.println(queue.element()); //exception
    }
}