package Problem_List;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _630_Course_Schedule_III {
    public int scheduleCourse(int[][] courses) {
        int res = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(int[] course : courses) {
            if(course[0] <= course[1]) {
                priorityQueue.offer(course);
            }
        }

        int currentDay = 0;
        while (!priorityQueue.isEmpty()) {
            int[] course = priorityQueue.poll();
            if(currentDay + course[0] <= course[1]) {
                res++;
                currentDay += course[0];
            }
        }

        return res;
    }
}

class solution_630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int curDay = 0;
        for(int[] course : courses) {
            if(curDay + course[0] <= course[1]) {
                curDay += course[0];
                priorityQueue.offer(course);
            }else {
                if(!priorityQueue.isEmpty() && priorityQueue.peek()[0] > course[0] ) {
//                    if((curDay - priorityQueue.peek()[0] + course[0]) <= course[1]) {
//                        curDay = curDay - priorityQueue.poll()[0] + course[0];
//                        priorityQueue.offer(course);
//                    }
                    curDay = curDay - priorityQueue.poll()[0] + course[0];
                    priorityQueue.offer(course);
                }
            }
        }

        return priorityQueue.size();
    }
}
