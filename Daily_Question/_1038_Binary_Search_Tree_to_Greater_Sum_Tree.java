package Daily_Question;

public class _1038_Binary_Search_Tree_to_Greater_Sum_Tree {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        inOrderSum(root);
        inOrderPlus(root);
        return root;
    }

    public void inOrderSum(TreeNode root) {
        if(root == null) return;

        inOrderSum(root.left);
        sum += root.val;
        inOrderSum(root.right);
    }

    public void inOrderPlus(TreeNode root) {
        if(root == null) return;

        inOrderPlus(root.left);
        sum -= root.val;
        root.val += sum;
        inOrderPlus(root.right);
    }
}
