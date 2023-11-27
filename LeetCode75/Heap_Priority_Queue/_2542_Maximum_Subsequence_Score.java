package LeetCode75.Heap_Priority_Queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _2542_Maximum_Subsequence_Score {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long res = 0;

        Integer[] sorts = new Integer[n];
        for(int i = 0; i < n; i++) {
            sorts[i] = i;
        }
        Arrays.sort(sorts,(a,b)->nums2[b]-nums2[a]);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        long sum = 0;
        for(int i = 0; i < k - 1; i++) {
            sum += nums1[sorts[i]];
            priorityQueue.offer(nums1[sorts[i]]);
        }

        for(int i = k - 1; i < n; i++) {
            sum += nums1[sorts[i]];
            priorityQueue.offer(nums1[sorts[i]]);
            res = Math.max(res, nums2[sorts[i]] * sum);
            sum -= priorityQueue.poll();
        }

        return res;
    }
}
