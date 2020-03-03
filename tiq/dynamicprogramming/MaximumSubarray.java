package tiq.dynamicprogramming;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which
 * has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and
 * conquer approach, which is more subtle.
 */
public class MaximumSubarray {
    public static int run() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = maxSubArray1(nums);
        return ans;
    }

    /**
     * Given an array of integers, returns the maximum possible sum of a subarray in nums
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param nums an array of integers
     * @return the maximum sum of a subarray in nums
     */
    public static int maxSubArray1(int[] nums) {
        // maxSumSoFar is the maximum subarray sum so far
        // maxEndingHere is the current subarray sum being considered
        int maxSumSoFar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 0; i < nums.length; i++) {
            // add next number to current subarray sum or just fresh start
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSumSoFar = Math.max(maxEndingHere, maxSumSoFar);
        }
        return maxSumSoFar;
    }
}
