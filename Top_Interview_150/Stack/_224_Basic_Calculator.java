package Top_Interview_150.Stack;

import java.util.Stack;

public class _224_Basic_Calculator {
    public static int calculate(String s) {
        Stack<Boolean> positives = new Stack<>();
        positives.push(true);
        StringBuilder sb = new StringBuilder();
        boolean status = true;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                sb.append(c);
            }
            if(c == '+') {
                status = positives.peek();
                if(status) {
                    sb.append('+');
                }else {
                    sb.append('-');
                }
            }
            if(c == '-') {
                status = !positives.peek();
                if(status) {
                    sb.append('+');
                }else {
                    sb.append('-');
                }
            }
            if(c == '(') {
                positives.push(status);
            }
            if(c == ')') {
                positives.pop();
            }
        }

        int res = 0;
        int i = 0;
        int temp = 0;
        while (i < sb.length() && Character.isDigit(sb.charAt(i))){
            temp = temp * 10 + (sb.charAt(i++) - '0');
        }
        boolean plus = true;
        while (i < sb.length()){
            char c = sb.charAt(i++);
            if(Character.isDigit(c)) {
                temp = temp * 10 + (c - '0');
            }else {
                res = plus ? res + temp : res - temp;
                temp = 0;
                plus = c == '+';
            }
        }
        res = plus ? res + temp : res - temp;

        return res;
    }

    public static void main(String[] args) {
        String s = "0";
        System.out.println(calculate(s));
    }
}
