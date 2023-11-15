package Problem_List;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/count-complete-tree-nodes/
public class _222_Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int level = 0;
        TreeNode node = root;
        while (node.left != null) {
            level++;
            node = node.left;
        }
        // the index of last node should between low and high
        int low = 1 << level, high = (1 << (level + 1)) - 1;

        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, level, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int level, int k) {
        // used to control the direction of traversal (left or right)
        int bits = 1 << (level - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            // k represent the node that we need to reach
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
