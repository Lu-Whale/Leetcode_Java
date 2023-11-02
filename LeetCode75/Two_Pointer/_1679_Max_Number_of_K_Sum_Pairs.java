package LeetCode75.Two_Pointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class _1679_Max_Number_of_K_Sum_Pairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;

        int lp = 0;
        int rp = nums.length - 1;
        while (lp < rp) {
            if(nums[lp] + nums[rp] > k) {
                rp--;
            }else if(nums[lp] + nums[rp] < k){
                lp++;
            }else {
                result++;
                rp--;
                lp++;
            }
        }

        return result;
    }

    public int HashmapSolution(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans=0;
        for(int i:nums){
            int remaining = k-i;
            if(map.containsKey(remaining)){
                ans++;
                if(map.get(remaining)==1){
                    map.remove(remaining);
                }
                else{
                    map.put(remaining, map.get(remaining)-1);
                }
            }
            else{
                map.put(i, map.getOrDefault(i, 0)+1);
            }
        }
        return ans;
    }
    public int Time_Limit_Exceeded(int[] nums, int k) {
        HashSet<Integer> visitedIndex = new HashSet<>();
        int result = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            if(visitedIndex.contains(i)) {
                continue;
            }
            for(int j = nums.length - 1; j > i; j--) {
                if(visitedIndex.contains(j)) {
                    continue;
                }
                if(nums[i] + nums[j] == k) {
                    result++;
                    visitedIndex.add(i);
                    visitedIndex.add(j);
                    break;
                }
            }
        }
        return result;
    }
}
