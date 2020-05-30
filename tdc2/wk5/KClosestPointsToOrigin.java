package tdc2.wk5;

import java.util.Arrays;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the
 * order that it is in.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * <p>
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class KClosestPointsToOrigin {
    public static int[][] run() {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] ans = kClosestPointToOrigin1(points, k);
        return ans;
    }

    public static int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    /**
     * <p>
     *     O(nlogn) time, O(n) space
     * </p>
     * @param points 2d array representing points
     * @param k refer to question
     * @return the k closest points to the origin (euclidean distance)
     */
    public static int[][] kClosestPointToOrigin1(int[][] points, int k) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[k-1];

        int[][] ans = new int[k][2];
        int t = 0;
        for (int[] point : points)
            if (dist(point) <= distK)
                ans[t++] = point;
        return ans;
    }
}
