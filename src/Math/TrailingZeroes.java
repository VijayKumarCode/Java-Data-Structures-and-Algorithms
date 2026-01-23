package Math;

/*
Problem No. #172
Difficulty: Easy
Description: Factorial Trailing Zeroes
Link: https://leetcode.com/problems/factorial-trailing-zeroes/
Time Complexity: $O(\log_5 n)$
Space Complexity: $O(1)$
*/

class TrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        // We count how many factors of 5 are in n!
        // because each pair of (2 * 5) creates a trailing zero.
        while (n > 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }
}