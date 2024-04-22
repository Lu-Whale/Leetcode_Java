package Daily_Question;

import java.util.*;

public class _1971_Find_if_Path_Exists_in_Graph {
    int parent[];
    int rank[];
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for(int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        return find(source) == find(destination);

    }
    // Path compression
    public int find(int p) {
        if(p != parent[p]) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        }else if(rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        }else {
            parent[rootP] = rootQ;
            rank[rootQ] += 1;
        }
    }
}


class Solution_BFS {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            hashMap.put(i, new ArrayList<>());
        }
        for(int[] edge : edges) {
            hashMap.get(edge[0]).add(edge[1]);
            hashMap.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n];
        queue.add(source);
        visit[source] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int u = queue.poll();
                if(u == destination) return true;
                visit[u] = true;
                for(int v : hashMap.get(u)) {
                    if(v == destination) return true;
                    if(!visit[v]) queue.offer(v);
                }
            }
        }

        return false;
    }
}