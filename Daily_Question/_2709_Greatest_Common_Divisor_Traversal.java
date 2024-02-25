package Daily_Question;

import java.util.Map;

// 2.25
public class _2709_Greatest_Common_Divisor_Traversal {

    public boolean canTraverseAllPairs(int[] nums) {
        if(nums.length == 1) return true;

        int max = 0;
        for(int num : nums) {
            if(num == 1) return false;
            max = Math.max(num, max);
        }
        UnionFind unionFind = new UnionFind(max + 1);

        for(int num : nums) {
            for(int i = 2; i * i <= num; i++) {
                if(num % i == 0) {
                    unionFind.union(num, i);
                    unionFind.union(num, num / i);
                }
            }
        }

        int root = unionFind.find(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            if(unionFind.find(nums[i]) != root) return false;
        }

        return true;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
    }

    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            if(rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            }else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
