package BinaryTree;

/**
 * Problem No. #124
 * Difficulty: Hard
 * Description: Binary Tree Maximum Path Sum
 * Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class PathSumSolverII {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        optimalPath(root);
        return maxSum;
    }

    public int optimalPath(TreeNode root) {
        if (root == null) return 0;

        // Post-order traversal: Calculate max gain from subtrees
        // We use Math.max(..., 0) to ignore paths that would decrease our total sum
        int leftSum = Math.max(optimalPath(root.left), 0);
        int rightSum = Math.max(optimalPath(root.right), 0);

        // Update the global maximum with the "Arch" (left gain + node + right gain)
        maxSum = Math.max(maxSum, (leftSum + root.val + rightSum));

        // Return the "Single Branch" to the parent (node + better of the two sides)
        return (root.val + Math.max(leftSum, rightSum));
    }
}
