package Previous.ByteDance;

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串3 {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() == 0) {
                return 0;
            }
            int result = 1;
            int pointer1 = 0;

            for(int pointer2 = 1; pointer2 < s.length(); pointer2 ++) {
                for(int j = pointer1; j < pointer2; j++) {
                    if(s.charAt(j) == s.charAt(pointer2)) {
                        if(result < pointer2 - pointer1) {
                            result = pointer2 - pointer1;
                        }
                        pointer1 = j + 1;
                        break;
                    }

                }
            }
            // 检查最后一个子串的长度
            if (result < s.length() - pointer1) {
                result = s.length() - pointer1;
            }

            return result;
        }
    }
    class SolutionMap {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            int result = 0;
            int pointer1 = 0;
            Map<Character, Integer> charIndexMap = new HashMap<>();

            for (int pointer2 = 0; pointer2 < s.length(); pointer2++) {
                char c = s.charAt(pointer2);
                if (charIndexMap.containsKey(c)) {
                    pointer1 = Math.max(pointer1, charIndexMap.get(c) + 1);
                }
                charIndexMap.put(c, pointer2);
                result = Math.max(result, pointer2 - pointer1 + 1);
            }

            return result;
        }
    }
}

