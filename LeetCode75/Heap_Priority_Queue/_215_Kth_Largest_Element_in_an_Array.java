package LeetCode75.Heap_Priority_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _215_Kth_Largest_Element_in_an_Array {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i = 0 ; i < nums.length; i++) {
            if(priorityQueue.size() < k) {
                priorityQueue.add(nums[i]);
            }else {
                if(nums[i] > priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(nums[i]);
                }
            }
        }

        return priorityQueue.peek();

    }
}
