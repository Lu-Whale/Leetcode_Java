package Binary_Tree_DFS;

//https://leetcode.com/problems/leaf-similar-trees/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.List;

public class _872_Leaf_Similar_Trees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        DFS(root1, list1);
        DFS(root2, list2);

        return list1.equals(list2);
    }

    public List<Integer> DFS(TreeNode root, List<Integer> list) {
        if(root == null) return list;

        if(root.right == null && root.left == null) {
            list.add(root.val);
        }else {
            DFS(root.left, list);
            DFS(root.right, list);
        }
        return list;
    }
}
