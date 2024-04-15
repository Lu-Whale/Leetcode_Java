package LeetCode75.Bit_Manipulation;

public class _338_Counting_Bits {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        int pow = 0;
        for (int i = 1; i < n + 1; i++) {
            bits[i] = bits[i - (1 << pow)] + 1;   // 1 << pow means 2^power
            if ((i & (i + 1)) == 0) {            // it means i+1 is power of two, so i increase power, or keep it same until next n-digit
                pow++;
            }
        }
        return bits;
    }
}
