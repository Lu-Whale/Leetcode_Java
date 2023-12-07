package LeetCode75.Monotonic_Stack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class _739_Daily_Temperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for(int i = 0; i < n; i++) {
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] < temperatures[i]) {
                int[] day = priorityQueue.poll();
                answer[day[1]] = i - day[1];
            }

            priorityQueue.offer(new int[]{temperatures[i], i});
        }

        return answer;
    }

    // use stack instead of priorityQueue

    // For example, the stack will work like this:
    // {77} -> push 77
    // {77, 74} -> push 74
    // {77, 74, 73} -> push 73
    // {77, 74} -> temperature of current day is 76, pop 73
    // {77} -> pop 74
    // {77, 76} -> 77 is larger than 76, stop pop, push 76
    public int[] dailyTemperaturesStack(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            // since everytime we will pop all the days which temperatures are smaller than current day,
            // so the stack will keep monotonic
            stack.push(i);
        }

        return answer;
    }



}
