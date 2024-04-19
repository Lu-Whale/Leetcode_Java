package Daily_Question;

public class _200_Number_of_Islands {
    int res;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int row, int column, int m, int n) {
        if(row < 0 || row >= m || column < 0 || column >= n || grid[row][column] == '0') {
            return;
        }

        grid[row][column] = '0';

        dfs(grid, row + 1, column, m, n);
        dfs(grid, row - 1, column, m, n);
        dfs(grid, row, column + 1, m, n);
        dfs(grid, row, column - 1, m, n);
    }
}
