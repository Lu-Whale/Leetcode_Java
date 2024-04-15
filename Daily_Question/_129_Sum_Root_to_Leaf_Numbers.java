package Daily_Question;

public class _129_Sum_Root_to_Leaf_Numbers {
    int res;
    StringBuilder sb;
    public int sumNumbers(TreeNode root) {
        res = 0;
        sb = new StringBuilder();
        dfs(root);

        return res;
    }

    public void dfs(TreeNode treeNode) {
        if(treeNode == null) return;

        sb.append(treeNode.val);
        if(treeNode.left == null && treeNode.right == null) {
            res += Integer.parseInt(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        dfs(treeNode.left);
        dfs(treeNode.right);

        sb.deleteCharAt(sb.length() - 1);
    }
}

class Solution_129 {
    public int sumTree(TreeNode root,int sum){
        if(root==null) return 0;
        sum=sum*10+root.val;
        if(root.left==null && root.right==null) return sum;
        return sumTree(root.left,sum)+sumTree(root.right,sum);
    }
    public int sumNumbers(TreeNode root) {
        return sumTree(root,0);
    }

}
