package LeetCode75.Binary_Tree_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/?envType=study-plan-v2&envId=leetcode-75
public class _1161_Maximum_Level_Sum_of_a_Binary_Tree {
    public int maxLevelSum(TreeNode root) {

        int res = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int maximal = root.val;
        int currentLevel = 1;
        while (!queue.isEmpty()) {
            int currentSum = 0;
            Queue<TreeNode> nextLevel = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                currentSum += tmp.val;
                if(tmp.left != null) {
                    nextLevel.offer(tmp.left);
                }
                if(tmp.right != null) {
                    nextLevel.offer(tmp.right);
                }
            }
            if(currentSum > maximal) {
                res = currentLevel;
                maximal = currentSum;
            }
            currentLevel++;
            queue = nextLevel;
        }

        return res;
    }
}
