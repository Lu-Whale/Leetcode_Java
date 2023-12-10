package LeetCode75.Graphs_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class _1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {
    public int minReorder(int n, int[][] connections) {
        //store the list of all cities
        //for each city, there is a list of all roads that are connect to this city
        //for the road, it is a size-2 int array, where first element represents the another city connected to,
        //and the second element represents the weight of this road, in this situation, it is the direction of the road.
        List<List<int[]>> e = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            e.add(i, new ArrayList<>());
        }
        for(int[] edge : connections) {
            e.get(edge[0]).add(new int[]{edge[1], 1});
            e.get(edge[1]).add(new int[]{edge[0], 0});
        }
        return dfs(0, -1, e);
    }

    public int dfs(int x, int parent, List<List<int[]>> e) {
        int res = 0;
        for(int[] edge : e.get(x)) {
            if(edge[0] == parent) {
                continue;
            }
            res += edge[1] + dfs(edge[0], x, e);
        }
        return res;
    }
}
