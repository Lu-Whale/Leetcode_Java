package LeetCode75.Two_Pointer;

// Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
//
// A subsequence of a string is a new string that is formed from the original string by
// deleting some (can be none) of the characters without disturbing the relative positions
// of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
//
// Example 1:
//
//Input: s = "abc", t = "ahbgdc"
//Output: true
//Example 2:
//
//Input: s = "axc", t = "ahbgdc"
//Output: false
public class Is_Subsequence_392 {
    public boolean mySolution(String s, String t) {

        int pointer = 0;
        for(int i = 0; i < s.length(); i++) {
            boolean tmp = false;
            for(int j = pointer; j < t.length(); j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    tmp = true;
                    pointer = j + 1;
                    break;
                }
            }
            if(!tmp) {
                return false;
            }
        }

        return true;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }


}
