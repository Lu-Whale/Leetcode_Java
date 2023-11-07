package LeetCode75.Binary_Search_Tree;

public class _450_Delete_Node_in_a_BST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }else if(root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }else {
            if(root.right == null) {
                return root.left;
            }else if(root.left == null) {
                return root.right;
            }else {
                TreeNode replace = root.right;
                while (replace.left != null) {
                    replace = replace.left;
                }
                root.val = replace.val;

                root.right = deleteNode(root.right, replace.val);
                return root;
            }
        }
    }
}
