package Daily_Question;

public class _2485_Find_the_Pivot_Integer {
    public int pivotInteger(int n) {
        for(int i = 1; i <= n; i++) {
            int a = (i * (i + 1)) / 2;
            int b = ((n - i + 1) * (n + i)) / 2;
            if(a == b) return i;
        }
        return -1;
    }
}

class Solution_2485 {
    public int pivotInteger(int n) {
        int[] prefs = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            prefs[i] = prefs[i - 1] + i;
        }

        for (int i = 1; i < n + 1; i++) {
            if (prefs[i] == prefs[n] - prefs[i - 1])
                return i;
        }

        return -1;
    }
}
