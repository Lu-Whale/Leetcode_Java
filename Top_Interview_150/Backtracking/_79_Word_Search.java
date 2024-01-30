package Top_Interview_150.Backtracking;

import java.util.HashMap;
import java.util.HashSet;

public class _79_Word_Search {
    StringBuilder stringBuilder;
    boolean[][] visited;
    boolean find = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                stringBuilder = new StringBuilder();
                visited = new boolean[m][n];
                dfs(board, i, j, word);
                if(find){
                    return true;
                }
            }
        }
        return false;
    }

    public void dfs(char[][] board, int row, int column, String word) {
        if (row < 0 || row > board.length - 1 || column < 0 || column > board[row].length - 1) {
            return;
        }

        if(stringBuilder.length() >= word.length() || visited[row][column] || board[row][column] != word.charAt(stringBuilder.length())) {
            return;
        }
        stringBuilder.append(board[row][column]);
        visited[row][column] = true;

        if (word.equals(stringBuilder.toString())) {
            find = true;
            return;
        }

        dfs(board, row + 1, column, word);
        dfs(board, row - 1, column, word);
        dfs(board, row, column + 1, word);
        dfs(board, row, column - 1, word);

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        visited[row][column] = false;
    }

//    if(row < 0 || row > board.length - 1 || column < 0 || column > board[row].length - 1) {
//            return;
//        }
//        String s = "row: " + row + ", " + "column: " + column;
//        if(visited.contains(s)) {
//            return;
//        }
//        stringBuilder.append(board[row][column]);
//        visited.add(s);
//        if(stringBuilder.length() > word.length() || stringBuilder.charAt(stringBuilder.length() - 1) != word.charAt(stringBuilder.length() - 1)) {
//            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//            visited.remove(s);
//            return;
//        }
//
//        if(word.equals(stringBuilder.toString())) {
//            find = true;
//            return;
//        }
//
//

}
