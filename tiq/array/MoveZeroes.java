package tiq.array;

import tiq.array.util.RandomIntArray;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {

    public static void run() {
        int[] nums = {0,1,0,3,12};
        moveZeroes1(nums);
        RandomIntArray.printIntArray(nums);
    }
    
    /**
     * "slow" and "fast" pointer, with swapping
     * <p>
     * O(n) time, O(1) space
     */
    public static void moveZeroes1(int[] nums) {

        int lastNonZeroFoundAt = 0;
        int curr = 0;
        while (curr < nums.length) {
            if (nums[curr] != 0) {
                int temp = nums[lastNonZeroFoundAt];
                nums[lastNonZeroFoundAt] = nums[curr];
                nums[curr] = temp;
                lastNonZeroFoundAt++;
            }
            curr++;
        }
    }
}