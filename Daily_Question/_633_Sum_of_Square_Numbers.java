package Daily_Question;

public class _633_Sum_of_Square_Numbers {
    public boolean judgeSquareSum(int c) {
        for(long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if(b == (int) b) {
                return true;
            }
        }
        return false;
    }
}

class Solution_633 {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}


