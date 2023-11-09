package LeetCode75.Binary_Tree_DFS;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class _1448_Count_Good_Nodes_in_Binary_Tree {
    public int goodNodes(TreeNode root) {
        int max = root.val;
        List<TreeNode> result = new ArrayList<>();
        dfs(root, max, result);

        return result.size();
    }

    public void dfs(TreeNode root, int max, List<TreeNode> result) {
        //boundary case
        if(root == null) {
            return;
        }

        if(root.val >= max) {
            result.add(root);
            max = root.val;
        }

        dfs(root.left, max, result);
        dfs(root.right, max, result);
    }


}










