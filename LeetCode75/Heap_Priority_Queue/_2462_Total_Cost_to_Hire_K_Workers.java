package LeetCode75.Heap_Priority_Queue;

import java.util.PriorityQueue;

public class _2462_Total_Cost_to_Hire_K_Workers {
    public static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> candidate1 = new PriorityQueue<>();
        PriorityQueue<Integer> candidate2 = new PriorityQueue<>();

        int headPointer = 0;
        int tailPointer = n-1;
        while (candidate1.size() < candidates) {
            candidate1.offer(costs[headPointer]);
            headPointer++;
        }
        while (candidate2.size() < candidates && tailPointer >= headPointer) {
            candidate2.offer(costs[tailPointer]);
            tailPointer--;
        }

        long res = 0;
        for(int i = 0; i < k; i++) {
            if(candidate1.size() > 0 && candidate2.size() == 0) {
                res += candidate1.poll();
                continue;
            }

            if(candidate2.size() > 0 && candidate1.size() == 0) {
                res += candidate2.poll();
                continue;
            }

            if(candidate1.peek() <= candidate2.peek()) {
                res += candidate1.poll();
                if(headPointer <= tailPointer) {
                    candidate1.offer(costs[headPointer]);
                    headPointer++;
                }
            }else {
                res += candidate2.poll();
                if(tailPointer >= headPointer) {
                    candidate2.offer(costs[tailPointer]);
                    tailPointer--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] costs = {18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75};
        System.out.println(costs.length);
        int k = 13;
        int candidates = 23;

        System.out.println(totalCost(costs, k, candidates));
    }
}
