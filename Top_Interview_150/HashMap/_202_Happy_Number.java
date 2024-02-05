package Top_Interview_150.HashMap;

import java.util.HashSet;
import java.util.List;

public class _202_Happy_Number {
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (true) {
            hashSet.add(n);
            n = handler(n);
            if(n == 1) {
                return true;
            }
            if(hashSet.contains(n)) {
                return false;
            }
        }
    }

    public int handler(int n) {
        int sum = 0;
        while (n > 0) {
            int remainder = n % 10;
            sum += Math.pow(remainder, 2);
            n /= 10;
        }
        return sum;
    }
}
