package Daily_Question;

// 2.27
public class _543_Diameter_of_Binary_Tree {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        res = Math.max(res, left + right);

        return Math.max(left, right) + 1;
    }
}
