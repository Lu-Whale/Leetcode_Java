package LeetCode75.Hash_Map_Set;

import java.util.Arrays;
import java.util.HashMap;

public class _2352_Equal_Row_and_Column_Pairs {
    public static int equalPairs(int[][] grid) {

        int n = grid.length;
        int res = 0;

        HashMap<String, Integer> colum = new HashMap<>();
        for(int i = 0; i < n; i++) {
            StringBuilder colStr = new StringBuilder();
            for(int j = 0; j < n; j++) {
                colStr.append(grid[j][i]).append(",");
            }
            String tmp = colStr.toString();
            if(colum.containsKey(tmp)) {
                colum.replace(tmp, colum.get(tmp) + 1);
            }else {
                colum.put(tmp, 1);
            }
        }

        for (int[] ints : grid) {
            StringBuilder rowStr = new StringBuilder();
            for(int i: ints) {
                rowStr.append(i).append(",");
            }
            String tmp = rowStr.toString();
            if (colum.containsKey(tmp)) {
                res += colum.get(tmp);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {{3,2,1}, {1, 7, 6}, {2,7,7}};

        System.out.println(equalPairs(grid));
    }
}
