package Problem_List;

public class _695_Max_Area_of_Island {
    int curArea = 0;
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == 1) {
                    curArea = 0;
                    dfs(i, j, grid, m, n);
                    res = Math.max(res, curArea);
                }
            }
        }
        return res;
    }

    public void dfs(int row, int col, int[][] grid, int m, int n) {
        if(row >= m || row < 0 || col >= n || col < 0 || visited[row][col] || grid[row][col] == 0) {
            return;
        }

        curArea++;
        visited[row][col] = true;

        dfs(row + 1, col, grid, m, n);
        dfs(row - 1, col, grid, m, n);
        dfs(row, col + 1, grid, m, n);
        dfs(row, col - 1, grid, m, n);
    }
}
