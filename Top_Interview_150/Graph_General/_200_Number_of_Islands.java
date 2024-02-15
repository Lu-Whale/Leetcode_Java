package Top_Interview_150.Graph_General;

// https://leetcode.com/problems/number-of-islands/?envType=study-plan-v2&envId=top-interview-150
public class _200_Number_of_Islands {
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }

    public void dfs(char[][] grid, int row, int column) {
        if(row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return;
        }
        if(grid[row][column] == '0' || visited[row][column]) {
            return;
        }

        visited[row][column] = true;

        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }
}
