package Daily_Question;

public class _2331_Evaluate_Boolean_Binary_Tree {
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 0 ){
            return false;
        }else if(root.val == 1) {
            return true;
        }else {
            boolean left = evaluateTree(root.left);
            boolean right = evaluateTree(root.right);
            return root.val == 2 ? left || right : left && right;
        }
    }
}
