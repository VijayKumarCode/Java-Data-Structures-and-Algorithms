/**
 * 🔍 LEETCODE 74: Search a 2D Matrix
 * ----------------------------------
 * PROBLEM: Write an efficient algorithm that searches for a value in an m x n 
 * matrix. This matrix has properties: Integers in each row are sorted from 
 * left to right. The first integer of each row is greater than the last 
 * integer of the previous row.
 * * ALGORITHM STRATEGY: Flattened Binary Search
 * 1. Virtual 1D Array: Treat the m x n matrix as a sorted list of length m*n.
 * 2. Mapping: Convert mid index to 2D using [mid / cols] and [mid % cols].
 * 3. Standard Binary Search: Adjust low/high based on comparison.
 *
 * COMPLEXITY ANALYSIS:
 * - Time Complexity: O(log(m * n)) -> Standard binary search efficiency.
 * - Space Complexity: O(1) -> Performed in-place.
 */
class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols-1;
        while(low <= high) {
            int mid = low + (high -low)/2;
            int i = mid/matrix[0].length;
            int j = mid%matrix[0].length;
            if(matrix[i][j] == target) {
                return true;
            }
            else if(matrix[i][j] < target){
                 low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}