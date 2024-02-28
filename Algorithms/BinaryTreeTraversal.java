package Algorithms;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}


public class BinaryTreeTraversal {
    List<Integer> preOrder = new ArrayList<>();
    List<Integer> inOrder = new ArrayList<>();
    List<Integer> postOrder = new ArrayList<>();

    // [Root[Left][Right]]
    void preorderTraversal(TreeNode node) {
        if (node == null) return;

        preOrder.add(node.value);// Visit the root
        preorderTraversal(node.left); // Traverse left subtree
        preorderTraversal(node.right); // Traverse right subtree
    }

    // [[Left]Root[right]]
    void inorderTraversal(TreeNode node) {
        if (node == null) return;

        inorderTraversal(node.left); // Traverse left subtree
        inOrder.add(node.value); // Visit the root
        inorderTraversal(node.right); // Traverse right subtree
    }

    // [[Left][Right]Root]
    void postorderTraversal(TreeNode node) {
        if (node == null) return;

        postorderTraversal(node.left); // Traverse left subtree
        postorderTraversal(node.right); // Traverse right subtree
        postOrder.add(node.value); // Visit the root
    }


}
