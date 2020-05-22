package tdc2.wk3;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: matrix =
 * [
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * <p>
 * Example 2:
 * <p>
 * Input: matrix =
 * [
 * [1,0,1],
 * [1,1,0],
 * [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 * <p>
 * Hide Hint #1
 * Create an additive table that counts the sum of elements of submatrix with the superior corner at (0,0).
 * Hide Hint #2
 * Loop over all subsquares in O(n^3) and check if the sum make the whole array to be ones, if it
 * checks then add 1 to the answer.
 */
public class CountSquareSubmatricesWithAllOnes {
    public static int run() {
        int[][] matrix = {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        int ans = countSquares1(matrix);
        System.out.println(ans);
        return ans;
    }

    /**
     * https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/643429/Python-DP-Solution-+-Thinking-Process-Diagrams-(O(mn)-runtime-O(1)-space)
     * dynamic programming
     * <p>
     * O(mn) time, O(1) space
     * </p>
     * @param matrix n by m matrix of 1 and 0s
     * @return the number of square submatrices have all 1s.
     */
    public static int countSquares1(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    // first row or first col
                    if (i == 0 || j == 0) {
                        result += 1;
                    } else {
                        int cell_val = Math.min(matrix[i - 1][j - 1],
                                Math.min(matrix[i][j - 1], matrix[i - 1][j])) + matrix[i][j];
                        result += cell_val;
                        // memoize the updated result
                        matrix[i][j] = cell_val;
                    }
                }
            }
        }
        return result;
    }
}
