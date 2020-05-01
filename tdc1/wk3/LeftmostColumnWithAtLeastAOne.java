package tdc1.wk3;

import java.util.Arrays;
import java.util.List;

/**
 * (This problem is an interactive problem.)
 * <p>
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this
 * row is sorted in non-decreasing order.
 * <p>
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at
 * least a 1 in it. If such index doesn't exist, return -1.
 * <p>
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix
 * interface:
 * <p>
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n *
 * m.
 * <p>
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also,
 * any solutions that attempt to circumvent the judge will result in disqualification.
 * <p>
 * For custom testing purposes you're given the binary matrix mat as input in the following four
 * examples. You will not have access the binary matrix directly.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 * <p>
 * Example 2:
 * <p>
 * Input: mat = [[0,0],[0,1]] Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: mat = [[0,0],[0,0]] Output: -1
 * <p>
 * Example 4:
 * <p>
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]] Output: 1
 * <p>
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= mat.length, mat[i].length <= 100 mat[i][j] is either 0 or 1. mat[i] is sorted in a
 * non-decreasing way.
 * <p>
 * Hide Hint #1 1. (Binary Search) For each row do a binary search to find the leftmost one on
 * that row and update the answer. Hide Hint #2 2. (Optimal Approach) Imagine there is a pointer
 * p(x, y) starting from top right corner. p can only move left or down. If the value at p is 0,
 * move down. If the value at p is 1, move left. Try to figure out the correctness and time
 * complexity of this algorithm.
 */

public class LeftmostColumnWithAtLeastAOne {
    // #j my naive implementation, good enough to simulate the examples
    private static class BinaryMatrix {
        int[][] grid;

        public BinaryMatrix(int[][] grid) {
            assert grid != null;
            assert grid[0] != null;
            this.grid = grid;
        }

        public int get(int x, int y) {
            return this.grid[x][y];
        }

        public List<Integer> dimensions() {
            return Arrays.asList(grid.length, grid[0].length);
        }
    }

    public static int run() {
        int[][] grid = {{0,0,0,1},
                        {0,0,1,1},
                        {0,1,1,1}};
        BinaryMatrix mat = new BinaryMatrix(grid);
        int ans = leftmostColumnWithAtLeastAOne(mat);
        System.out.println(ans);
        return ans;
    }

    /**
     * Based on hint #2
     * <p>
     * O(??) time, O(1) space
     * </p>
     *
     * @param binaryMatrix see problem spec
     * @return the index of the leftmost column with a 1, -1 if no such column
     */
    public static int leftmostColumnWithAtLeastAOne(BinaryMatrix binaryMatrix) {
        int result = -1;
        if (binaryMatrix == null) {
            return result;
        }
        List<Integer> dimList = binaryMatrix.dimensions();
        int nRows = dimList.get(0);
        int nCols = dimList.get(1);
        int i = 0;
        int j = nCols - 1;
        while (i < nRows && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) {
                result = j;
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}
