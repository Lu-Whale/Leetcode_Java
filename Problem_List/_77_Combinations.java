package Problem_List;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/
public class _77_Combinations {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k , 1);
        return res;
    }

    public void dfs(int n, int k, int number) {
        if (n - number + 1 < k - combination.size()) {
            return;
        }

        if(combination.size() == k) {
            res.add(new ArrayList<>(combination));
            return;
        }

        for(int i = number; i <= n; i++) {
            combination.add(i);
            dfs(n, k, i + 1);
            combination.remove(combination.size() -1);
        }
    }
}
