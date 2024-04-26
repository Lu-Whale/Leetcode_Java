package Daily_Question;

public class _1289_Minimum_Falling_Path_Sum_II {
    public static int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        int[] min = {Integer.MAX_VALUE, -1}; // min[0] is the minimum sum of the path,while min[1] is the index
        int[] secMin = {Integer.MAX_VALUE, -1};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    dp[0][j] = grid[0][j];
                    if(dp[0][j] < min[0]) {
                        secMin = min;
                        min = new int[]{dp[0][j], j};
                    }else if(dp[0][j] < secMin[0]) {
                        secMin = new int[]{dp[0][j], j};
                    }
                }else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 1; i < n; i++) {
            int[] tempMin = {Integer.MAX_VALUE, -1};
            int[] tempSecMin = {Integer.MAX_VALUE, -1};
            for(int j = 0; j < n; j++) {
                if(j != min[1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][min[1]] + grid[i][j]);
                }else {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][secMin[1]] + grid[i][j]);
                }
                //update min and second min
                if(dp[i][j] < tempMin[0]) {
                    tempSecMin = tempMin;
                    tempMin = new int[]{dp[i][j], j};
                }else if(dp[i][j] < tempSecMin[0]) {
                    tempSecMin = new int[]{dp[i][j], j};
                }
            }
            min = tempMin;
            secMin = tempSecMin;
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            res = Math.min(res, dp[n-1][i]);
        }

        return res;
    }
}
