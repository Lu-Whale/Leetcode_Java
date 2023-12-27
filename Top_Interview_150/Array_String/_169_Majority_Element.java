package Top_Interview_150.Array_String;

import java.util.Arrays;

public class _169_Majority_Element {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return nums[n/2];
    }
}
