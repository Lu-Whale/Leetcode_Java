package Problem_List;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/subarray-sum-equals-k/
public class _560_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int res = 0;

        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        //to handle those qualified subarray start from first element
        //otherwise, the
        prefixSum.put(0, 1);
        int sum = 0;
        for(int i = 0 ; i < n ; i++) {
            sum += nums[i];
            if(prefixSum.containsKey(sum - k)) {
                res += prefixSum.get(sum - k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
