package Problem_List;

import java.util.*;

// https://leetcode.com/problems/combination-sum/
public class _39_Combination_Sum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtracking(candidates, target, 0, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int sum, int index) {
        if(sum > target) {
            return;
        }

        if(sum == target) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            combination.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i);
            combination.remove(combination.size() -1);
            sum -= candidates[i];
        }
    }
}

// 剪枝优化
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }
}