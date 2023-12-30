package Top_Interview_150.Array_String;

public class _122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];

        dp[0] = 0;

        for(int i = 1; i < n; i++) {
            int hold = prices[i] - prices[i-1];

            dp[i] = Math.max(dp[i-1], dp[i-1] + hold);
        }

        return dp[n-1];
    }

    public int maxProfit2(int[] prices) {

        int res = 0, n = prices.length;

        for(int i = 1; i < n; i++) {
            if(prices[i] > prices[i-1]) {
                res += prices[i] - prices[i-1];
            }
        }

        return res;
    }
}
