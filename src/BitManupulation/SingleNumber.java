package BitManupulation;

/**
 Problem No. #136
 Difficulty: Easy
 Description: Single Number
 Link: https://leetcode.com/problems/single-number/
 Time Complexity: O(n)
 Space Complexity: O(1)
 */

class SingleNumber {
    public int singleNumber(int[] nums) {
        // Since every element appears twice except for one,
        // XORing all numbers will cancel out the pairs (a ^ a = 0)
        // leaving only the single number (0 ^ x = x).
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}