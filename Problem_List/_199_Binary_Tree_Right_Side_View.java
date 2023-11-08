package Problem_List;

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

public class _199_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        int level = 0;
        List<Integer> result = new ArrayList<>();

        dfs(root, result, level);

        return result;
    }

    public void dfs(TreeNode root, List<Integer> list, int level) {
        if(root == null) {
            return;
        }
        if(list.size() == level) {
            list.add(root.val);
        }
        level++;
        dfs(root.right, list, level);
        dfs(root.left, list, level);
    }
}
