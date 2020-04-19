package tdc.wk3;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return
 * -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public static int run() {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int ans = searchInRotatedSortedArray1(nums, target);
        System.out.println(ans);
        return ans;
    }

    /**
     * binary search with more confusing checks
     * <p>
     * O(logn) time, O(1) space
     * </p>
     *
     * @param nums   a sorted int array that has been rotated at some pivot
     * @param target the int to be found
     * @return the index of target in the array, or -1 if not found
     */
    public static int searchInRotatedSortedArray1(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            // avoid overflow
            int mid = lo + (hi - lo) / 2;
            // we're done
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[hi]) {
                // there is rotation, and the sorted part and the actual median is left of mid
                if (nums[lo] <= target && target < nums[mid]) {
                    // target in left half: decrease hi
                    hi = mid - 1;
                } else {
                    // target in right half: increase lo
                    lo = mid + 1;
                }
            } else if (nums[mid] < nums[lo]) {
                // there is rotation, and the sorted part and the actual median is right of mid
                if (nums[mid] < target && target <= nums[hi]) {
                    // target in right half: increase lo
                    lo = mid + 1;
                } else {
                    // target in left half: decrease hi
                    hi = mid - 1;
                }
            } else {
                // no rotation, proceed like normal binary search
                if (target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        // not found
        return -1;
    }
}
