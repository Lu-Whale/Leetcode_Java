package Top_Interview_150.Multidimensional_DP;

public class _97_Interleaving_String {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if(n1 + n2 != n3) {
            return false;
        }
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];
        // initial
        dp[0][0] = true;
        for(int i = 1; i <= n1; i++) {
            if(s1.charAt(i-1) == s3.charAt(i-1)) {
                dp[i][0] = true;
            }else {
                break;
            }
        }
        for(int i = 1; i <= n2; i++) {
            if(s2.charAt(i-1) == s3.charAt(i-1)) {
                dp[0][i] = true;
            }else {
                break;
            }
        }
        // find the path from dp[0][0] to dp[n1][n2]
        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                boolean down = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i - 1 + j);
                boolean right = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i + j - 1);
                dp[i][j] = down || right;
            }
        }

        return dp[n1][n2];
    }
}
