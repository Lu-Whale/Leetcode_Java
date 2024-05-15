package Daily_Question;

public class _1219_Path_with_Maximum_Gold {
    int max, m, n, gold;
    boolean[][] visited;

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        max = 0;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    gold = 0;
                    dfs(grid, i, j);
                }
            }
        }

        return max;
    }

    public void dfs(int[][] grid, int row, int colum) {
        if(row < 0 || row >= m || colum < 0 || colum >= n) {
            return;
        }
        if(visited[row][colum] || grid[row][colum] == 0) {
            return;
        }

        visited[row][colum] = true;
        gold += grid[row][colum];
        max = Math.max(max, gold);

        dfs(grid, row + 1, colum);
        dfs(grid, row - 1, colum);
        dfs(grid, row, colum + 1);
        dfs(grid, row, colum - 1);

        gold -= grid[row][colum];
        visited[row][colum] = false;
    }
}
