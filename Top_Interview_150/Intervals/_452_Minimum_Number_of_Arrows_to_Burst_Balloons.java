package Top_Interview_150.Intervals;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        int res = 1;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int[] point : points) {
            priorityQueue.offer(point);
        }

        int[] interval = priorityQueue.poll();
        while (!priorityQueue.isEmpty()) {
            int[] point = priorityQueue.poll();
            if (point[0] <= interval[1]) {
                interval[1] = Math.min(interval[1], point[1]);
            } else {
                res++;
                interval = point;
            }
        }

        return res;
    }
}
