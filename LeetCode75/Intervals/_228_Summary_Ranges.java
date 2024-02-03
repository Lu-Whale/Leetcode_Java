package LeetCode75.Intervals;

import java.util.ArrayList;
import java.util.List;

public class _228_Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) {
            return res;
        }
        int a = nums[0], b = nums[0];
        for (int num : nums) {
            if ((long)num - b > 1) {
                res.add(stringGenerator(a, b));
                a = num;
            }
            b = num;
        }
        res.add(stringGenerator(a, b));

        return res;
    }

    public String stringGenerator(int a, int b) {
        if(a == b) {
            return a + "";
        }else {
            return a + "->" + b;
        }
    }
}
