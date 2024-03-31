package Contest;

public class _3101_Count_Alternating_Subarrays {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        if(n == 1) return n;

        long res = n;

        int left = 0;
        for(int right = 1; right < n; right++) {
            if(nums[right] == nums[right-1]) {
                left = right;
            }
            res += right - left;
        }

        return res;
    }
}
