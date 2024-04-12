package Problem_List;


public class _1123_Lowest_Common_Ancestor_of_Deepest_Leaves {
    class Pair {
        TreeNode treeNode;
        int depth;
        public Pair(TreeNode treeNode, int depth) {
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).treeNode;
    }

    public Pair dfs(TreeNode root) {
        if(root == null) {
            return new Pair(root, 0);
        }

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        if(left.depth > right.depth) {
            return new Pair(left.treeNode, left.depth + 1);
        }
        if(left.depth < right.depth) {
            return new Pair(right.treeNode, right.depth + 1);
        }
        return new Pair(root, left.depth + 1);
    }
}
