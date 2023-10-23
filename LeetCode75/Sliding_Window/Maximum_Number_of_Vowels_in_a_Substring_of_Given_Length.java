package LeetCode75.Sliding_Window;

//Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
//
//Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
//
//
//
//Example 1:
//
//Input: s = "abciiidef", k = 3
//Output: 3
//Explanation: The substring "iii" contains 3 vowel letters.
//Example 2:
//
//Input: s = "aeiou", k = 2
//Output: 2
//Explanation: Any substring of length 2 contains 2 vowels.
//Example 3:
//
//Input: s = "leetcode", k = 3
//Output: 2
//Explanation: "lee", "eet" and "ode" contain 2 vowels.

import java.util.HashSet;
import java.util.Set;

public class Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {
    public int mySolution(String s, int k) {
        HashSet<Character> vowel = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));

        int count = 0;
        for(int i = 0; i < k; i++) {
            count = vowel.contains(s.charAt(i)) ? count + 1 : count;
        }
        if(count == k) return count;

        int maxCount = count;
        for(int i = k; i < s.length(); i++) {

            if(vowel.contains(s.charAt(i)) && !vowel.contains(s.charAt(i-k))) {
                count++;
                if(count == k) return count;
                if(maxCount < count) maxCount = count;
            }

            if(!vowel.contains(s.charAt(i)) && vowel.contains(s.charAt(i-k))) {
                count--;
            }

        }

        return maxCount;
    }

    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));

        int count = 0, maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                count++;
            }

            // If our window becomes larger than k, we decrement the count if the char at
            // the beginning of the window is a vowel
            if (i >= k && vowels.contains(s.charAt(i - k))) {
                count--;
            }

            if (i >= k - 1) {
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }
}



















