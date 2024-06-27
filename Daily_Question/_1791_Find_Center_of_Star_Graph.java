package Daily_Question;

public class _1791_Find_Center_of_Star_Graph {
    public int findCenter(int[][] edges) {
        // 只需检查前两条边
        int u = edges[0][0], v = edges[0][1];
        int x = edges[1][0], y = edges[1][1];

        // 中心节点必定是两边都有的节点
        if (u == x || u == y) return u;
        return v;
    }
}
