package Problem_List;

import java.util.LinkedList;
import java.util.Queue;

public class _404_Sum_of_Left_Leaves {
    class LeftNode {
        TreeNode treeNode;
        boolean isLeftNode;
        public LeftNode(TreeNode treeNode, boolean isLeftNode) {
            this.treeNode = treeNode;
            this.isLeftNode = isLeftNode;
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        Queue<LeftNode> queue = new LinkedList<>();
        queue.add(new LeftNode(root, false));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                LeftNode node = queue.poll();
                if(node.treeNode.left == null && node.treeNode.right == null && node.isLeftNode) {
                    res += node.treeNode.val;
                }
                if(node.treeNode.left != null) {
                    queue.offer(new LeftNode(node.treeNode.left, true));
                }
                if(node.treeNode.right != null) {
                    queue.offer(new LeftNode(node.treeNode.right, false));
                }
            }
        }

        return res;
    }
}

class Solution_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) { // Leaf node
            return isLeft ? node.val : 0;
        }
        int leftSum = dfs(node.left, true);   // Traverse left child
        int rightSum = dfs(node.right, false); // Traverse right child
        return leftSum + rightSum;
    }
}