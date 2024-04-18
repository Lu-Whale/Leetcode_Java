package Daily_Question;

public class _463_Island_Perimeter {
    int res;
    boolean[][] visit;
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        res = 0;
        visit = new boolean[m][n];
        boolean flag = false;
        for(int i = 0; i < m && !flag; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, m, n);
                    flag = true;
                    break;
                }
            }
        }

        return res;
    }

    public void dfs(int[][] grid, int row, int column, int m, int n) {
        if(row < 0 || row >= m || column < 0 || column >= n) {
            return;
        }
        if(visit[row][column] || grid[row][column] == 0) {
            return;
        }
        visit[row][column] = true;
        int length = 4;
        if(row > 0 && grid[row - 1][column] == 1) length--;
        if(row < m -1 && grid[row + 1][column] == 1) length--;
        if(column > 0 && grid[row][column - 1] == 1) length--;
        if(column < n - 1 && grid[row][column + 1] == 1) length--;
        res += length;

        dfs(grid, row - 1, column, m, n);
        dfs(grid, row + 1, column, m, n);
        dfs(grid, row, column - 1, m, n);
        dfs(grid, row, column + 1, m, n);
    }
}

class Solution_463 {
    public int islandPerimeter(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        int result = 0;

        for (int y = 0; y < height; y++){
            int prev = 0;
            for (int x = 0; x < width; x++){
                int keep = grid[y][x];
                result += prev ^ keep;
                prev = keep;
            }
            result += prev;
        }

        for (int x = 0; x < width; x++){
            int prev = 0;
            for (int y = 0; y < height; y++){
                int keep = grid[y][x];
                result += prev ^ keep;
                prev = keep;
            }
            result += prev;
        }
        return result;
    }
}
