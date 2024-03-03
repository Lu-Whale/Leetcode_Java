package Daily_Question;

// 3.2
public class _977_Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int lp = 0;
        int rp = n - 1;

        int[] res = new int[n];
        int index = n - 1;
        while (lp <= rp) {
            int squareLp = nums[lp] * nums[lp];
            int squareRp = nums[rp] * nums[rp];
            if(squareRp >= squareLp) {
                res[index] = squareRp;
                rp--;
            }else {
                res[index] = squareLp;
                lp++;
            }
            index--;
        }
        return res;
    }
}
