package Array;

/**
 * Problem No. #45
 * Difficulty: Medium
 * Description: Jump Game II
 * Link: https://leetcode.com/problems/jump-game-ii/
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class JumpToEndII {
    public int jump(int[] nums) {
        // Base case: If we are already at the start/end, no jumps needed
        if (nums.length < 2) {
            return 0;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // Iterate through the array (except the last element)
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the furthest we can potentially reach
            farthest = Math.max(farthest, i + nums[i]);

            // When we reach the boundary of our current jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // Optimization: If we can already reach the end, stop
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}
