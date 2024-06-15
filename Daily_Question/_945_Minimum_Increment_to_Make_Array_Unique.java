package Daily_Question;

import java.util.Arrays;

public class _945_Minimum_Increment_to_Make_Array_Unique {
    public int minIncrementForUnique(int[] nums) {
        int res = 0;

        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            while (nums[i] <= nums[i-1]) {
                nums[i]++;
                res++;
            }
        }
        return res;
    }
}
