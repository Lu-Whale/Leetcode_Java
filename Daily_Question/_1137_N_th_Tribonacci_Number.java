package Daily_Question;

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
