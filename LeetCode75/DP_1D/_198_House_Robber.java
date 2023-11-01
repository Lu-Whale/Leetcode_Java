package LeetCode75.DP_1D;

//https://leetcode.com/problems/house-robber/description/?envType=study-plan-v2&envId=leetcode-75
public class _198_House_Robber {
    public int mySolution(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] dp = new int[n + 2];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }

        return dp[n-1];
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }
}
