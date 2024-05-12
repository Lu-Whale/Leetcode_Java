package Daily_Question;

public class _2373_Largest_Local_Values_in_a_Matrix {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n-2][n-2];
        for(int i = 0; i < n-2; i++) {
            for(int j = 0; j < n-2; j++) {
                res[i][j] = checkMax(grid, i, j);
            }
        }
        return res;
    }

    public int checkMax(int[][] grid, int i, int j) {
        int max = 0;
        for(int m = i; m < i+3; m++) {
            for(int n = j; n < j+3; n++) {
                max = Math.max(max, grid[m][n]);
            }
        }
        return max;
    }
}
