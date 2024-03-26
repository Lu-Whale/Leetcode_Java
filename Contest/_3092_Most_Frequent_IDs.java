package Contest;

import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
    int num;
    long frequency;
    public Pair(int num, long frequency) {
        this.num = num;
        this.frequency = frequency;
    }
}

public class _3092_Most_Frequent_IDs {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
       int n = nums.length;
       long[] res = new long[n];

       HashMap<Integer, Long> hashMap = new HashMap<>();
       PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(b.frequency, a.frequency));
       for(int i = 0; i < n; i++) {
           int num = nums[i];
           int k = freq[i];

           hashMap.put(num, hashMap.getOrDefault(num, 0L) + k);
           Pair pair = new Pair(num, hashMap.get(num));
           pq.offer(pair);
           while (!pq.isEmpty() && (hashMap.get(pq.peek().num) != pq.peek().frequency)) {
               pq.poll();
           }
           res[i] = pq.peek().frequency;
       }

       return res;
    }
}
