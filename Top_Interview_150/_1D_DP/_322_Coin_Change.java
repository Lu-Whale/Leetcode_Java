package Top_Interview_150._1D_DP;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/?envType=study-plan-v2&envId=top-interview-150
public class _322_Coin_Change {
    int[] cache;
    public int coinChange(int[] coins, int amount) {

        cache = new int[amount];

        return dfs(coins, amount);
    }

    public int dfs(int[] coins, int amount) {
        if(amount < 0) {
            return -1;
        }
        if(amount == 0) {
            return 0;
        }
        if(cache[amount - 1] != 0) {
            return cache[amount -1];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int res = dfs(coins, amount - coins[i]);
            if(res >= 0 && res < min) {
                min = res + 1;
            }
        }
        cache[amount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return cache[amount - 1];
    }
}

// Dynamic Programming
class Solution_322_dp {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for(int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int coin : coins) {
                if(i - coin >= 0 && dp[i - coin] < min) {
                    min = dp[i - coin] + 1;
                }
            }
            dp[i] = min;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}


