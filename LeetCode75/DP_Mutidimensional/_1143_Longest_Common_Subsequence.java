package LeetCode75.DP_Mutidimensional;

//https://leetcode.com/problems/longest-common-subsequence/description/?envType=study-plan-v2&envId=leetcode-75

/**
 * Note:
 *
 * Why start the loop from 1?
 * The reason for starting the loops from 1 is that dp[0][x] and dp[x][0] (for any value of x)
 * represent the scenarios where one of the strings is empty. In such cases, the LCS length is 0,
 * which is the default value for an int array.
 *
 * What is the transition equation in DP?
 * The transition equation is at the heart of the algorithm, dictating how solutions to smaller
 * subproblems can be used to solve larger subproblems. For this problem, there are two parts to
 * the transition equation, depending on whether the current characters being considered are the
 * same or not.
 *
 */
public class _1143_Longest_Common_Subsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }

        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String test1 = "abcdef", test2 = "ace";

        System.out.println(longestCommonSubsequence(test1, test2));

    }
}

