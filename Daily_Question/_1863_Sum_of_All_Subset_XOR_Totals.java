package Daily_Question;

public class _1863_Sum_of_All_Subset_XOR_Totals {
    public static int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    private static int backtrack(int[] nums, int index, int currentXor) {
        if (index == nums.length) {
            return currentXor;
        }
        // Include the current element
        int withCurrent = backtrack(nums, index + 1, currentXor ^ nums[index]);
        // Exclude the current element
        int withoutCurrent = backtrack(nums, index + 1, currentXor);
        return withCurrent + withoutCurrent;
    }
}
