package tdc.wk2;

import java.util.HashMap;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and
 * 1.
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 2:
 * <p>
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousArray {
    public static int run() {
        int[] nums1 = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0};
        int[] nums2 = {0, 0, 1, 0, 0, 0, 1, 1};
        int ans = contiguousArray2(nums2);
        System.out.println(ans);
        return ans;
    }

    /**
     * Brute force nested loops
     * <p>
     * O(n^2) time, O(1) space
     * </p>
     *
     * @param nums an array of integers (either 0 or 1)
     * @return the length of the largest subarray in nums where the number of 0s equal the number
     * of 1s
     */
    public static int contiguousArray1(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int maxLength = 0;
        // pick a starting index
        for (int i = 0; i < n - 1; i++) {
            sum = (nums[i] == 0) ? -1 : 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == 0) {
                    sum += -1;
                } else if (nums[j] == 1) {
                    sum += 1;
                }
                // potential new maxLength
                if (sum == 0 && maxLength < j - i + 1) {
                    maxLength = j - i + 1;
                }
            }
        }
        return maxLength;
    }

    /**
     * https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
     * Reducing the problem to:
     * 1. creating an array of subarray sums starting from index 0, say sub_sums
     * 2. finding the maximum j-i such that sub_sums[j] == sub_sums[i]
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param nums an array of integers (either 0 or 1)
     * @return the length of the largest subarray in nums where the number of 0s equal the number
     * of 1s
     */
    public static int contiguousArray2(int[] nums) {
        // map of subarray sums and their starting index
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int n = nums.length;
        int sum = 0;     // Initialize sum of elements
        int maxLength = 0; // Initialize result

        // Traverse through the given array
        for (int i = 0; i < n; i++) {
            // Interpret 0s as -1s
            nums[i] = (nums[i] == 0) ? -1 : 1;
            // Add current element to sum
            sum += nums[i];
            // To handle sum=0 at last index
            if (sum == 0) {
                maxLength = i + 1;
            }

            // If this sum is seen before, then update max_len if required
            // #j I think sum + n is to prevent sum == 0 from getting into the hashmap.
            if (map.containsKey(sum + n)) {
                if (maxLength < i - map.get(sum + n)) {
                    maxLength = i - map.get(sum + n);
                }
            } else // Else put this sum in hash table
                map.put(sum + n, i);
        }
        // convert -1s back to 0s
        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] == -1) ? 0 : 1;
        }
        return maxLength;
    }
}
