package Daily_Question;

import java.util.*;

public class _310_Minimum_Height_Trees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> adjacency = new HashMap<>();
        for(int i = 0; i < n; i++) {
            adjacency.put(i, new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjacency.get(edge[0]).add(edge[1]);
            adjacency.get(edge[1]).add(edge[0]);
        }
        int minHeight = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];
            queue.offer(i);
            visited[i] = true;
            int height = 1;
            while (!queue.isEmpty()) {
                ++height;
                int size = queue.size();
                for(int j = 0; j < size; j++) {
                    int u = queue.poll();
                    visited[u] = true;
                    for(int v : adjacency.get(u)) {
                        if(!visited[v]) queue.offer(v);
                    }
                }
            }
            if(height < minHeight) {
                minHeight = height;
                res = new ArrayList<>();
                res.add(i);
            }else if(height == minHeight) {
                res.add(i);
            }
        }

        return res;
    }
}

class Solution_310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<Integer>();
        if (n == 1) {
            ans.add(0);
            return ans;
        }
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        /* 找到与节点 0 最远的节点 x */
        int x = findLongestNode(0, parent, adj);
        /* 找到与节点 x 最远的节点 y */
        int y = findLongestNode(x, parent, adj);
        /* 求出节点 x 到节点 y 的路径 */
        List<Integer> path = new ArrayList<Integer>();
        parent[x] = -1;
        while (y != -1) {
            path.add(y);
            y = parent[y];
        }
        int m = path.size();
        if (m % 2 == 0) {
            ans.add(path.get(m / 2 - 1));
        }
        ans.add(path.get(m / 2));
        return ans;
    }

    public int findLongestNode(int u, int[] parent, List<Integer>[] adj) {
        int n = adj.length;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        boolean[] visit = new boolean[n];
        queue.offer(u);
        visit[u] = true;
        int node = -1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            node = curr;
            for (int v : adj[curr]) {
                if (!visit[v]) {
                    visit[v] = true;
                    parent[v] = curr;
                    queue.offer(v);
                }
            }
        }
        return node;
    }
}