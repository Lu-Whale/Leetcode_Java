package Daily_Question;

import java.util.ArrayList;
import java.util.List;

public class _2812_Find_the_Safest_Path_in_a_Grid {
    int n, res;
    List<int[]> thiefs;
    boolean[][] visited;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) {
            return 0;
        }

        visited = new boolean[n][n];
        thiefs = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1) {
                    thiefs.add(new int[]{i, j});
                }
            }
        }

        res = 0;
        dfs(grid, 0, 0, Integer.MAX_VALUE);
        return res;
    }

    public void dfs(List<List<Integer>> grid, int row, int col, int distance) {
        if(row < 0 || row >= n || col < 0 || col >= n || visited[row][col]) {
            return;
        }

        for(int[] thief : thiefs) {
            distance = Math.min(distance, Math.abs(row - thief[0]) + Math.abs(col - thief[1]));
        }

        visited[row][col] = true;
        if(row == n-1 && col == n-1) {
            res = Math.max(distance, res);
            visited[row][col] = false;
            return;
        }

        dfs(grid, row + 1, col, distance);
        dfs(grid, row, col + 1, distance);
        dfs(grid, row - 1, col, distance);
        dfs(grid, row, col - 1, distance);

        visited[row][col] = false;
    }
}
