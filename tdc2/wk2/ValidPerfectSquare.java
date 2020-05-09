package tdc2.wk2;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else
 * False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * <p>
 * Input: 16
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: 14
 * Output: false
 */
public class ValidPerfectSquare {
    public static boolean run() {
        // an actual test case: max int
        int num2 = 2147483647;
        boolean ans = validPerfectSquare1(num2);
        System.out.println(ans);
        return ans;
    }

    /**
     * Binary search approach
     * <p>
     * O(logn) time, O(1) space
     * </p>
     *
     * @param num a positive integer
     * @return whether num is a perfect square
     */
    public static boolean validPerfectSquare1(int num) {
        if (num <= 1) {
            return true;
        }
        long low = 1;
        long high = num;
        while (low <= high) {
            // must use long: the classic lo + (hi-lo)/2 would work,
            // but then we would still have to square mid (cannot use sqrt())
            long mid = low + (high - low) / 2;
            long mid_squared = mid * mid;
            if (mid_squared > num) {
                high = mid - 1;
            } else if (mid_squared < num) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
