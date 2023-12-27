package Top_Interview_150.Sliding_Window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class _3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }

        int res = 1;

        //store character and its index
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put(s.charAt(0), 0);

        int leftPointer = 0;
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(hashMap.containsKey(c)) {
                // remove characters from current left pointer to
                int cIndex = hashMap.get(c);
                for(int j = leftPointer; j < cIndex; j++) {
                    hashMap.remove(s.charAt(j));
                }
                //update left pointer of sliding window
                leftPointer = cIndex + 1;
            }

            //update result
            res = Math.max(res, i - leftPointer + 1);

            hashMap.put(s.charAt(i), i);
        }

        return res;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}
