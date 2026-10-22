import java.util.PriorityQueue;

public class Demo2 {
    public static void main(String[] args){

        // min heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(10);
        priorityQueue.offer(20);
        priorityQueue.offer(30);
        priorityQueue.offer(40);
        priorityQueue.offer(50);

        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.poll());

        //max heap 
        PriorityQueue<Integer> priorityQueue2 =new PriorityQueue<>((a,b)->b-a);

        priorityQueue2.offer(10);
        priorityQueue2.offer(20);
        priorityQueue2.offer(30);
        priorityQueue2.offer(40);
        priorityQueue2.offer(50);

        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue2.poll());
        System.out.println(priorityQueue2.poll());
    }
}
