package Daily_Question;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>());
        return res;
    }

    public void backtracking(int[] nums, int index, List<Integer> current) {
        if(index == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        //exclude
        backtracking(nums, index + 1, current);

        //include
        current.add(nums[index]);
        backtracking(nums, index + 1, current);
        current.remove(current.size() - 1); //backtracking
    }
}
