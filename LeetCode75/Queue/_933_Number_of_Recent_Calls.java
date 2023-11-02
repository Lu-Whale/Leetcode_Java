package LeetCode75.Queue;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-recent-calls/?envType=study-plan-v2&envId=leetcode-75
class RecentCounter {
    Queue<Integer> counter;

    public RecentCounter() {
        counter = new LinkedList<>();
    }

    public int ping(int t) {
        counter.add(t);

        while ( t-3000 > counter.peek()) {
            counter.poll();
        }

        return counter.size();
    }
}

