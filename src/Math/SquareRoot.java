package Math;
/**
 * Problem: 69. Sqrt(x)
 * Method: Linear Search 
 * Time  Complexity:O(√x)
 * Space Complexity: O(1)
 * Description: Computes the square root of x using a for-loop.
 * Note: Uses division-based check to prevent integer overflow.
 */
class SquareRoot {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int count = 0;
        for (long i = 1; i * i <= x ; i++) {
            count = (int) i;
        }
        return count;
    }
}