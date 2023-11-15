package Problem_List;

public class _256_Paint_House {
    public static int minCost(int[][] costs) {
        // 0->red 1->blue 2->green
        int houses = costs.length;
        int[][] dp = new int[houses][3];

        for(int i = 0; i < costs[0].length; i++) {
            dp[0][i] = costs[0][i];
        }

        for(int i = 1; i < houses; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }

        return Math.min(dp[houses-1][0],Math.min(dp[houses-1][1], dp[houses-1][2]));
    }

    public static void main(String[] args) {
        int[][] costs = {{17,2,17}, {16,16,5}, {14,3,19}};

        System.out.println(minCost(costs));
    }
}
