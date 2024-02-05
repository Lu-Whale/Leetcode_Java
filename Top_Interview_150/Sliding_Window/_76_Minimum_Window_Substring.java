package Top_Interview_150.Sliding_Window;

import java.util.HashMap;

public class _76_Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        String res = "";
        int sLen = s.length();
        int tLen = t.length();

        HashMap<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int num = 0; // used to count how many characters in string t are in the current window
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        for(int right = 0; right < sLen; right++) {
            // handling right pointer
            char rightKey = s.charAt(right);
            if(tMap.containsKey(rightKey)) {
                int rightValue = tMap.get(rightKey);
                // we only count valid character into 'num'
                // which means if a character has already appeared more than it has in string t,
                // then we consider it an invalid character and do not count it
                if(rightValue > 0) {
                    num++;
                }
                tMap.put(rightKey, rightValue - 1);
            }

            // based on previous logic, if num equals to the length of t,
            // then the window must be contained all characters in string t

            // move left pointer
            while (left < right && num >= tLen) {
                char leftKey = s.charAt(left);
                if(tMap.containsKey(leftKey)) {
                    int leftValue = tMap.get(leftKey);
                    if(leftValue >= 0) {
                        break;
                    }else {
                        tMap.put(leftKey, leftValue + 1);
                    }
                }
                left++;
            }

            // update result
            int curLength = right - left + 1;
            if(num >= tLen && curLength < minLength) {
                res = s.substring(left, right + 1);
                minLength = curLength;
            }
        }

        return res;
    }
}
