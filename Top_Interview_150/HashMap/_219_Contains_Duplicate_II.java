package Top_Interview_150.HashMap;

import java.util.HashMap;

public class _219_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // key -> num; value -> index
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i]) && Math.abs(i - hashMap.get(nums[i])) <= k) {
                return true;
            }
            hashMap.put(nums[i], i);
        }

        return false;
    }
}
