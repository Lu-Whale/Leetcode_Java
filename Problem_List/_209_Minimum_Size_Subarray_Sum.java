package Problem_List;

public class _209_Minimum_Size_Subarray_Sum {
    public static int minSubArrayLen(int target, int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        // sliding window
        int result = Integer.MAX_VALUE;
        int left = 0;
        // used for record the sum in sliding window
        int sum = 0;
        for(int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // update left boundary of sliding window
            if(sum >= target) {
                for(;left < right; left++) {
                    if(sum - nums[left] >= target) {
                        sum -= nums[left];
                    }else {
                        break;
                    }
                }
                result = Math.min(result, right - left + 1);
            }
        }

        return sum < target ? 0 : result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;

        System.out.println(minSubArrayLen(target, nums));
    }
}
