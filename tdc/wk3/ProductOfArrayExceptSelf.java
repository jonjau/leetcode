package tdc.wk3;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is
 * equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * <p>
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array
 * (including the whole array) fits in a 32 bit integer.
 * <p>
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up: Could you solve it with constant space complexity? (The output array does not count as
 * extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    public static int[] run() {
        int[] nums = {1,2,3,4};
        int[] ans = productExceptSelf1(nums);
        tiq.util.ArrayUtils.printIntArray(ans);
        return ans;
    }

    /**
     * left and right products approach
     * <p>
     * O(n) time, O(1) space (output array doesn't count)
     * </p>
     *
     * @param nums an integer array of length > 1
     * @return the productExceptSelf array :v
     */
    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        // output[i] will initially be our "leftProducts'
        int[] output = new int[n];
        // note it is given that nums is at least two elements long
        output[0] = 1;
        for (int i = 1; i < n; i++) {
            // output[i] now contains the product of all the numbers to the strict left of nums[i]
            output[i] = output[i - 1] * nums[i - 1];
        }
        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            output[i] = output[i] * R;
            R *= nums[i];
        }
        return output;
    }
}
