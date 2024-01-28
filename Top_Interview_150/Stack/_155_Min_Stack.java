package Top_Interview_150.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/min-stack/description/?envType=study-plan-v2&envId=top-interview-150
public class _155_Min_Stack {

}

class MinStack {

    private Stack<Integer> list;
    private Stack<Integer> minList;

    public MinStack() {
        list = new Stack<>();
        minList = new Stack<>();
        minList.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        list.push(val);
        minList.push(Math.min(val, minList.peek()));
    }

    public void pop() {
        if(list.size() > 0) {
            list.pop();
            minList.pop();
        }
    }

    public int top() {
        return list.peek();
    }

    public int getMin() {
        return minList.peek();
    }
}
