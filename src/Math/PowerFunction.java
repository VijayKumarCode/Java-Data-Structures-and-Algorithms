package Math;

/**
 * LeetCode #50: Pow(x, n)
 * * Problem: Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 * Difficulty: Medium
 * * Algorithm: Binary Exponentiation (Exponentiation by Squaring)
 * Time Complexity: O(log n)
 * Space Complexity: O(1) - Iterative approach
 */
class PowerFunction {
    public double myPow(double x, int n) {
       long N = n;
       if(N < 0) {
        x = 1/x;
        N = -N;
       }
       double result = 1.0D;
       double currentNumber = x;
       while(N > 0) {
        if(N % 2 == 1) {
            result *= currentNumber;
        }
        currentNumber *= currentNumber;
        N /= 2;
       }
        return result;
    }
}
