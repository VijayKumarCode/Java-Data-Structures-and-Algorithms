package BitManupulation;

/*
Problem No. #191
Difficulty: Easy
Description: Number of 1 Bits
Link: https://leetcode.com/problems/number-of-1-bits/
Time Complexity: O(1)
Space Complexity: O(1)
*/

class HammingWeightCalculator {
    public int hammingWeight(int n) {
        int count = 0;
        // Since integers in Java are 32-bit, we iterate 32 times
        for (int i = 0; i < 32; i++) {
            // Check if the least significant bit is 1
            count += (n & 1);
            // Logical shift right by 1 to process the next bit
            n >>>= 1;
        }
        return count;
    }
}
