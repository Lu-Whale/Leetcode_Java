package Daily_Question;

public class _861_Score_After_Flipping_Matrix {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            if(grid[i][0] == 0) {
                for(int j = 0; j < n; j++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < m; j++) {
                count += grid[j][i];
            }
            if(count * 2 < m) {
                for(int j = 0; j < m; j++) {
                    grid[j][i] = grid[j][i] == 0 ? 1 : 0;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < m; i++) {
            int num = 0;
            for(int j = n - 1; j >=0; j--) {
                num = num * 2 + grid[i][j];
            }
            res += num;
        }

        return res;
    }
}
