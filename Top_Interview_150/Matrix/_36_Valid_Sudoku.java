package Top_Interview_150.Matrix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _36_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int column = board[0].length;

        for(int i = 0; i < row;  i++) {
            HashSet<Character> hashSet = new HashSet<>();
            for(int j = 0; j < column; j++) {
                if(!Character.isDigit(board[i][j])) {
                    continue;
                }
                if(hashSet.contains(board[i][j])) {
                    return false;
                }
                hashSet.add(board[i][j]);
            }
        }

        for(int i = 0; i < column; i++) {
            HashSet<Character> hashSet = new HashSet<>();
            for(int j = 0; j < row; j++) {
                if(!Character.isDigit(board[j][i])) {
                    continue;
                }
                if(hashSet.contains(board[j][i])) {
                    return false;
                }
                hashSet.add(board[j][i]);
            }
        }

        for(int i = 0; i < row; i += 3) {
            for(int j = 0; j < column; j += 3) {
                HashSet<Character> hashSet = new HashSet<>();
                for(int m = i; m < i+3; m++){
                    for(int n = j; n < j+3; n++) {
                        if(!Character.isDigit(board[m][n])) {
                            continue;
                        }
                        if(hashSet.contains(board[m][n])) {
                            return false;
                        }
                        hashSet.add(board[m][n]);
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku3(char[][] board) {
        Map<Integer, Set<Integer>> row  = new HashMap<>(), col = new HashMap<>(), area = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            area.put(i, new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int u = c - '0';
                int idx = i / 3 * 3 + j / 3;
                if (row.get(i).contains(u) || col.get(j).contains(u) || area.get(idx).contains(u)) return false;
                row.get(i).add(u);
                col.get(j).add(u);
                area.get(idx).add(u);
            }
        }
        return true;
    }

}
