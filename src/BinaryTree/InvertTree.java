package BinaryTree;

/**
 * Problem No. #226
 * Difficulty: Easy
 * Description: Invert Binary Tree
 * Link: https://leetcode.com/problems/invert-binary-tree/
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}