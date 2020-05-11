package tdc2.wk2;

import java.util.Arrays;
import java.util.Stack;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of
 * the image (from 0 to 65535).
 * <p>
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
 * and a pixel value newColor, "flood fill" the image.
 * <p>
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally
 * to the starting pixel of the same color as the starting pixel, plus any pixels connected
 * 4-directionally to those pixels (also with the same color as the starting pixel), and so on.
 * Replace the color of all of the aforementioned pixels with the newColor.
 * <p>
 * At the end, return the modified image.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * <p>
 * Note:
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 * <p>
 * Hint:
 * Write a recursive function that paints the pixel if it's the correct color, then recurses on
 * neighboring pixels.
 */
public class FloodFill {
    public static class Tuple<X, Y> {
        public final X x;
        public final Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] run() {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] ans = floodFill1(image, sr, sc, newColor);
        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
        return ans;
    }

    /**
     * Explicit DFS
     * <p>
     * O(n) time , O(n) space, where n is the number of pixels in the image
     * </p>
     *
     * @param image    a 2d array of integers representing colored pixels
     * @param sr       row of the initial cell
     * @param sc       column of the initial cell
     * @param newColor the new color to be used in the flood fill
     * @return the image after flood filling
     */
    public static int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        int targetColor = image[sr][sc];
        if (targetColor == newColor) {
            return image;
        }
        Stack<Tuple<Integer, Integer>> stack = new Stack<>();
        stack.push(new Tuple<>(sr, sc));
        while (!stack.isEmpty()) {
            Tuple<Integer, Integer> currCell = stack.pop();
            int currRow = currCell.x;
            int currCol = currCell.y;
            if (image[currRow][currCol] == targetColor) {
                image[currRow][currCol] = newColor;
                if (currRow - 1 >= 0) {
                    stack.push(new Tuple<>(currRow - 1, currCol));
                }
                if (currCol - 1 >= 0) {
                    stack.push(new Tuple<>(currRow, currCol - 1));
                }
                if (currRow + 1 < image.length) {
                    stack.push(new Tuple<>(currRow + 1, currCol));
                }
                if (currCol + 1 < image[0].length) {
                    stack.push(new Tuple<>(currRow, currCol + 1));
                }
            }
        }
        return image;
    }
}
