/**
 * LeetCode 54: Spiral Matrix
 * Difficulty: Medium
 * * Approach: Simulation with Four Pointers
 * 1. Define 'top', 'bottom', 'left', and 'right' boundaries.
 * 2. Traverse from left to right, then increment 'top'.
 * 3. Traverse from top to bottom, then decrement 'right'.
 * 4. Traverse from right to left, then decrement 'bottom'.
 * 5. Traverse from bottom to top, then increment 'left'.
 * 6. Repeat until boundaries overlap.
 */
package Array;
import java.util.ArrayList;
import java.util.List;
class SpiralClockWise {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0) return list;
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0;
        int bottom = row-1;
        int left = 0;
        int right= col -1;
        int dir = 0;
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    list.add(matrix[top][i]);
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    list.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            } else if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir+1)%4;
        }
        return list;
    }
}