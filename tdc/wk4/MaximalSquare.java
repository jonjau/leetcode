package tdc.wk4;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and
 * return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Output: 4
 */
public class MaximalSquare {
    public static int run() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int ans = maximalSquare1(matrix);
        System.out.println(ans);
        return ans;
    }

    /**
     * DP, bottom-up
     * <p>
     * O(nm) time, O(nm) space
     * </p>
     *
     * @param matrix
     * @return
     */
    public static int maximalSquare1(char[][] matrix) {
        if (matrix == null | matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int maxSquareLen = 0;

        // dp[i, j] represents the length of the square
        // whose lower-right corner is located at [i, j]
        // dp[i, j] = min( dp[i-1, j-1], dp[i-1, j], dp[i, j-1] )
        // three-way minimum of the cell to the left, above and diagonally to the upper left
        // ^^^ +1 +1 so dp[i-1][j-1] will always work
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    // if top, left, and topleft have minimum 1, and this one is 1, then we can
                    // extend our square, length=2, store in dp.
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    // update max as needed
                    maxSquareLen = Math.max(maxSquareLen, dp[i][j]);
                }
            }
        }
        return maxSquareLen * maxSquareLen;
    }
}
