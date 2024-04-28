package Daily_Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _834_Sum_of_Distances_in_Tree {
    List<List<Integer>> g;
    int[] res;
    int[] size;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        g = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for(int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        res = new int[n];
        size = new int[n];
        dfs(0, -1, 0);
        reRoot(0, -1);

        return res;
    }

    public void dfs(int u, int fa, int depth) {
        res[0] += depth;
        size[u] = 1;
        for(int v : g.get(u)) {
            if(v != fa) {
                dfs(v, u, depth + 1);
                size[u] += size[v];
            }
        }
    }

    public void reRoot(int u, int fa) {
        for(int v : g.get(u)) {
            if(v != fa) {
                res[v] = res[u] + g.size() - 2 * size[v];
                reRoot(v, u);
            }
        }
    }
}
