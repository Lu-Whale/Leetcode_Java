package Daily_Question;

import java.util.*;

public class _1971_Find_if_Path_Exists_in_Graph {
    int[] parent;
    int[] rank;

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

        return isConnected(source, destination);
    }
//    public int find(int p) {
//        while (p != parent[p]) {
//            parent[p] = parent[parent[p]];
//            p = parent[p];
//        }
//        return p;
//    }

    // find the root of node p
    private int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]); // Path compression
        }
        return parent[p];
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rank[p] < rank[q]) {
            parent[rootP] = rootQ;
        }else if(rank[p] > rank[q]) {
            parent[rootQ] = rootP;
        }else {
            parent[rootQ] = rootP;
            rank[rootP] += 1;
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
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