package LeetCode75.Binary_Tree_BFS;

import java.util.*;
import java.util.Queue;

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


public class _199_Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Queue<TreeNode> tmpQueue = new LinkedList<>();

            while (!queue.isEmpty()) {
                TreeNode tmpNode = queue.poll();
                if(queue.isEmpty()) {
                    result.add(tmpNode.val);
                }
                if(tmpNode.left != null) {
                    tmpQueue.add(tmpNode.left);
                }
                if(tmpNode.right != null) {
                    tmpQueue.add(tmpNode.right);
                }
            }

            queue = tmpQueue;
        }

        return result;
    }
}
