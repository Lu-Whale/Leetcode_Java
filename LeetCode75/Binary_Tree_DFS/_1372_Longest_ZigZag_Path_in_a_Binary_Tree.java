package LeetCode75.Binary_Tree_DFS;


// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
public class _1372_Longest_ZigZag_Path_in_a_Binary_Tree {
    int result;
    public int longestZigZag(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        result = 0;
        dfs(root,true, 0);
        dfs(root, false, 0);

        return result;
    }

    public void dfs(TreeNode root, boolean right, int length) {
        if(root == null) {
            return;
        }
        result = Math.max(result, length);
        if(right) {
            dfs(root.right, false, length+1);
            dfs(root.left, true, 1);
        }else {
            dfs(root.left, true, length+1);
            dfs(root.right, false, 1);
        }
    }
}
