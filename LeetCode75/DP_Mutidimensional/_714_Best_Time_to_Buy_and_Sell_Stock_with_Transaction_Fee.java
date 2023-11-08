package LeetCode75.DP_Mutidimensional;

public class _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        // 0 stand for at the end of the day, we don't hold a stock, 1 stand for we hold a stock
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1; i < n; i++) {

            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    public int Greedy(int[] prices, int fee) {
        int n = prices.length;

        int buy = prices[0] + fee;
        int profit = 0;
        for(int i = 1; i < n; i++) {

            if(prices[i] + fee < buy) {
                buy = prices[i] + fee;
            }else if(prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }

        return profit;
    }

}
