package LeetCode75.DP_Mutidimensional;

// https://leetcode.com/problems/edit-distance/?envType=study-plan-v2&envId=leetcode-75
public class _72_Edit_Distance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // initial when one string is null
        for(int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        //dynamic programing
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                //dp[i-1[j-1] stand for replace
                //dp[i-1][j] stand for insert
                //dp[i][j-1] stand for delete

                // i-1 is the index of i th char in word1
                // if they are equal, then we don't need to do the replace operation
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
