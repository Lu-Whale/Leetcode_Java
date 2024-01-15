package Top_Interview_150.Array_String;

import java.util.*;

public class _15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<String> hashSet = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                break;
            }
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) {
                    k--;
                }else if(sum < 0) {
                    j++;
                }else {
                    String s = "[" + nums[i] + "," + nums[j] + "," + nums[k] + "]";
                    if(!hashSet.contains(s)){
                        hashSet.add(s);
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    j++;
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
