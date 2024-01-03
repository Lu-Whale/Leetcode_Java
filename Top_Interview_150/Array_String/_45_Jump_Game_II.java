package Top_Interview_150.Array_String;

import java.util.Arrays;

public class _45_Jump_Game_II {
    public int jump_dp(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= i + nums[i] && j < n; j++) {
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }

        return dp[n-1];
    }

    public int jump2_greedy(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
