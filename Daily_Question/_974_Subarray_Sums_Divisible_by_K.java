package Daily_Question;

import java.util.HashMap;

public class _974_Subarray_Sums_Divisible_by_K {
    public static int subarraysDivByK(int[] nums, int k) {
        int n = nums.length, res = 0;

        int[] prefix = new int[n + 1];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % k;
            if(sum < 0) sum += k;
            prefix[i + 1] = sum;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        for(int i = 1; i < n + 1; i++) {
            if(hashMap.containsKey(prefix[i])) {
                res += hashMap.get(prefix[i]);
                hashMap.put(prefix[i], hashMap.get(prefix[i]) + 1);
            }else {
                hashMap.put(prefix[i], 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        subarraysDivByK(nums, k);
    }
}
