package LeetCode75.Array_String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
public class _345_Reverse_Vowels_of_a_String {
    public static String reverseVowels(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add('a');
        hashSet.add('e');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('u');
        hashSet.add('A');
        hashSet.add('E');
        hashSet.add('I');
        hashSet.add('O');
        hashSet.add('U');

        // add all vowels into stack
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(hashSet.contains(s.charAt(i))) {
                stack.add(s.charAt(i));
            }
        }

        //generate result string
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!hashSet.contains(s.charAt(i))) {
                stringBuilder.append(s.charAt(i));
            }else {
                stringBuilder.append(stack.pop().toString());
            }
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "hEllo";

        reverseVowels(s);
    }
}
