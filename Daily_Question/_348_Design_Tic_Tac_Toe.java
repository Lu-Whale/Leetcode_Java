package Daily_Question;

public class _348_Design_Tic_Tac_Toe {

}

class TicTacToe {

    int n;
    int[] rows;
    int[] cols;
    int dia1, dia2;

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        dia1 = 0;
        dia2 = 0;
    }

    public int move(int row, int col, int player) {
        // 玩家下棋值
        int cell = player == 1 ? 1 : -1;
        // 玩家赢时和
        int sum = player == 1 ? n : -n;
        // 此行当前和
        rows[row] += cell;
        if (sum == rows[row]) return player;
        // 此列当前和
        cols[col] += cell;
        if (sum == cols[col]) return player;
        // 主对角线当前和
        if (row == col) {
            dia1 += cell;
            if (sum == dia1) return player;
        }
        // 副对角线当前和
        if (row + col == n - 1) {
            dia2 += cell;
            if (sum == dia2) return player;
        }
        return 0;
    }
}

