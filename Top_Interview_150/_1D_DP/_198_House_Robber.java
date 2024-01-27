package Top_Interview_150._1D_DP;

// https://leetcode.com/problems/house-robber/?envType=study-plan-v2&envId=top-interview-150
public class _198_House_Robber {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        if(n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = Math.max(dp[0] + nums[2], dp[1]);
        for(int i = 3; i < n; i++) {
            int robThisHouse = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
            int doNotRobThisHouse = Math.max(dp[i-1], dp[i-2]);
            dp[i] = Math.max(robThisHouse, doNotRobThisHouse);
        }

        return Math.max(dp[n - 1], dp[n - 2]);
    }
}

class Solution198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
}

class Solution198_spaceOptimised {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for(int i = 2; i < n; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }
}