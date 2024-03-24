package Contest;

import java.util.HashMap;

public class _3090_Maximum_Length_Substring_With_Two_Occurrences {
    public int maximumLengthSubstring(String s) {
        int res = 2;
        //sliding window
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            hashMap.put(r, hashMap.getOrDefault(r, 0) + 1);
            while (left < right && hashMap.get(r) > 2) {
                char l = s.charAt(left++);
                hashMap.put(l, hashMap.get(l) - 1);
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
