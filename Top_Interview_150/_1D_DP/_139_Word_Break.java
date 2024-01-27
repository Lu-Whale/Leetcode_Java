package Top_Interview_150._1D_DP;

import java.util.*;

public class _139_Word_Break {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> hashSet = new HashSet<>(wordDict);
        Queue<Integer> indexes = new LinkedList<>();
        indexes.add(n);
        for(int i = n - 1; i >= 0; i--) {
            for(int end : indexes) {
                String tmp = s.substring(i, end);
                if(hashSet.contains(tmp)) {
                    indexes.add(i);
                    break;
                }
            }
        }
        return indexes.contains(0);
    }

    public static void main(String[] args){
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordBreak(s, wordDict);
    }
}

//https://leetcode.cn/problems/word-break/solutions/302471/dan-ci-chai-fen-by-leetcode-solution/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}


