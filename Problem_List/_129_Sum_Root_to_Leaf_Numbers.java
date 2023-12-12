package Problem_List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// https://leetcode.com/problems/sum-root-to-leaf-numbers/
public class _129_Sum_Root_to_Leaf_Numbers {
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return totalSum;
    }

    public void dfs(TreeNode root, int sum) {
        if(root == null) {
            return;
        }

        sum += root.val;
        if(root.left == null && root.right == null) {
            totalSum += sum;
            return;
        }

        dfs(root.left, sum * 10);
        dfs(root.right, sum * 10);
    }
}
