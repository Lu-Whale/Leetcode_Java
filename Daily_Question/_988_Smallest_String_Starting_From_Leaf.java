package Daily_Question;

public class _988_Smallest_String_Starting_From_Leaf {
    String s;
    StringBuilder sb;
    public String smallestFromLeaf(TreeNode root) {
        s = "";
        sb = new StringBuilder();
        dfs(root);
        return s;
    }

    public void dfs(TreeNode treeNode) {
        if(treeNode == null) return;

        sb.append((char)('a' + treeNode.val));
        if(treeNode.left == null && treeNode.right == null) {
            StringBuilder tempSb = new StringBuilder(sb.toString());
            String temp = tempSb.reverse().toString();
            if(s.equals("") || temp.compareTo(s) < 0){
                s = temp;
            }
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        dfs(treeNode.left);
        dfs(treeNode.right);

        sb.deleteCharAt(sb.length() - 1);
    }
}
