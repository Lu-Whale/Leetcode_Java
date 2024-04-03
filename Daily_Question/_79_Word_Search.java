package Daily_Question;

public class _79_Word_Search {
    boolean find = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    dfs(board, word, i, j, 0, visited);
                    if(find) return true;
                }
            }
        }

        return false;
    }

    public void dfs(char[][] board, String word, int row, int column, int i, boolean[][] visited) {
        if(row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
            return;
        }
        if(board[row][column] != word.charAt(i) || visited[row][column]) {
            return;
        }

        visited[row][column] = true;
        if(i == word.length() - 1) {
            find = true;
            return;
        }

        dfs(board, word, row + 1, column, i + 1, visited);
        dfs(board, word, row - 1, column, i + 1, visited);
        dfs(board, word, row, column + 1, i + 1, visited);
        dfs(board, word, row, column - 1, i + 1, visited);

        visited[row][column] = false;
    }


    public static void main(String[] args) {

    }
}

class Solution_79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        boolean result;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result) return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
                backtrack(board, word, visited, i - 1, j, index + 1) ||
                backtrack(board, word, visited, i, j + 1, index + 1) ||
                backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
