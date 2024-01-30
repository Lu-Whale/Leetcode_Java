package Top_Interview_150.Intervals;

import java.util.ArrayList;
import java.util.List;

public class _57_Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>();
        boolean newIntervalAdded = false;
        for(int[] interval : intervals) {
            if(interval[1] < newInterval[0]) {
                list.add(interval);
            }else if(interval[0] > newInterval[1]) {
                if(!newIntervalAdded) {
                    list.add(newInterval);
                    newIntervalAdded = true;
                }
                list.add(interval);
            }else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if(!newIntervalAdded) {
            list.add(newInterval);
        }

        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
