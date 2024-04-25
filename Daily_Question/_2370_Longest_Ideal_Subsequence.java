package Daily_Question;

import java.util.Arrays;
import java.util.HashMap;

public class _2370_Longest_Ideal_Subsequence {
    public int longestIdealString(String s, int k) {
        int res = 1;
        int n = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            for(int j = 0; j <= k; j++) {
                char t1 = (char) (c - j);
                char t2 = (char) (c + j);
                if(hashMap.containsKey(t1)) {
                    dp[i] = Math.max(dp[i], hashMap.get(t1) + 1);
                }
                if(hashMap.containsKey(t2)) {
                    dp[i] = Math.max(dp[i], hashMap.get(t2) + 1);
                }
            }
            hashMap.put(c, dp[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}

class solution {
    public int longestIdealString(String s, int k) {
        // Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[26];
        int res = 0;
        // Arrays.fill(dp, 1);
        for (int i = 0; i < s.length(); i++) {
            //
            int cur = s.charAt(i) - 'a';
            for (int j = 0; j <= k; j++) {
                int t1 = cur - j;
                int t2 = cur + j;
                // in the range of [0, 26)
                if (t1 >= 0 && t1 < 26) dp[cur] = Math.max(dp[cur], dp[t1]);
                if (t2 >= 0 && t2 < 26) dp[cur] = Math.max(dp[cur], dp[t2]);
            }
            // should be updated out of the 'Math.max(dp[cur], dp[t1] + 1)'
            dp[cur]++;
            res = Math.max(res, dp[cur]);
        }
        return res;
    }
}
