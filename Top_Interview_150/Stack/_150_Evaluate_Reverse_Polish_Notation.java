package Top_Interview_150.Stack;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/?envType=study-plan-v2&envId=top-interview-150
public class _150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> number = new Stack<>();
        for(String s : tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                calculate(number, s);
            }else {
                number.push(Integer.parseInt(s));
            }
        }
        return number.peek();
    }

    public void calculate(Stack<Integer> number, String operator) {
        if(number.size() < 2) {
            return;
        }
        int a = number.pop();
        int b = number.pop();
        switch (operator) {
            case "+":
                number.push(b + a);
                break;
            case "-":
                number.push(b - a);
                break;
            case "*":
                number.push(b * a);
                break;
            case "/":
                number.push(b / a);
                break;
        }
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
//        evalRPN(tokens);
    }
}
