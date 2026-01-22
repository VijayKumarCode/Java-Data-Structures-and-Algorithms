package BitManupulation;

/*
Problem No. #201
Difficulty: Medium
Description: Bitwise AND of Numbers Range
Link: https://leetcode.com/problems/bitwise-and-of-numbers-range/
Time Complexity: $O(\log n)$
Space Complexity: $O(1)$
*/

class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        // Shift both numbers to the right until they are equal
        // This finds the common binary prefix
        while (left != right) {
            left >>= 1;
            right >>= 1;
            count++;
        }
        // Shift back to the left to restore the prefix to its original position
        return (left << count);
    }
}