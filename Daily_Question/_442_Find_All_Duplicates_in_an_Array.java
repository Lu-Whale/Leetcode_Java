package Daily_Question;

import java.util.ArrayList;
import java.util.List;

public class _442_Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int pIndex = Math.abs(nums[i]) - 1;
            if(nums[pIndex] < 0) {
                res.add(Math.abs(nums[i]));
            }else {
                nums[pIndex] = - nums[pIndex];
            }
        }


        return res;
    }
}
