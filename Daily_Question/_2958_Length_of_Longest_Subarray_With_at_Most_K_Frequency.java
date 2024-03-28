package Daily_Question;

import java.util.HashMap;

public class _2958_Length_of_Longest_Subarray_With_at_Most_K_Frequency {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            int num = nums[right];
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            while (hashMap.get(num) > k) {
                hashMap.put(nums[left], hashMap.get(nums[left]) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
