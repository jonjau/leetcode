package tdc2.wk3;


/**
 * Given a circular array C of integers represented by A, find the maximum possible sum of a
 * non-empty subarray of C.
 * <p>
 * Here, a circular array means the end of the array connects to the beginning of the array.
 * (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 * <p>
 * Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally,
 * for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length
 * = k2 % A.length.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 * <p>
 * Example 2:
 * <p>
 * Input: [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 * <p>
 * Example 3:
 * <p>
 * Input: [3,-1,2,-1]
 * Output: 4
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 * <p>
 * Example 4:
 * <p>
 * Input: [3,-2,2,-3]
 * Output: 3
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 * <p>
 * Example 5:
 * <p>
 * Input: [-2,-3,-1]
 * Output: -1
 * Explanation: Subarray [-1] has maximum sum -1
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * -30000 <= A[i] <= 30000
 * 1 <= A.length <= 30000
 * <p>
 * For those of you who are familiar with the Kadane's algorithm, think in terms of that. For
 * the newbies, Kadane's algorithm is used to finding the maximum sum subarray from a given
 * array. This problem is a twist on that idea and it is advisable to read up on that algorithm
 * first before starting this problem. Unless you already have a great algorithm brewing up in
 * your mind in which case, go right ahead!
 * <p>
 * What is an alternate way of representing a circular array so that it appears to be a straight
 * array? Essentially, there are two cases of this problem that we need to take care of. Let's
 * look at the figure below to understand those two cases:
 * <p>
 * The first case can be handled by the good old Kadane's algorithm. However, is there a smarter
 * way of going about handling the second case as well?
 */
public class MaximumSumCircularSubarray {
    public static int run() {
        int[] nums = {-2,-3,-1};
        int ans = maximumSumCircularSubarray1(nums);
        System.out.println(ans);
        return ans;
    }

    /**
     * Separate Kadane's into two cases: wrapping and non-wrappingA
     * <p>
     *     O(n) time, O(1) space
     * </p>
     * @param A an array of integers
     * @return the maximum subarray sum in A, allowing wrapping.
     */
    public static int maximumSumCircularSubarray1(int[] A) {
        // it is given that A has at least 1 element
        int maxSum = kadane(A);
        int minSum = kadaneMin(A);
        int totalSum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : A) {
            totalSum += num;
            max = Math.max(max, num);
        }
        // maxSum being non-positive means all elements are non-positive
        // but we must return something: just return the closest number to 0
        if (maxSum <= 0) {
            return max;
        }
        // case 1: if max subarray does not wrap, it's just classic Kadane's
        // case 2: else, maximum subsum is total sum - minimum subsum
        return Math.max(maxSum, totalSum - minSum);
    }

    /**
     * Classic Kadane's
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param nums an array of integers
     * @return the maximum subarray sum in nums
     */
    public static int kadane(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for (int num : nums) {
            maxEndingHere += num;
            // if maxEndingHere is negative, reset to 0:
            // essentially "resetting" the subarray being considered,
            // previous subarray no longer "worth it", unambiguously.
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            } else if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
        }
        return maxSoFar;
    }

    /**
     * Kadane's, but for finding the minimum subarray sum in the array
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param nums an array of integers
     * @return the minimum subarray sum in nums
     */
    public static int kadaneMin(int[] nums) {
        int minSoFar = Integer.MAX_VALUE;
        int minEndingHere = 0;
        for (int num : nums) {
            minEndingHere += num;
            // if minEndingHere is positive, reset to 0:
            // essentially "resetting" the subarray being considered,
            // previous subarray no longer "worth it", unambiguously.
            if (minEndingHere > 0) {
                minEndingHere = 0;
            } else if (minEndingHere < minSoFar) {
                minSoFar = minEndingHere;
            }
        }
        return minSoFar;
    }
}
