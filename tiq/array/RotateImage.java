package tiq.array;

import tiq.util.ArrayUtils;

public class RotateImage {
    public static void run() {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        ArrayUtils.print2DIntArray(matrix);
        rotateClockwise(matrix);
        ArrayUtils.print2DIntArray(matrix);
        rotateAntiClockwise(matrix);
        ArrayUtils.print2DIntArray(matrix);
    }

    /**
     * Reverses an array of T's.
     *
     * @param array array to be reversed
     * @param <T>   type of array elements
     */
    private static <T> void reverse(T[] array) {
        int frontIndex = 0;
        int backIndex = array.length - 1;
        while (frontIndex < backIndex) {
            T temp = array[frontIndex];
            array[frontIndex] = array[backIndex];
            array[backIndex] = temp;
            frontIndex++;
            backIndex--;
        }
    }

    /**
     * Rotates a square matrix of integers 90 degrees clockwise.
     * <p>
     * O(n^2) time approx., O(n) space approx.
     * where n is the length of one side of the square matrix.
     * </p>
     *
     * @param matrix 2D matrix of integers
     */
    public static void rotateClockwise(int[][] matrix) {
        reverse(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /**
     * Rotates a square matrix of integers 90 degrees anti-clockwise.
     * <p>
     * O(n^2) time approx., O(n) space approx.
     * where n is the length of one side of the square matrix.
     * </p>
     *
     * @param matrix 2D matrix of integers
     */
    public static void rotateAntiClockwise(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        reverse(matrix);
    }
}
