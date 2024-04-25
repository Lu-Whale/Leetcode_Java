package Daily_Question;

import java.util.HashMap;

public class _1137_N_th_Tribonacci_Number {
    public int tribonacci(int n) {
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;

        if(n == 0) return t0;
        if(n == 1) return t1;
        if(n == 2) return t2;

        int count = 3;
        while (count <= n) {
            int temp = t2 + t1 + t0;
            t0 = t1;
            t1 = t2;
            t2 = temp;
            count++;
        }
        return t2;
    }
}

class Solution_1137 {
    public int tribonacci(int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        return recursion(n, hashMap);
    }

    public int recursion(int n, HashMap<Integer, Integer> hashMap) {
        if(hashMap.containsKey(n)) {
            return hashMap.get(n);
        }

        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;

        int num = recursion(n - 1, hashMap) + recursion(n - 2, hashMap) + recursion(n - 3, hashMap);
        hashMap.put(n, num);

        return num;
    }

}
