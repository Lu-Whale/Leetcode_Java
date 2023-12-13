package Problem_List;

import java.util.HashMap;

public class _930_Binary_Subarrays_With_Sum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        int res = 0;
        //key is the sum of subarrays, value is the count
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];

            // if the sum of interval (i,j) equals 'goal',
            // we got sum[j]−sum[i]=goal -> then sum[i] = sum[j] - goal
            // so we just need to find how many sum[i] that satisfy this equation
            res += hashMap.getOrDefault(sum -goal, 0);

            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
