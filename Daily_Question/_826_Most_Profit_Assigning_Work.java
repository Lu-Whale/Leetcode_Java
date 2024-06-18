package Daily_Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _826_Most_Profit_Assigning_Work {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        Arrays.sort(worker);
        int[][] jobs = new int[n][2];
        for(int i = 0; i < n; i++) {
            jobs[i] = new int[]{difficulty[i], profit[i]};
        }
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);

        int res = 0, index = 0, cur_profit = 0;
        for(int w : worker) {
            while (index < n && w >= jobs[index][0]) {
                cur_profit = Math.max(cur_profit, jobs[index++][1]);
            }
            res += cur_profit;
        }

        return res;
    }
}
