package Problem_List;

public class _130_Surrounded_Regions {
    boolean[][] visited;
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((i == 0 || i == n -1 || j == 0 || j == m - 1) && board[i][j] == 'O' && !visited[i][j]) {
                    dfs(board, i, j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }


    public void dfs(char[][] board, int row, int column) {
        if(row < 0 || row >= board.length || column < 0 || column >= board[0].length || board[row][column] != 'O' || visited[row][column]) {
            return;
        }

        visited[row][column] = true;

        dfs(board, row + 1, column);
        dfs(board, row - 1, column);
        dfs(board, row, column + 1);
        dfs(board, row, column - 1);
    }
}
