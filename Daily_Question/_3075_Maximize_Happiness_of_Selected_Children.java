package Daily_Question;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _3075_Maximize_Happiness_of_Selected_Children {
    public long maximumHappinessSum(int[] happiness, int k) {
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int child : happiness) {
            pq.offer(child);
        }

        for(int i = 0; i < k; i++) {
            res += Math.max(pq.poll() - i, 0);
        }

        return res;
    }
}
