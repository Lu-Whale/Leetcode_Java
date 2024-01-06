package Top_Interview_150.Multidimensional_DP;

public class _64_Minimum_Path_Sum {
    public static int minPathSum(int[][] grid) {

        int m = grid.length; // 行
        int n = grid[0].length; // 列

        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m + 1; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < n + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        dp[1][1] = grid[0][0];
        for(int i = 1; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                if(i == 1 && j ==1) {
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(minPathSum(grid));

        int[][] grid2 = {{1,3,1}};
        System.out.println(minPathSum(grid2));

        int[][] grid3 = {{1},{3},{1}};
        System.out.println(minPathSum(grid3));

    }
}
