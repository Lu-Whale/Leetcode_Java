package LeetCode75.Binary_Search_Tree;


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

public class _700_Search_in_a_Binary_Search_Tree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }

        if(root.val == val) {
            return root;
        }else if(root.val < val ) {
            return searchBST(root.right, val);
        }else {
            return searchBST(root.left, val);
        }
    }
}
