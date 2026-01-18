package BinaryTree;

/**
 * Problem No. #129
 * Difficulty: Medium
 * Description: Sum Root to Leaf Numbers
 * Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return depthFirstSearch(root, 0);
    }

    public int depthFirstSearch(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }

        // Standard formula to shift digits and add the current value
        currentSum = currentSum * 10 + root.val;

        // If a leaf is reached, the full number for this path is complete
        if (root.left == null && root.right == null) {
            return currentSum;
        }

        return depthFirstSearch(root.left, currentSum) + depthFirstSearch(root.right, currentSum);
    }
}