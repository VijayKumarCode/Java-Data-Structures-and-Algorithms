package BinaryTree;

/**
 * Problem No. #112
 * Difficulty: Easy
 * Description: Path Sum
 * Link: https://leetcode.com/problems/path-sum/
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 */

class PathSumSolver {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: If the node is null, no path exists
        if (root == null) {
            return false;
        }

        // Check if we are at a leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Recursive call for left and right children with updated sum
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}