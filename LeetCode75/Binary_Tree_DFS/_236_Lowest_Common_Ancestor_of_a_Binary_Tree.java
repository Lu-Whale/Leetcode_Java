package LeetCode75.Binary_Tree_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pathToP = new ArrayList<>();
        dfs(root, p, pathToP);

        List<TreeNode> pathToQ = new ArrayList<>();
        dfs(root, q, pathToQ);

        TreeNode LCA = root;
        for(int i = 0; i < Math.min(pathToP.size(), pathToQ.size()); i++) {
            if(pathToP.get(i) == pathToQ.get(i)) {
                LCA = pathToP.get(i);
            }else {
                break;
            }
        }

        return LCA;
    }

    public boolean dfs(TreeNode root, TreeNode target, List<TreeNode> path) {
        if(root == null) {
            return false;
        }
        path.add(root);

        if(root == target) {
            return true;
        }

        if(dfs(root.left, target, path) || dfs(root.right, target, path)) {
            return true;
        }
        // if current node is not the in the path from root to target, then delete the node and backtrack
        path.remove(path.size() -1);
        return false;
    }


}
