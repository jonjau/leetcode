package tdc2.wk2;

import java.util.function.Function;

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the
 * coordinate of a point. Check if these points make a straight line in the XY plane.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 * <p>
 * Hints:
 * - If there're only 2 points, return true.
 * - Check if all other points lie on the line defined by the first 2 points.
 * - Use cross product to check collinearity.
 */
public class CheckIfItIsAStraightLine {
    public static boolean run() {
        int[][] coordinates = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        boolean ans = checkIfItIsAStraightLine1(coordinates);
        System.out.println(ans);
        return ans;
    }

    /**
     * calculates the dot product between two vectors.
     * Assumes v1 and v2 are non-null
     *
     * @param v1 first vector
     * @param v2 second vector
     * @return the dot product
     */
    private static int dotProduct(int[] v1, int[] v2) {
        int n = Math.min(v1.length, v2.length);
        int dotProduct = 0;
        for (int i = 0; i < n; i++) {
            dotProduct += v1[i] * v2[i];
        }
        return dotProduct;
    }

    /**
     * gradient checks
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param coordinates 2D array of ints representing coordinates of 2D points
     * @return whether the points form a straight line
     */
    public static boolean checkIfItIsAStraightLine1(int[][] coordinates) {
        // for completeness
        if (coordinates == null || coordinates.length <= 2 || coordinates[0].length != 2) {
            return false;
        }
        int[] p1 = coordinates[0];
        int[] p2 = coordinates[1];
        // m = (y2-y1)/(x2-x1)
        // for three points (x1,y1), (x2, y2), (x3, y3) to be on the same line,
        // gradient from first to second must equal the gradient from first to third:
        // (y2-y1)/(x2-x1) = (y3-y1)/(x3-x1) =>
        // (y2-y1)*(x3-x1) = (y3-y1)*(x2-x1) => straight line
        for (int i = 2; i < coordinates.length; i++) {
            int[] p3 = coordinates[i];
            if ((p2[1] - p1[1]) * (p3[0] - p1[0]) != (p3[1] - p1[1]) * (p2[0] - p1[0])) {
                return false;
            }
        }
        return true;
    }
}
