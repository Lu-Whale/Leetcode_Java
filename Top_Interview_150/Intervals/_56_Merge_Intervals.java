package Top_Interview_150.Intervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
public class _56_Merge_Intervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[] tmp = intervals[0];
        int count = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= tmp[1]) {
                tmp[1] = Math.max(intervals[i][1], tmp[1]);
            }else {
                intervals[count] = tmp;
                tmp = intervals[i];
                count++;
            }
        }
        intervals[count] = tmp;

        int[][] res = new int[count+1][2];
        System.arraycopy(intervals, 0, res, 0, count + 1);

        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {8,10}, {2,6}, {15, 18}};
        System.out.println(Arrays.toString(merge(intervals)));

    }
}


