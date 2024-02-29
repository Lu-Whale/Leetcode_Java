package Daily_Question;

import java.util.LinkedList;
import java.util.Queue;

public class _1609_Even_Odd_Tree {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> curLevel = new LinkedList<>();
        curLevel.add(root);
        boolean isEven = true;
        while (!curLevel.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<>();
            int preVal = isEven ? 0 : Integer.MAX_VALUE;
            while (!curLevel.isEmpty()) {
                TreeNode node = curLevel.poll();
                if(isEven) {
                    if(node.val <= preVal || node.val % 2 != 1) return false;
                }else {
                    if(node.val >= preVal || node.val % 2 != 0) return false;
                }
                preVal = node.val;

                if(node.left != null) nextLevel.offer(node.left);
                if(node.right != null) nextLevel.offer(node.right);
            }
            isEven = !isEven;
            curLevel = nextLevel;
        }
        return true;
    }
}
