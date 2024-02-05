package Top_Interview_150.HashMap;

import java.util.HashMap;

public class _1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i]) && nums[i] * 2 == target) {
                return new int[]{hashMap.get(nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }

        for(int key : hashMap.keySet()) {
            if(hashMap.containsKey(target - key)) {
                return new int[]{hashMap.get(key), hashMap.get(target - key)};
            }
        }

        return null;
    }
}
