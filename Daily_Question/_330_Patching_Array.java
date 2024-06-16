package Daily_Question;

public class _330_Patching_Array {
    public int minPatches(int[] nums, int n) {
        int res = 0, i = 0;
        long s = 1;
        while (s <= n) {
            if (i < nums.length && nums[i] <= s) {
                s += nums[i++];
            } else {
                s *= 2; // 必须添加 s
                res++;
            }
        }
        return res;
    }
}
