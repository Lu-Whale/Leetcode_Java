package Daily_Question;

import java.util.LinkedList;
import java.util.Queue;

// 2.28
public class _513_Find_Bottom_Left_Tree_Value {
    public int findBottomLeftValue(TreeNode root) {
        int res = root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            res = queue.peek().val;
            Queue<TreeNode> next = new LinkedList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    next.offer(node.left);
                }
                if(node.right != null) {
                    next.offer(node.right);
                }
            }
            queue = next;
        }

        return res;
    }
}
