package tdc2.wk2;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly
 * twice, except for one element which appears exactly once. Find this single element that appears
 * only once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * <p>
 * <p>
 * <p>
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class SingleElementInSortedArray {
    public static int run() {
        int[] nums = {1,3,3,7,7,11,11};
        int ans = singleElementInSortedArray1(nums);
        System.out.println(ans);
        return ans;
    }

    /**
     * Binary search approach
     * <p>
     * O(logn) time, O(1) space
     * </p>
     *
     * @param nums sorted array of integers with all elements in pairs except for one
     * @return the one element not in a pair in the sorted array
     */
    public static int singleElementInSortedArray1(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // if mid is even and followed by the same number, or
            // if mid is odd and follows the same number,
            // single element is strictly to the right of mid
            if ((mid % 2 == 0 && mid + 1 < n && nums[mid] == nums[mid + 1]) ||
                    (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}
