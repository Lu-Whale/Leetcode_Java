package Previous.ByteDance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的右视图199 {
    public class TreeNode {
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

    class SolutionDFS {
        List<Integer> result = new ArrayList<>();
        public List<Integer> rightSideView(TreeNode root) {
            dfs(root, 0);
            return result;
        }

        public void dfs(TreeNode root, int currDepth) {
            if(root == null) {
                return;
            }

            if(currDepth == result.size()) {
                result.add(root.val);
            }
            currDepth++;
            dfs(root.right, currDepth);
            dfs(root.left, currDepth);
        }
    }

    class SolutionBFS {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            if(root == null) {
                return result;
            }

            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root); //初始size是1

            while (!queue.isEmpty()) {
                int size = queue.size();
                //当i等于size-1时遍历到该行最后一个节点，然后i++后i等于size跳出循环
                //此时队列中本行的节点都遍历完毕，但是随着遍历过程中，这行节点的所有左右节点又都被加入到queue中
                //然后符合while中queue不为空的情况，重新用新的size执行下一个for循环
                for(int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    //以下两个if操作会让queue的size不断增加
                    if(treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if(treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                    //遍历到这行最后一个节点时把他加到result里
                    if(i == size - 1) {
                        result.add(treeNode.val);
                    }
                }
            }
            return result;
        }
    }
}
