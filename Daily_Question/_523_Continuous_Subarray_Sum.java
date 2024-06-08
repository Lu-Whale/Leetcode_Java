package Daily_Question;

import java.util.HashMap;
import java.util.Map;

public class _523_Continuous_Subarray_Sum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if(n < 2) return false;

        //prefix sum
        int[] prefix = new int[n + 1];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            sum %= k;
            prefix[i + 1] = sum;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);
        hashMap.putIfAbsent(prefix[1], 1);
        for(int i = 2; i < n + 1; i++) {
            if(hashMap.containsKey(prefix[i])) {
                System.out.println(i);
                if(i - hashMap.get(prefix[i]) > 1) {
                    return true;
                }
            }else {
                hashMap.put(prefix[i], i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;

        System.out.println(checkSubarraySum(nums, k));
    }
}

class Solution_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize with remainder 0 at index -1 to handle edge case
        int remainder = 0;

        for (int i = 0; i < nums.length; i++) {
            remainder = (remainder + nums[i]) % k;
            if (remainder < 0) {
                remainder += k; // Handle negative remainders
            }
            if (map.containsKey(remainder)) {
                int pos = map.get(remainder);
                if (i - pos >= 2) { // Check if the subarray length is at least 2
                    return true;
                }
            } else {
                map.put(remainder, i); // Store the first occurrence of this remainder
            }
        }

        return false;
    }
}