package LeetCode75.Array_String;

// You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
// starting with word1. If a string is longer than the other, append the additional letters onto the
// end of the merged string.

public class Merge_Strings_Alternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder stringBuilder = new StringBuilder();
        int l1 = word1.length();
        int l2 = word2.length();

        if(l1 < l2) {
            for(int i = 0; i < l2; i++) {
                if(i < l1) {
                    stringBuilder.append(word1.charAt(i));
                }
                stringBuilder.append(word2.charAt(i));
            }
        }else {
            for(int i = 0; i < l1; i++) {
                stringBuilder.append(word1.charAt(i));
                if(i < l2) {
                    stringBuilder.append(word2.charAt(i));
                }
            }
        }
        return stringBuilder.toString();
    }
}
