package Daily_Question;

import java.util.HashMap;
import java.util.HashSet;

public class _41_First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) nums[i] = -1;
        }

        for(int i = 0; i < n; i++) {
            int num = nums[i];
            if(num > 0 && num <= n) {
                dfs(nums, num - 1);
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) return i+1;
        }

        return n+1;
    }

    public void dfs(int[] nums, int index) {
        int num = nums[index];
        nums[index] = 0;
        if(num > 0 && num <= nums.length) {
            dfs(nums, num - 1);
        }
    }
}
