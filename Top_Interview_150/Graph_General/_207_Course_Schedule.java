package Top_Interview_150.Graph_General;

import java.util.*;

public class _207_Course_Schedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjacency = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            adjacency.put(i, new ArrayList<>());
        }
        int[] flags = new int[numCourses];

        for(int[] edge : prerequisites) {
            adjacency.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, flags, adjacency)) return false;
        }

        return true;
    }

    public boolean dfs(int i, int[] flags , HashMap<Integer, List<Integer>> adjacency) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for(int j : adjacency.get(i)) {
            if(!dfs(j, flags, adjacency)) return false;
        }
        flags[i] = -1;
        return true;
    }
}

class solution_207_DFS{
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];

        for(int[] edge : prerequisites) {
            edges.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i < numCourses && valid; i++) {
            if(visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {

        visited[u] = 1;
        for(int v : edges.get(u)) {
            if(visited[v] == 0) {
                dfs(v);
                if(!valid) return;
            }else if(visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = -1;
    }
}

class solution_207_BFS {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // get the inDegrees and adjacency of every course
        for(int[] edge : prerequisites) {
            inDegrees[edge[0]]++;
            adjacency.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        // get all the courses with the inDegrees of 0
        for(int i = 0; i < numCourses; i++) {
            if(inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        // BFS Topological sort
        while (!queue.isEmpty()) {
            int u = queue.poll();
            numCourses--;
            for(int v : adjacency.get(u)) {
                inDegrees[v]--;
                if(inDegrees[v] == 0) {
                    queue.add(v);
                }
            }
        }

        return numCourses == 0;
    }

}

