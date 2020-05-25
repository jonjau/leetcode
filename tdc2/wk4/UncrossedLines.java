package tdc2.wk4;

/**
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 * <p>
 * Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such
 * that:
 * <p>
 * A[i] == B[j];
 * The line we draw does not intersect any other connecting (non-horizontal) line.
 * <p>
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong
 * to one connecting line.
 * <p>
 * Return the maximum number of connecting lines we can draw in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,4,2], B = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line
 * from A[2]=2 to B[1]=2.
 * <p>
 * Example 2:
 * <p>
 * Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * Output: 3
 * <p>
 * Example 3:
 * <p>
 * Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * Output: 2
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 500
 * 1 <= B.length <= 500
 * 1 <= A[i], B[i] <= 2000
 * Hide Hint #1
 * Think dynamic programming. Given an oracle dp(i,j) that tells us how many lines A[i:], B[j:] [the
 * sequence A[i], A[i+1], ... and B[j], B[j+1], ...] are uncrossed, can we write this as a
 * recursion?
 */
public class UncrossedLines {
    public static int run() {
        int[] A = {1, 3, 7, 1, 7, 5};
        int[] B = {1, 9, 2, 5, 1};
        int ans = uncrossedLines1(A, B);
        System.out.println(ans);
        return ans;
    }

    /**
     * Same as longest common subsequence, apparently
     * <p>
     * O(n^2) time, O(n^2) space
     * </p>
     *
     * @param A an array of integers
     * @param B an array of integers
     * @return "the longest common subsequence"
     */
    public static int uncrossedLines1(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        // as usual in dp, doing n+1 and starting from i=1 allows us to omit
        // the i==0 j==0 special
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
