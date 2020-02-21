package tiq.sortingandsearching;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately,
 * the latest version of your product fails the quality check. Since each version is developed based
 * on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which
 * causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to
 * the API.
 * <p>
 * Example:
 * <p>
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 */
public class FirstBadVersion {
    public static int run() {
        return firstBadVersion1(5);
    }

    /**
     * Finds the first bad version in versions [1, ... n]
     * <p>
     * O(logn) time, O(1) space
     * </p>
     * <p>
     * In our case, we indicate left and right as the boundary of our search space
     * (both inclusive). How about the terminating condition? We could guess that left and
     * right eventually both meet and it must be the first bad version, but how could you
     * tell for sure?
     * <p>
     * The formal way is to prove by induction, which you can read up yourself if you are
     * interested. Here is a helpful tip to quickly prove the correctness of your binary search
     * algorithm during an interview. We just need to test an input of size 2. Check if it reduces
     * the search space to a single element (which must be the answer) for both of the scenarios
     * above. If not, your algorithm will never terminate.
     *
     * @param n integer indicating the latest version
     * @return the first bad version
     */
    public static int firstBadVersion1(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // unlike (LEFT + RIGHT)/2, this avoids overflow
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                // continue, mid might not be the first bad version
                right = mid;
            } else {
                // continue, mid isn't bad so +1
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * Hardcoded boolean check so code compiles
     * @param version the version to be checked
     * @return whether given version is "bad"
     */
    private static boolean isBadVersion(int version) {
        if (version == 5) {
            return true;
        }
        return false;
    }
}
