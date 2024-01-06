package Top_Interview_150.Multidimensional_DP;

public class _63_Unique_Paths_II {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i < m+1; i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i < n+1; i++) {
            dp[0][i] = 0;
        }
        dp[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for(int i = 1; i < m+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if(i == 1 && j == 1) {
                    continue;
                }
                dp[i][j] = obstacleGrid[i-1][j-1] == 1 ? 0 : dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,0,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(grid));
    }

}
