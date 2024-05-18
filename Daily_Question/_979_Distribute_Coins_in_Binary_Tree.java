package Daily_Question;

public class _979_Distribute_Coins_in_Binary_Tree {
    private int ans;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[]{0, 0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int coins = left[0] + right[0] + node.val; // 子树硬币个数
        int nodes = left[1] + right[1] + 1; // 子树节点数
        ans += Math.abs(coins - nodes);
        return new int[]{coins, nodes};
    }
}
