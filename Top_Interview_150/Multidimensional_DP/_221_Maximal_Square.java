package Top_Interview_150.Multidimensional_DP;

public class _221_Maximal_Square {
    public static int maximalSquare(char[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0] - 48;
            res = Math.max(res, dp[i][0]);
        }
        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - 48;
            res = Math.max(res, dp[0][i]);
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
//                    dp[i][j] = (dp[i - 1][j] >= dp[i - 1][j - 1] && dp[i][j - 1] >= dp[i - 1][j - 1]) ? dp[i - 1][j - 1] + 1 : Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                    res = Math.max(res, dp[i][j] * dp[i][j]);
                }
            }
        }

        return res;
    }

    public int maximalSquare1(char[][] matrix) {
        // base condition
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        // 相当于已经预处理新增第一行、第一列均为0
        int[][] dp = new int[height + 1][width + 1];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (matrix[row][col] == '1') {
                    dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;
                    maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }

    // 含优化过程的代码（隔壁有终版代码）
    public int maximalSquare2(char[][] matrix) {
        // base condition
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        // 相当于已经预处理新增第一行、第一列均为0
//  int[][] dp = new int[height + 1][width + 1];
        int[] dp = new int[width + 1];
        int northwest = 0; // 西北角、左上角

//  for (int row = 0; row < height; row++) {
        for (char[] chars : matrix) {
            northwest = 0; // 遍历每行时，还原回辅助的原值0
            for (int col = 0; col < width; col++) {
                int nextNorthwest = dp[col + 1];
                if (chars[col] == '1') {
//              dp[row + 1][col + 1] = Math.min(Math.min(dp[row + 1][col], dp[row][col + 1]), dp[row][col]) + 1;
                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), northwest) + 1;

//              maxSide = Math.max(maxSide, dp[row + 1][col + 1]);
                    maxSide = Math.max(maxSide, dp[col + 1]);
                } else {
                    dp[col + 1] = 0;
                }
                northwest = nextNorthwest;
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        int i = '1';
        System.out.println(i);
    }
}
