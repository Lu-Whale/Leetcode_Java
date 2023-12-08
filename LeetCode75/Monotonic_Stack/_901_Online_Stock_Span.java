package LeetCode75.Monotonic_Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// https://leetcode.com/problems/online-stock-span/description/?envType=study-plan-v2&envId=leetcode-75
public class _901_Online_Stock_Span {

}

class StockSpanner {

    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            int[] day = stack.pop();
            span += day[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }
}