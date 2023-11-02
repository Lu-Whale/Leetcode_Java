package LeetCode75.Array_String;

import java.util.Stack;

// https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
public class _151_Reverse_Words_in_a_String {
    public static String reverseWords(String s) {
        //create a stack
        Stack<String> stack = new Stack<>();

        //find the words
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                stringBuilder.append(s.charAt(i));
            }else {
                if(stringBuilder.length() != 0 ) {
                    //add word to stack
                    stack.add(stringBuilder.toString());
                    //Empty the stringBuilder
                    stringBuilder.setLength(0);
                }
            }
            //final check if stringBuilder contains word
            if(i == s.length()-1 && stringBuilder.length() != 0) {
                stack.add(stringBuilder.toString());
            }
        }

        // output the result
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.append(stack.pop()).append(" ");
        }
        //Don't forget to delete the last space
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    public static void main(String[] args) {

        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }
}
