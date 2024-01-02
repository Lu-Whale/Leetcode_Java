package Top_Interview_150.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class _128_Longest_Consecutive_Sequence {
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int res = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                continue;

            }
            if(nums[i] - nums[i-1] == 1) {
                count++;
            }else {
                res = Math.max(res, count);
                count = 1;
            }
        }
        res = Math.max(res, count);

        return res;
    }



    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        longestConsecutive(nums);
    }
}
