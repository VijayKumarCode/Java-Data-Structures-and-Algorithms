package Array;

/**
 * Problem No. #45
 * Difficulty: Medium
 * Description: Jump Game II
 * Link: https://leetcode.com/problems/jump-game-ii/
 * Time Complexity: $O(n)$
 * Space Complexity: $O(1)$
 */
class JumpGameII {
    public int jump(int[] nums) {
        int farthest = 0;
        int end = 0;
        int jumps = 0;

        // We don't need to jump if we are already at the last index
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest point we can reach from the current index
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the range for the current jump
            if (i == end) {
                end = farthest;
                jumps++;
            }
        }

        return jumps;
    }
}
