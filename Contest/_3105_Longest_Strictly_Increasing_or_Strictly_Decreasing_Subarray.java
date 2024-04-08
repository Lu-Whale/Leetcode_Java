package Contest;

public class _3105_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray {
    public int longestMonotonicSubarray(int[] nums) {
        int res = 1;
        int n = nums.length;
        if(n == 1) return res;

        int left = 0;
        int increasing = 0; // 0 = default, 1 = increasing, -1 = decreasing
        for(int right = 1; right < n; right++) {
            if(nums[right] > nums[right - 1]) {
                if(increasing != 1) {
                    increasing = 1;
                    res = Math.max(res, right - left);
                    left = right - 1;
                }
            }else if(nums[right] < nums[right - 1]) {
                if(increasing != -1) {
                    increasing = -1;
                    res = Math.max(res, right - left);
                    left = right - 1;
                }
            }else {
                increasing = 0;
                res = Math.max(res, right - left);
                left = right;
            }
        }
        res = Math.max(res, n - left);

        return res;
    }
}
