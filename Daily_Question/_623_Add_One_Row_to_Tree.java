package Daily_Question;

import java.util.LinkedList;
import java.util.Queue;

public class _623_Add_One_Row_to_Tree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curDepth = 1;
        while (!queue.isEmpty()) {
           int size = queue.size();
           if(curDepth == depth - 1){
               for(int i = 0; i < size; i++) {
                   TreeNode node = queue.poll();
                   TreeNode originalLeft = node.left;
                   TreeNode originalRight = node.right;
                   node.left = new TreeNode(val);
                   node.right = new TreeNode(val);
                   node.left.left = originalLeft;
                   node.right.right = originalRight;
               }
               return root;
           }else {
               for(int i = 0; i < size; i++) {
                   TreeNode node = queue.poll();
                   if(node.left != null) {
                       queue.offer(node.left);
                   }
                   if(node.right != null) {
                       queue.offer(node.right);
                   }
               }
               curDepth++;
           }
        }

        return root;
    }
}
