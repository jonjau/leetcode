package tiq.array;

import tiq.util.ArrayUtils;

/**
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 */
public class RotateArray {

    private static int[] array;
    public static void setup(int n) {
        array = ArrayUtils.nonnegatives(n, 100);
    }

    public static int[] run() {
        //int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        //System.out.println(Arrays.toString(array));
        rotateArray1(array, k);
        //System.out.println(Arrays.toString(array));
        return array;
    }

    /** 
     * O(n) time, O(1) space.
     * 
     * n elements are reversed three times in practice
     * rotateArray1 scales much better than rotateArray2, not sure why.
     */
    public static void rotateArray1(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public static void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Using cyclic replacements, look up the details
    // O(n) time, O(1) space
    public static void rotateArray2(int[] nums, int k) {
        k = k % nums.length;
        // the number of swapping that has been done
        int swapCount = 0;
        // having swapped every item once implies that rotation is complete
        for (int startIndex = 0; swapCount < nums.length; startIndex++) {
            int currentIndex = startIndex;
            int currItem = nums[startIndex];
            do {
                // swap current item with the next item, k positions after
                int nextIndex = (currentIndex + k) % nums.length;

                int temp = nums[nextIndex];
                nums[nextIndex] = currItem;
                currItem = temp;

                currentIndex = nextIndex;
                swapCount++;
                // continue swapping until it wraps around
            } while (startIndex != currentIndex);
        }
    }
}