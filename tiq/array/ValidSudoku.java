package tiq.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules: Each row must contain the digits
 * 1-9 without repetition. Each column must contain the digits 1-9 without
 * repetition. Each of the 9 3x3 sub-boxes of the grid must contain the digits
 * 1-9 without repetition.
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily
 * solvable. Only the filled cells need to be validated according to the
 * mentioned rules. The given board contain only digits 1-9 and the character
 * '.'. The given board size is always 9x9.
 */
public class ValidSudoku {

    public static boolean run() {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean ans = validSudoku(board);
        System.out.println(ans);
        return ans;
    }

    /**
     * Build a set, while verifying validity
     * O(n^2) time, O(n^2) space ??
     * where n is the number of cells on one side of the sudoku square, so 9.
     */
    public static boolean validSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                        !seen.add(number + " in col " + j) ||
                        !seen.add(number + " in block " + i / 3 + "-" + j / 3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}