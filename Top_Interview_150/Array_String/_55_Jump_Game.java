package Top_Interview_150.Array_String;

public class _55_Jump_Game {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return true;
        }

        int[] dp = new int[n];

        if(nums[0] <= 0) {
            return false;
        }else {
            dp[0] = nums[0];
        }

        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] - 1, nums[i]);
            if(dp[i] <= 0 && i < n-1) {
                return false;
            }
        }

        return true;
    }
}
