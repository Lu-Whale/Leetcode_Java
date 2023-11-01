package LeetCode75.DP_1D;

//https://leetcode.com/problems/n-th-tribonacci-number/?envType=study-plan-v2&envId=leetcode-75
public class _1137_NthTribonacciNumber {
    public int mySolution(int n) {
        int[] dp = new int[n+1];

        if(n == 0) {
            return 0;
        }else if(n == 1) {
            return 1;
        }else if(n == 2) {
            return 1;
        }else {
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;

            for(int i = 3; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }

            return dp[n];
        }
    }

    public int tribonacci(int n) {
        int ans[]=new int[n+3];
        ans[0]=0;
        ans[1]=1;
        ans[2]=1;
        int i=3;
        while(i<=n){
            ans[i]=ans[i-1]+ans[i-2]+ans[i-3];
            i++;

        }

        return ans[n];
    }
}
