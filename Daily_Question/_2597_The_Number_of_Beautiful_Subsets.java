package Daily_Question;

import java.util.HashMap;
import java.util.HashSet;

public class _2597_The_Number_of_Beautiful_Subsets {
    int res;
    HashMap<Integer,Integer> hashMap;

    public int beautifulSubsets(int[] nums, int k) {
        res = 0;
        hashMap = new HashMap<>();
        backtracking(nums, k, 0);
        return res;
    }

    public void backtracking(int[] nums, int k, int index) {
        if(index == nums.length) {
            if(!hashMap.isEmpty()) {
                res++;
            }
            return;
        }

        backtracking(nums, k, index + 1);

        if(!hashMap.containsKey(nums[index] - k) && !hashMap.containsKey(nums[index] + k)) {
            hashMap.put(nums[index], hashMap.getOrDefault(nums[index], 0) + 1);
            backtracking(nums, k, index + 1);
            if(hashMap.get(nums[index]) > 1) {
                hashMap.put(nums[index], hashMap.get(nums[index]) - 1);
            }else {
                hashMap.remove(nums[index]);
            }
        }
    }
}
