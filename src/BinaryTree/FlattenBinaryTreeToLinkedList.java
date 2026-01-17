package BinaryTree;

import java.util.ArrayList;
import java.util.List;
/*
Problem No. #114
Difficulty: Medium
Description: Flatten Binary Tree to Linked List
Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
Time Complexity: O(n)
Space Complexity: O(n)
*/



class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;

        List<TreeNode> nodes = new ArrayList<>();
        preorder(root, nodes);

        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).left = null;
            nodes.get(i).right = nodes.get(i + 1);
        }

        // Ensure the last node's children are cleared
        if (!nodes.isEmpty()) {
            nodes.get(nodes.size() - 1).left = null;
            nodes.get(nodes.size() - 1).right = null;
        }
    }

    private void preorder(TreeNode root, List<TreeNode> nodes) {
        if (root == null) return;
        nodes.add(root);
        preorder(root.left, nodes);
        preorder(root.right, nodes);
    }
}
