package Top_Interview_150.Matrix;

import java.util.ArrayList;
import java.util.List;

public class _54_Spiral_Matrix {
    List<Integer> list;
    boolean[][] visited;
    int direction = 0; // 0 -> right; 1 -> down; 2 -> left; 3-> up
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        list = new ArrayList<>();
        visited = new boolean[m][n];
        dfs(matrix, m, n, 0, 0);
        return list;
    }

    public void dfs(int[][] matrix, int m, int n, int row, int column) {
        list.add(matrix[row][column]);
        visited[row][column] = true;

        if(direction == 0 && (column + 1 >= n || visited[row][column+1])) {
            if(row + 1 >= m || visited[row+1][column]) {
                return;
            }else {
                direction++;
            }
        }else if(direction == 1 && (row + 1 >= m || visited[row + 1][column])) {
            if(column - 1 < 0 || visited[row][column - 1]) {
                return;
            }else {
                direction++;
            }
        }else if(direction == 2 && (column - 1 < 0 || visited[row][column-1])) {
            if(row - 1 < 0 || visited[row-1][column]) {
                return;
            }else {
                direction++;
            }
        }else if(direction == 3 && (row - 1 < 0 || visited[row-1][column])) {
            if(column + 1 >= n || visited[row][column+1]) {
                return;
            }else {
                direction = 0;
            }
        }

        if(direction == 0) {
            dfs(matrix, m, n, row, column + 1);
        }else if(direction == 1){
            dfs(matrix, m, n, row + 1, column);
        }else if(direction == 2) {
            dfs(matrix, m, n, row, column - 1);
        }else if(direction == 3) {
            dfs(matrix, m, n, row - 1, column);
        }
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
}

class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int u = 0, d = matrix.length - 1;
        int l = 0, r = matrix[0].length - 1;

        while (true) {
            for (int i = l; i <= r; i++) { // 左->右
                ans.add(matrix[u][i]);
            }
            if (++u > d) break;
            for (int i = u; i <= d; i++) { // 上->下
                ans.add(matrix[i][r]);
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) { // 右->左
                ans.add(matrix[d][i]);
            }
            if (--d < u) break;
            for (int i = d; i >= u; i--) { // 下->上
                ans.add(matrix[i][l]);
            }
            if (++l > r) break;
        }
        return ans;
    }
}