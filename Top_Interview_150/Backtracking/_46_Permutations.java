package Top_Interview_150.Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/description/?envType=study-plan-v2&envId=top-interview-150
public class _46_Permutations {
    List<List<Integer>> res;
    List<Integer> permutations;
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        permutations = new ArrayList<>();
        visited = new boolean[nums.length];

        dfs(nums);

        return res;
    }

    public void dfs(int[] nums) {
        if(permutations.size() == nums.length) {
            res.add(new ArrayList<>(permutations));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutations.add(nums[i]);

                dfs(nums);

                visited[i] = false;
                permutations.remove(permutations.size()-1);
            }
        }
    }
}
