package tdc.wk1;

import tiq.util.ArrayUtils;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {

    public static void run() {
        int[] nums = {0,1,0,3,12};
        moveZeroes1(nums);
        ArrayUtils.printIntArray(nums);
    }
    
    /**
     * "slow" and "fast" pointer, with swapping
     * <p>
     * O(n) time, O(1) space
     */
    public static void moveZeroes1(int[] nums) {

        // slow tracks the position one after end of consecutive non-zero elements
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
    }
}