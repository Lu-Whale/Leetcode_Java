package Daily_Question;

import java.util.ArrayList;
import java.util.List;

public class _2812_Find_the_Safest_Path_in_a_Grid {
    int n, res;
    List<int[]> thieves;
    boolean[][] visited;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        n = grid.size();
        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) {
            return 0;
        }

        visited = new boolean[n][n];
        thieves = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1) {
                    thieves.add(new int[]{i, j});
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

        for(int[] thief : thieves) {
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

class Solution_2812 {
    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        ArrayList<int[]> q = new ArrayList<int[]>();
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) > 0) {
                    q.add(new int[]{i, j});
                } else {
                    dis[i][j] = -1;
                }
            }
        }

        ArrayList<List<int[]>> groups = new ArrayList<List<int[]>>();
        groups.add(q);
        while (!q.isEmpty()) { // 多源 BFS
            ArrayList<int[]> tmp = q;
            q = new ArrayList<>();
            for (int[] p : tmp) {
                for (int[] d : DIRS) {
                    int x = p[0] + d[0], y = p[1] + d[1];
                    if (0 <= x && x < n && 0 <= y && y < n && dis[x][y] < 0) {
                        q.add(new int[]{x, y});
                        dis[x][y] = groups.size();
                    }
                }
            }
            groups.add(q); // 相同 dis 分组记录
        }

        // 并查集
        fa = new int[n * n];
        for (int i = 0; i < n * n; i++)
            fa[i] = i;

        for (int ans = groups.size() - 2; ans > 0; ans--) {
            List<int[]> g = groups.get(ans);
            for (int[] p : groups.get(ans)) {
                int i = p[0], j = p[1];
                for (int[] d : DIRS) {
                    int x = i + d[0], y = j + d[1];
                    if (0 <= x && x < n && 0 <= y && y < n && dis[x][y] >= dis[i][j])
                        fa[find(x * n + y)] = find(i * n + j);
                }
            }
            if (find(0) == find(n * n - 1)) // 写这里判断更快些
                return ans;
        }
        return 0;
    }

    // 并查集模板
    private int[] fa;

    private int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }
}