package Daily_Question;

import java.util.HashMap;

public class _2962_Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times {
    public long countSubarrays(int[] nums, int k) {
        long res = 0L;

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // key -> times, value -> index
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == max) hashMap.put(count++, i);
            if(count > k) res += hashMap.get(count - k) + 1;
        }

        return res;
    }

    public static long countSubarrays2(int[] nums, int k) {
        long res = 0L;

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int left = 0;
        int count = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == max) count++;

            while (count >= k) {
                if(nums[left++] == max) count--;
            }
            res += left;
        }

        return res;
    }

}
