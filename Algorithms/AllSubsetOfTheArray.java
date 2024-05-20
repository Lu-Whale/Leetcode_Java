package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetOfTheArray {
    public List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtracking(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(current));
            return;
        }

        // 不包含当前元素的情况
        backtracking(nums, index + 1, current, result);

        // 包含当前元素的情况
        current.add(nums[index]);
        backtracking(nums, index + 1, current, result);
        current.remove(current.size() - 1); // 回溯，移除刚添加的元素
    }


    public List<List<Integer>> generateSubsets2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 计算2的nums.length次方，即子集的总数
        int totalNumber = 1 << nums.length;

        for (int i = 0; i < totalNumber; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                // 检查第j位是否是1
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }

        return result;
    }
}
