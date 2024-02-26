package Daily_Question;

// 2.27

public class _100_Same_Tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        boolean isSameLeft = isSameTree(p.left, q.left);
        boolean isSameRight = isSameTree(p.right,q.right);

        return p.val == q.val && isSameLeft && isSameRight;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

