package Array;

import java.util.HashSet;

import java.util.Set;

/**
 * Problem No.#36 - Valid Sudoku
 * Difficulty: Medium
 * Description: Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the Sudoku rules.
 */

class IsValidSudoku {
    
    public boolean isValidSudoku(char[][] board) {
        
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                // Skip empty cells
                if (board[i][j] == '.') continue;
                
                // Create unique string identifiers
                String row = board[i][j] + " _in_row_" + i;
                String col = board[i][j] + "_in_col_" + j;
                String box = board[i][j] + "_in_box_" + (i / 3) + "_" + (j / 3);
                
                // Check for duplicates in one step
                if (set.contains(row) || set.contains(col) || set.contains(box)) {
                    return false;
                }
                
                // Add to the set to record that we've seen this number
                set.add(row);
                set.add(col);
                set.add(box);
            }
        }
        return true;
    }
}
