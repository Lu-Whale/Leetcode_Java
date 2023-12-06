package LeetCode75.Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _435_Non_overlapping_Intervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int res = 0;
        int preIntervalEnding = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < preIntervalEnding) {
                preIntervalEnding = Math.min(intervals[i][1], preIntervalEnding);
                res++;
            }else {
                preIntervalEnding = intervals[i][1];
            }
        }

        return res;
    }

    // Greedy based on the sort of right boundary
    public int SortBasedOnRightBoundaryOfInterval(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int count = 1;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
            }else{
                count++;
            }
        }
        return intervals.length - count;
    }

    // dynamic programming solution
    public int dp(int[][] intervals) {
        int n = intervals.length;
        if(n == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return n - Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {1,4}, {2,3}, {3,4}, {1,3}};

        eraseOverlapIntervals(intervals);
    }
}
