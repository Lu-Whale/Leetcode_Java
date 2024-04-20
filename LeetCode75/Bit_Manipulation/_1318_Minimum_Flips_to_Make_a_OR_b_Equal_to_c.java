package LeetCode75.Bit_Manipulation;

public class _1318_Minimum_Flips_to_Make_a_OR_b_Equal_to_c {
    public int minFlips(int a, int b, int c) {
        int flipCount = 0;

        while (a > 0 || b > 0 || c > 0) {
            int aBit = a & 1;
            int bBit = b & 1;
            int cBit = c & 1;

            if ((aBit | bBit) != cBit) {
                flipCount += (aBit == bBit && aBit == 1) ? 2 : 1;
            }

            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return flipCount;
    }
}
