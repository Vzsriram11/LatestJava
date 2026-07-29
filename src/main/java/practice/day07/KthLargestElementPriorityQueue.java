package practice.day07;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementPriorityQueue
{
    public static void main(String[] args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.offer(30);
        pq.offer(20);
                pq.offer(100);
        pq.offer(5);
        pq.offer(10);

                while (!pq.isEmpty())
                {
                    System.out.println(pq.poll());
                }
    }
}
