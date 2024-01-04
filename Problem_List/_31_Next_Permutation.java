package Problem_List;

import java.util.Arrays;

public class _31_Next_Permutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1) {
            return;
        }
        int i = n - 2, j = n-1, k = n-1;
        // find the adjacent ascending pair
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }

        if(i >= 0) {
            while (k >= j && nums[i] >= nums[k]) {
                k--;
            }
            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
        }
        Arrays.sort(nums, j, n);
    }


}
