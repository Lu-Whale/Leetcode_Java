package LeetCode75.Binary_Tree_DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _437_Path_Sum_III {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        int result = dfs(root, targetSum);

        result += pathSum(root.left, targetSum);
        result += pathSum(root.right, targetSum);

        return result;
    }

    public int dfs(TreeNode root, long targetSum) {

        if(root == null) {
            return 0;
        }

        int result = 0;
        if(targetSum == root.val) {
            result++;
        }
        result += dfs(root.left, targetSum - root.val);
        result += dfs(root.right, targetSum - root.val);

        return result;
    }
}
