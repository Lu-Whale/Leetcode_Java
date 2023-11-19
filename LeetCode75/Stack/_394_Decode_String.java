package LeetCode75.Stack;

import java.util.Stack;

// https://leetcode.com/problems/decode-string/description/?envType=study-plan-v2&envId=leetcode-75
public class _394_Decode_String {
    public String decodeString(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        Stack<Integer> k = new Stack<>();
        Stack<String> encoded_string = new Stack<>();

        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '[') {
                k.add(count);
                count = 0;
                encoded_string.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }else if(s.charAt(i) == ']') {
                StringBuilder tmpString = new StringBuilder();
                int currentK = k.pop();
                for(int j = 0; j < currentK; j++) {
                    tmpString.append(stringBuilder);
                }
                stringBuilder = new StringBuilder(encoded_string.pop() + tmpString);
            }else if(Character.isDigit(s.charAt(i))) {
                count = count * 10 + Integer.parseInt(s.charAt(i) + "");
            }else {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }


    public static void main(String[] args) {

    }

}
