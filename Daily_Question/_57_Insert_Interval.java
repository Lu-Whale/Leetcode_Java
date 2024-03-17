package Daily_Question;

import java.util.ArrayList;
import java.util.List;

// 3.17
public class _57_Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean add = false;
        for(int[] interval : intervals) {
            int begin = interval[0];
            int end = interval[1];
            if(end < newInterval[0]) {
                list.add(interval);
            }else if(begin > newInterval[1]){
                if(!add) {
                    list.add(newInterval);
                    add = true;
                }
                list.add(interval);
            }else {
                newInterval[0] = Math.min(newInterval[0], begin);
                newInterval[1] = Math.max(newInterval[1], end);
            }
        }
        if(!add) list.add(newInterval);

        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
