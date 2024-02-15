package Top_Interview_150.Stack;

import java.util.Deque;
import java.util.LinkedList;

public class _20_Valid_Parentheses {
    public static boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for(char bracket : s.toCharArray()) {
            if(bracket == '(' || bracket == '[' || bracket == '{') {
                deque.offerLast(bracket);
            }else {
                if(deque.isEmpty()) {
                    return false;
                }
                char left = deque.pollLast();
                switch (left) {
                    case '(':
                        if(bracket != ')') {
                            return false;
                        }
                        break;
                    case '[':
                        if(bracket != ']') {
                            return false;
                        }
                        break;
                    case '{':
                        if(bracket != '}') {
                            return false;
                        }
                        break;
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        isValid(s);
    }
}
