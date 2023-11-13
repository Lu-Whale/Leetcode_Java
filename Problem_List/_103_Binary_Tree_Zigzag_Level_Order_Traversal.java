package Problem_List;

import java.util.*;

public class _103_Binary_Tree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //use boolean check and stack to traversal
        boolean traversal = true;
        while (!queue.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            Stack<TreeNode> tmpStack = new Stack<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();

                if(traversal) {
                    if(treeNode.left != null) {
                        tmpStack.add(treeNode.left);
                    }
                    if(treeNode.right != null) {
                        tmpStack.add(treeNode.right);
                    }
                }else {
                    if(treeNode.right != null) {
                        tmpStack.add(treeNode.right);
                    }
                    if(treeNode.left != null) {
                        tmpStack.add(treeNode.left);
                    }
                }

                subResult.add(treeNode.val);
            }
            while (!tmpStack.isEmpty()) {
                queue.add(tmpStack.pop());
            }
            result.add(subResult);
            traversal = !traversal;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
