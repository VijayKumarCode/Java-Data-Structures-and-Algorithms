package Array;

/**
 * Problem No.#055.
 * Difficulty: Medium
 * Description : Jump Game
 * Link: https://leetcode.com/problems/jump-game/
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class JumpToEnd {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;

        int tg = nums.length-1;
        int i = tg;

        while(i-- > 0) {
            if(i+nums[i] >= tg) {
                tg = i;
            }
        }
        return tg == 0;
    }
}