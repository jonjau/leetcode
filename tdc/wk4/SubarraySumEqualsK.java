package tdc.wk4;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous
 * subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * <p>
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * Note:
 * <p>
 * The length of the array is in range [1, 20,000]. The range of numbers in the array is [-1000,
 * 1000] and the range of the integer k is [-1e7, 1e7].
 */
public class SubarraySumEqualsK {
    public static int run() {
        int nums[] = {1,1,1};
        int k = 2;
        int ans = subarraySumEqualsK1(nums, k);
        System.out.println(ans);
        return ans;
    }

    /**
     * G4G: Subsum HashMap approach
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param nums an array of integers
     * @param k    the target sum
     * @return the number of subarrays (can overlap) in nums that sum up to k
     */
    public static int subarraySumEqualsK1(int[] nums, int k) {
        // HashMap to store number of subarrays starting from index zero having particular sum
        HashMap<Integer, Integer> prevSumsCounts = new HashMap<>();

        int nTargetSumSubarrays = 0;
        // Sum of elements so far.
        int currSum = 0;

        for (int num : nums) {

            // Add current element to sum so far.
            currSum += num;

            // If currSum is equal to desired sum, then a new subarray is found. So increase count
            // of subarrays.
            if (currSum == k) {
                nTargetSumSubarrays++;
            }

            // currSum exceeds given sum by currSum - sum.
            // Find number of subarrays having this sum (subarrays of sum 0 also considered here)
            // and exclude those subarrays from currSum by increasing the number of desired-sum
            // subarrays by the number of (currSum - sum) subarrays previously seen
            if (prevSumsCounts.containsKey(currSum - k)) {
                nTargetSumSubarrays += prevSumsCounts.get(currSum - k);
            }

            // Increment prevSumCount[currSum] if seen before, else put 1
            prevSumsCounts.put(currSum, prevSumsCounts.getOrDefault(currSum, 0) + 1);
        }
        return nTargetSumSubarrays;
    }
}
