package BitManupulation;

/**
 Problem No. #137
 Difficulty: Medium
 Description: Single Number II
 Link: https://leetcode.com/problems/single-number-ii/
 Time Complexity: O(n)
 Space Complexity: O(1)
 */

class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ones = 0; // Bits that have appeared exactly once
        int twos = 0; // Bits that have appeared exactly twice

        for (int num : nums) {
            // Update 'ones': XOR adds num to ones, but if it's already in 'twos', remove it.
            ones = (ones ^ num) & ~twos;

            // Update 'twos': XOR adds num to twos, but if it's in 'ones' (now updated), remove it.
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}