package LeetCode75.Heap_Priority_Queue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class _2336_Smallest_Number_in_Infinite_Set {

}

class SmallestInfiniteSet {
    private PriorityQueue<Integer> priorityQueue;
    private int min;

    public SmallestInfiniteSet() {
        priorityQueue = new PriorityQueue<>();
        min = 1;
    }

    public int popSmallest() {
        if(!priorityQueue.isEmpty()) {
            return priorityQueue.poll();
        }
        return min++;
    }

    public void addBack(int num) {
        if(num < min && !priorityQueue.contains(num)) {
            priorityQueue.offer(num);
        }
    }
}
