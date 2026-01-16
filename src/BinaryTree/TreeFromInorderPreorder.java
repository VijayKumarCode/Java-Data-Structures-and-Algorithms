package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem No. #105
 * Difficulty: Medium
 * Description: Construct Binary Tree from Preorder and Inorder Traversal
 * Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class TreeFromInorderPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return splitTree(preorder, 0, 0, inorder.length - 1, inOrderMap);
    }

    public TreeNode splitTree(int[] preOrder, int rootIndex, int left, int right, Map<Integer, Integer> inOrderMap) {
        TreeNode root = new TreeNode(preOrder[rootIndex]);
        int mid = inOrderMap.get(preOrder[rootIndex]);

        if (mid > left) {
            root.left = splitTree(preOrder, rootIndex + 1, left, mid - 1, inOrderMap);
        }
        if (mid < right) {
            // Skips root and the size of the left subtree (mid - left) to find the right child in preorder
            root.right = splitTree(preOrder, rootIndex + mid - left + 1, mid + 1, right, inOrderMap);
        }
        return root;
    }
}