package BitManupulation;

/*
Problem No. #190
Difficulty: Easy
Description: Reverse Bits
Link: https://leetcode.com/problems/reverse-bits/
Time Complexity: O(1)
Space Complexity: O(1)
*/

 class ReverseBits {
    public int reverseBits(int n) {
        // Swap 16-bit halves
        n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);

        // Swap 8-bit bytes within each half
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);

        // Swap 4-bit nibbles within each byte
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);

        // Swap 2-bit pairs within each nibble
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);

        // Swap adjacent bits
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);

        return n;
    }
}