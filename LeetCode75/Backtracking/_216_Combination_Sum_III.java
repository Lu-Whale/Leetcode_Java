package LeetCode75.Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iii/?envType=study-plan-v2&envId=leetcode-75
public class _216_Combination_Sum_III {

    List<List<Integer>> res;
    List<Integer> combination;
    public List<List<Integer>> combinationSum3(int k, int n) {

        res = new ArrayList<>();
        combination = new ArrayList<>();

        dfs(k, n, 0, 1);

        return res;
    }

    public void dfs(int k, int n, int sum, int number) {
        if(sum > n || combination.size() > k) {
            return;
        }

        if(sum == n && combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for(int i = number; i < 10; i++) {
            sum += i;
            combination.add(i);
            dfs(k, n, sum, i + 1);
            //backtracking
            sum -= i;
            combination.remove(combination.size() - 1);
        }
    }
}


