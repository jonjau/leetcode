package tdc.wk3;

import java.util.Stack;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    public static int run() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int ans = minimumPathSum1(grid);
        System.out.println(ans);
        return ans;
    }

    /**
     * DP approach
     * <p>
     *     O(n*m)  time, O(1) space
     * </p>
     * @param grid a 2D array of integers
     * @return the sum of the integers that make up a path from the top left to the bottom right
     *         of the grid
     */
    public static int minimumPathSum1(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (row == 0 && col == 0) {
                    continue;
                } else if (row == 0) {
                    grid[row][col] = grid[row][col] + grid[row][col - 1];
                } else if (col == 0) {
                    grid[row][col] = grid[row][col] + grid[row - 1][col];
                } else {
                    grid[row][col] = grid[row][col] + Math.min(grid[row-1][col], grid[row][col-1]);
                }
            }
        }
        return grid[height - 1][width - 1];
    }
}
