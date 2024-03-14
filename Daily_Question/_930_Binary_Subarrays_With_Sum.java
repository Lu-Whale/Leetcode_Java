package Daily_Question;

import java.util.HashMap;

public class _930_Binary_Subarrays_With_Sum {
    // sliding window
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;

        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                if(sum == goal) res++;
                if(sum > goal) break;
            }
        }

        return res;
    }
}

class Solution_930_withPrefixSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        int res = 0;
        //key is the sum of subarrays, value is the count
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            res += hashMap.getOrDefault(sum -goal, 0);
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
