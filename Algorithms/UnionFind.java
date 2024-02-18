package Algorithms;

public class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ) return;

        if(rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        }else if(rank[rootP] > rank[rootQ]) {
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
