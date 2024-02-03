package Top_Interview_150.Array_String;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
public class _121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int lowest = prices[0];
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            lowest = Math.min(lowest, prices[i]);
            profit = Math.max(profit, prices[i] - lowest);
        }
        return profit;
    }
}
