package Top_Interview_150.Graph_General;

import java.util.*;

public class _210_Course_Schedule_II {

    HashMap<Integer, List<Integer>> adjacency;
    int[] flags;
    Stack<Integer> stack;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        adjacency = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            adjacency.put(i, new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            adjacency.get(edge[1]).add(edge[0]);
        }

        flags = new int[numCourses];
        stack = new Stack<>();
        for(int u = 0; u < numCourses; u++) {
            if(!dfs(u)) return new int[0];
        }

        int[] res = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            res[i] = stack.pop();
        }

        return res;
    }

    public boolean dfs(int u) {
        if(flags[u] == 1) return false;
        if(flags[u] == -1) return true;

        flags[u] = 1;
        for(int v : adjacency.get(u)) {
            if(!dfs(v)) return false;
        }
        stack.push(u);
        flags[u] = -1;

        return true;
    }
}

class solution_210_BFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] topologicalSort = new int[numCourses];

        HashMap<Integer, List<Integer>> adjacency = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            adjacency.put(i, new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            inDegrees[edge[0]]++;
            adjacency.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegrees[i] == 0) queue.offer(i);
        }

        int index = 0;
        int courses = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topologicalSort[index++] = u;
            courses++;
            for(int v : adjacency.get(u)) {
                if(--inDegrees[v] == 0) queue.offer(v);
            }
        }

        return courses == numCourses ? topologicalSort : new int[0];
    }
}
