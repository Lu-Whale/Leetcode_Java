package Daily_Question;

import java.util.HashMap;

public class _409_Longest_Palindrome {
    public int longestPalindrome(String s) {
        int n = s.length(), res = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        boolean flag = false;
        for(int val : hashMap.values()) {
            if(val % 2 == 0) {
                res += val;
            }else {
                flag = true;
                res += (val - 1);
            }
        }
        return flag ? res + 1 : res;
    }

}

class Solution_409 {
    public int longestPalindrome(String s) {
        int res = 0;

        int[] nums = new int[58];
        for(char c : s.toCharArray()) {
            nums[c - 'A']++;
        }

        boolean flag = false;
        for(int num : nums) {
            if(num % 2 == 0) {
                res += num;
            }else {
                res += num - 1;
                flag = true;
            }
        }
        return flag ? res + 1 : res;
    }
}
