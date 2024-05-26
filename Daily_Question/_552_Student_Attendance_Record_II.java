package Daily_Question;

import java.util.HashSet;

// 该题解讲的很好
// https://leetcode.cn/problems/student-attendance-record-ii/solutions/941074/tong-ge-lai-shua-ti-la-yi-ti-liu-jie-dfs-s5fa/
public class _552_Student_Attendance_Record_II {
    final int MOD = 1000000007;

    public int checkRecord(int n) {
        return dfs(0, n, 0, 0);
    }

    public int dfs(int day, int n, int absent, int late) {
        if(day >= n) return 1;

        // 回溯开始
        int ans = 0;
        // 1. Present随便放
        ans = (ans + dfs(day + 1, n, absent, 0)) % MOD;
        // 2. Absent最多只能放一个
        if (absent < 1) {
            ans = (ans + dfs(day + 1, n, 1, 0)) % MOD;
        }
        // 3. Late最多连续放2个
        if (late < 2) {
            ans = (ans + dfs(day + 1, n, absent, late + 1)) % MOD;
        }


        return ans;
    }
}

/**
 * 方法二、DFS + 记忆化
 * 在方法一中，我们可以看到 DFS 的过程中有三个变量：day、absent、late，而这三个变量相同的情况下是有可能重复计算的。
 *
 * 比如，我们要计算 day=2, absent=1, late=0，它有可能从哪些状态而来呢？
 *
 * absent=1可能是第 0 天填入的；
 * absent=1可能是第 1 天填入的；
 * 所以，以上两种情况，到第 2 天的时候的状态是完全一样的，也就产生了重复计算，
 * 所以，我们可以声明一个缓存，记录每个状态下计算得到的值，下次再遇到相同的状态，直接返回即可。
 *
 * 这里的状态总共有三个维度：[day, absent, late]。
 */
class Solution_552_Memory {

    int MOD = 1000000007;

    public int checkRecord(int n) {
        int[][][] memo = new int[n][2][3];
        return dfs(0, n, 0, 0, memo);
    }

    private int dfs(int day, int n, int absent, int late, int[][][] memo) {
        if (day >= n) {
            return 1;
        }

        // 相同的状态计算过了直接返回
        if (memo[day][absent][late] != 0) {
            return memo[day][absent][late];
        }

        // 回溯开始
        int ans = 0;
        // 1. Present随便放
        ans = (ans + dfs(day + 1, n, absent, 0, memo)) % MOD;
        // 2. Absent最多只能放一个
        if (absent < 1) {
            ans = (ans + dfs(day + 1, n, 1, 0, memo)) % MOD;
        }
        // 3. Late最多连续放2个
        if (late < 2) {
            ans = (ans + dfs(day + 1, n, absent, late + 1, memo)) % MOD;
        }

        // 记录每一个状态的计算结果
        memo[day][absent][late] = ans;

        return ans;
    }
}

/**
 * 方法三、动态规划
 * 好了，有了记忆化，转 DP 就非常简单了，只要把 memo 改成 dp 即可，我们这样定义动态规划：
 *
 * 状态定义：dp[i][j][k]表示第 i 天、在 A 为 j 次、连续的 L 为 k 次的方案数。
 * 状态转移：所有的状态都是从前一天，即 i-1，转移而来，但是对于 j 和 k，要分三种情况来讨论：
 * 当前填入的是 P，i-1 天的任何状态都能转移过来；
 * 当前填入的是 A，i-1 天即之前肯定没填过 A，同时所有的 late 状态都可以转移到过来。
 * 当前填入的是 L，i-1 天最多只能有一个连续的 L，其他的状态依次转移过来。
 * 为了方便计算，我们把第 0 天的值初始化。
 */
class Solution_552_DP {

    int MOD = 1000000007;

    public int checkRecord(int n) {
        long[][][] dp = new long[n][2][3];
        // 初始值
        dp[0][0][0] = 1;
        dp[0][1][0] = 1;
        dp[0][0][1] = 1;

        for (int i = 1; i < n; i++) {
            // 本次填入P，分成前一天累计了0个A和1个A两种情况
            dp[i][0][0] = (dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            dp[i][1][0] = (dp[i - 1][1][0] + dp[i - 1][1][1] + dp[i - 1][1][2]) % MOD;
            // 本次填入A，前一天没有累计A都能转移过来
            // 这行可以与上面一行合并计算，为了方便理解，我们分开，下面会合并
            dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][0] + dp[i - 1][0][1] + dp[i - 1][0][2]) % MOD;
            // 本次填入L，前一天最多只有一个连续的L，分成四种情况
            dp[i][0][1] = dp[i - 1][0][0];
            dp[i][0][2] = dp[i - 1][0][1];
            dp[i][1][1] = dp[i - 1][1][0];
            dp[i][1][2] = dp[i - 1][1][1];
        }

        // 计算结果，即最后一天的所有状态相加
        long ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dp[n - 1][i][j]) % MOD;
            }
        }

        return (int) ans;
    }
}


/**
 * 方法四、动态规划 + 降维I
 * 在方法三中，可以看到，i 天的状态只与 i-1 天的状态有关，所以，i-1 天之前的状态完全不需要存储，我们这里可以使用临时数组优化一下。
 *
 * 注意：不能直接在原 dp 数组上计算，因为 i-1 天的状态会被多次利用，直接覆盖会导致结果不准确。
 */
class Solution_552_DP_II {

    int MOD = 1000000007;

    public int checkRecord(int n) {
        long[][] dp = new long[2][3];
        // 初始值
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            long[][] newDp = new long[2][3];
            newDp[0][0] = (dp[0][0] + dp[0][1] + dp[0][2]) % MOD;
            // 把方法三中间两个一样的状态合并为一行
            newDp[1][0] = (dp[1][0] + dp[1][1] + dp[1][2] + dp[0][0] + dp[0][1] + dp[0][2]) % MOD;
            newDp[0][1] = dp[0][0];
            newDp[0][2] = dp[0][1];
            newDp[1][1] = dp[1][0];
            newDp[1][2] = dp[1][1];

            dp = newDp;
        }

        long ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + dp[i][j]) % MOD;
            }
        }

        return (int) ans;
    }
}
