package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem No. #106
 * Difficulty: Medium
 * Description: Construct Binary Tree from Inorder and Postorder Traversal
 * Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class TreeFromInorderPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return splitTree(postorder, postorder.length - 1, 0, inorder.length - 1, inOrderMap);
    }

    public TreeNode splitTree(int[] postorder, int rootIndex, int left, int right, Map<Integer, Integer> inOrderMap) {

        if(left > right) return null;

        TreeNode root = new TreeNode(postorder[rootIndex]);

        int mid = inOrderMap.get(postorder[rootIndex]);

        root.right = splitTree(postorder, rootIndex - 1, mid + 1, right, inOrderMap);

        root.left = splitTree(postorder, rootIndex - (right - mid) - 1, left, mid - 1, inOrderMap);

        return root;
    }
}