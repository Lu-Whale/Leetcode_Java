package LeetCode75.Stack;

import java.util.Stack;

//https://leetcode.com/problems/removing-stars-from-a-string/?envType=study-plan-v2&envId=leetcode-75
public class _2390_RemovingStarsFromaString {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '*') {
                stack.add(s.charAt(i));
            }else{
                stack.pop();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(char c: stack) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

}
