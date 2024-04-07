package Daily_Question;

import java.util.Stack;

public class _678_Valid_Parenthesis_String {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> leftParenthesis = new Stack<>();
        Stack<Integer> asterisk = new Stack<>();
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                leftParenthesis.push(i);
            }else if(c == '*') {
                asterisk.push(i);
            }else if(c == ')') {
                if(!leftParenthesis.isEmpty()) {
                    leftParenthesis.pop();
                }else if(!asterisk.isEmpty()) {
                    asterisk.pop();
                }else {
                    return false;
                }
            }
        }

        while (!leftParenthesis.isEmpty() && !asterisk.isEmpty()) {
            if(leftParenthesis.pop() > asterisk.pop()) {
                return false;
            }
        }

        return leftParenthesis.isEmpty();
    }
}

class Solution_678_greedy {
    public boolean checkValidString(String s) {
        int minCount = 0, maxCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                minCount++;
                maxCount++;
            } else if (c == ')') {
                minCount = Math.max(minCount - 1, 0);
                maxCount--;
                if (maxCount < 0) {
                    return false;
                }
            } else {
                minCount = Math.max(minCount - 1, 0);
                maxCount++;
            }
        }
        return minCount == 0;
    }
}