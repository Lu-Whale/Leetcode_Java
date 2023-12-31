package Top_Interview_150.Multidimensional_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _120_Triangle {
    int res = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        dfs(1, triangle, 0, 0);
        return res;
    }

    public void dfs(int row, List<List<Integer>> triangle, int pathSum, int index) {
        pathSum += triangle.get(row - 1).get(index);

        if(row == triangle.size()) {
            res = Math.min(res, pathSum);
            return;
        }

        dfs(row + 1, triangle, pathSum, index);
        dfs(row + 1, triangle, pathSum, index+1);
    }
}

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();

        int[][] dp = new int[n][m];
        dp[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for(int j = 1; j < triangle.get(i).size() - 1; j++) {
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
            }
            dp[i][triangle.get(i).size() - 1] = dp[i-1][triangle.get(i-1).size()-1] + triangle.get(i).get(triangle.get(i).size() - 1);
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            res = Math.min(res, dp[n-1][i]);
        }

        return res;

    }
}

// https://leetcode.cn/problems/triangle/solutions/329143/san-jiao-xing-zui-xiao-lu-jing-he-by-leetcode-solu/
class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }
}
