package Daily_Question;

import java.util.HashMap;

public class _1915_Number_of_Wonderful_Substrings {
    public static long wonderfulSubstrings(String word) {
        long res = 0;
        int n = word.length();

        for(int i = 0; i < n; i++) {
            long countOdd = 0;
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for(int j = i; j < n; j++) {
                char c = word.charAt(j);
                hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
                countOdd = hashMap.get(c) % 2 == 0 ? countOdd - 1 : countOdd + 1;
                if(countOdd <= 1) res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String word = "aba";
        wonderfulSubstrings(word);
    }
}

class Solution_1915 {
    public long wonderfulSubstrings(String word) {
        int[] cnt = new int[1024];
        cnt[0] = 1; // 初始前缀和为 0，需将其计入出现次数
        long ans = 0L;
        for (int i = 0, sum = 0; i < word.length(); ++i) {
            sum ^= 1 << (word.charAt(i) - 'a'); // 计算当前前缀和
            ans += cnt[sum]; // 所有字母均出现偶数次
            for (int j = 1; j < 1024; j <<= 1) // 枚举其中一个字母出现奇数次
                ans += cnt[sum ^ j]; // 反转该字母的出现次数的奇偶性
            ++cnt[sum]; // 更新前缀和出现次数
        }
        return ans;
    }
}
