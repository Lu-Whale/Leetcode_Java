package LeetCode75.Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class _452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int res = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            }else {
                res++;
                end = points[i][1];
            }
        }

        return res;
    }
}
