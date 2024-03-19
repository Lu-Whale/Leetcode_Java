package Daily_Question;

import java.util.*;

public class _621_Task_Scheduler {
    public static int leastInterval(char[] tasks, int n) {
        // key -> task ; value -> count
        HashMap<Character, Integer> taskHash = new HashMap<>();
        for(char c : tasks) {
            taskHash.put(c, taskHash.getOrDefault(c, 0) + 1);
        }

        // key - > task, value -> lastAppearedIndex
        HashMap<Character, Integer> indexHash = new HashMap<>();
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a, b) -> {
            int aCount = taskHash.get(a), bCount = taskHash.get(b);
            int aIndex = indexHash.get(a), bIndex = indexHash.get(b);
            if(aCount != bCount) {
                return bCount - aCount;
            }else {
                return aIndex - bIndex;
            }
        });
        for (char task : taskHash.keySet()) {
            indexHash.put(task, -1);
            priorityQueue.offer(task);
        }

        int res = 0;
        while (!priorityQueue.isEmpty()) {
            int index = indexHash.get(priorityQueue.peek());
            if (index == -1 || res - index > n) {
                char task = priorityQueue.poll();
                int count = taskHash.get(task) - 1;
                if (count > 0) {
                    taskHash.put(task, count);
                    indexHash.put(task, res);
                    priorityQueue.offer(task);
                }
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        char[] task = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 1;
        leastInterval(task, n);
    }
}

class Solution_621_fromLeetcode {
    public int leastInterval(char[] tasks, int n) {
        //统计每个任务出现的次数，找到出现次数最多的任务
        int[] hash = new int[26];
        for(int i = 0; i < tasks.length; ++i) {
            hash[tasks[i] - 'A'] += 1;
        }
        Arrays.sort(hash);
        //因为相同元素必须有n个冷却时间，假设A出现3次，n = 2，任务要执行完，至少形成AXX AXX A序列（X看作预占位置）
        //该序列长度为
        int minLen = (n+1) *  (hash[25] - 1) + 1;

        //此时为了尽量利用X所预占的空间（贪心）使得整个执行序列长度尽量小，将剩余任务往X预占的空间插入
        //剩余的任务次数有两种情况：
        //1.与A出现次数相同，比如B任务最优插入结果是ABX ABX AB，中间还剩两个空位，当前序列长度+1
        //2.比A出现次数少，若还有X，则按序插入X位置，比如C出现两次，形成ABC ABC AB的序列
        //直到X预占位置还没插满，剩余元素逐个放入X位置就满足冷却时间至少为n
        for(int i = 24; i >= 0; --i){
            if(hash[i] == hash[25]) ++ minLen;
        }
        //当所有X预占的位置插满了怎么办？
        //在任意插满区间（这里是ABC）后面按序插入剩余元素，比如ABCD ABCD发现D之间距离至少为n+1，肯定满足冷却条件
        //因此，当X预占位置能插满时，最短序列长度就是task.length，不能插满则取最少预占序列长度
        return Math.max(minLen, tasks.length);
    }
}

class Solution_621 {
    public int leastInterval(char[] tasks, int n) {
        int maxCount = 0;
        HashMap<Character, Integer> taskHash = new HashMap<>();
        for(char c : tasks) {
            taskHash.put(c, taskHash.getOrDefault(c, 0) + 1);
            maxCount = Math.max(taskHash.get(c), maxCount);
        }

        int minLen = (n+1) * (maxCount - 1) + 1;
        for(int value : taskHash.values()){
            if(value == maxCount) minLen++;
        }

        return Math.max(--minLen, tasks.length);
    }
}