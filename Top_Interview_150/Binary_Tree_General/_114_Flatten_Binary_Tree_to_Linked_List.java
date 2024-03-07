package Top_Interview_150.Binary_Tree_General;

import java.util.ArrayList;
import java.util.List;

public class _114_Flatten_Binary_Tree_to_Linked_List {
    List<TreeNode> list;
    public void flatten(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);

        for(int i = 1; i < list.size(); i++) {
            root.right = list.get(i);
            root.left = null;
            root = root.right;
        }
    }

    public void dfs(TreeNode root) {
        if(root == null) return;

        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }

    public void flatten2(TreeNode root) {
        while (root != null) {
            // if root.left == null, then continue
            if (root.left != null) {
                // Find the rightmost node in the left subtree
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //Connect the original right subtree to the rightmost node of the left subtree
                pre.right = root.right;
                // Insert the left subtree into the right subtree
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
