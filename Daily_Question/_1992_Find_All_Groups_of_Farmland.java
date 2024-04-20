package Daily_Question;

import java.util.ArrayList;
import java.util.List;

public class _1992_Find_All_Groups_of_Farmland {
    List<int[]> list;
    int[] array;
    int m, n;
    public int[][] findFarmland(int[][] land) {
        m = land.length;
        n = land[0].length;

        list = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(land[i][j] == 1) {
                    array = new int[4];
                    array[0] = i;
                    array[1] = j;
                    dfs(land, i, j);
                    list.add(array);
                }
            }
        }
        int[][] res = new int[list.size()][4];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public void dfs(int[][] land, int row, int col) {
        if(row < 0 || row >= m || col < 0 || col >= n || land[row][col] == 0) {
            return;
        }

        array[2] = Math.max(row, array[2]);
        array[3] = Math.max(col, array[3]);
        land[row][col] = 0;

        dfs(land, row + 1, col);
        dfs(land, row - 1, col);
        dfs(land, row, col + 1);
        dfs(land, row, col - 1);
    }
}
