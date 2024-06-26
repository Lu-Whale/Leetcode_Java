package Daily_Question;

import java.util.ArrayList;
import java.util.List;

public class _1382_Balance_a_Binary_Search_Tree {
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);

        return dfs(0, list.size() - 1);
    }

    public void inOrder(TreeNode root) {
        if(root == null) return;

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public TreeNode dfs(int left, int right) {
        if(left > right) return null;

        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = dfs(left, mid - 1);
        root.right = dfs(mid + 1, right);

        return root;
    }
}
