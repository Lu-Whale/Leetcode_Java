package LeetCode75.Hash_Map_Set;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75
public class _1657_Determine_if_Two_Strings_Are_Close {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();

        for(int i = 0; i < word1.length(); i++) {
            if(hashMap1.containsKey(word1.charAt(i))) {
                hashMap1.replace(word1.charAt(i), hashMap1.get(word1.charAt(i)) + 1);
            }else {
                hashMap1.put(word1.charAt(i), 1);
            }
        }
        for(int i = 0; i < word2.length(); i++) {
            if(hashMap2.containsKey(word2.charAt(i))) {
                hashMap2.replace(word2.charAt(i), hashMap2.get(word2.charAt(i)) + 1);
            }else {
                hashMap2.put(word2.charAt(i), 1);
            }
        }

        if(!hashMap1.keySet().equals(hashMap2.keySet())) {
            return false;
        }

        int[] sort1 = new int[hashMap1.keySet().size()];
        int[] sort2 = new int[hashMap2.keySet().size()];

        int tmp = 0;
        for(char c: hashMap1.keySet()) {
            sort1[tmp] = hashMap1.get(c);
            sort2[tmp] = hashMap2.get(c);
            tmp++;
        }

        Arrays.sort(sort1);
        Arrays.sort(sort2);

        return Arrays.equals(sort1, sort2);
    }
}
