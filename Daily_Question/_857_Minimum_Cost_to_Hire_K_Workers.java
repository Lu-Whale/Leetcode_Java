package Daily_Question;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _857_Minimum_Cost_to_Hire_K_Workers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] id = new Integer[n];
        Arrays.setAll(id, i -> i);
        // 按照 r 值排序
        Arrays.sort(id, (i, j) -> wage[i] * quality[j] - wage[j] * quality[i]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int sumQ = 0;
        for (int i = 0; i < k; i++) {
            pq.offer(quality[id[i]]);
            sumQ += quality[id[i]];
        }

        // 选 r 值最小的 k 名工人
        double ans = sumQ * ((double) wage[id[k - 1]] / quality[id[k - 1]]);

        // 后面的工人 r 值更大
        // 但是 sumQ 可以变小，从而可能得到更优的答案
        for (int i = k; i < n; i++) {
            int q = quality[id[i]];
            if (q < pq.peek()) {
                sumQ -= pq.poll() - q;
                pq.offer(q);
                ans = Math.min(ans, sumQ * ((double) wage[id[i]] / q));
            }
        }
        return ans;
    }
}
