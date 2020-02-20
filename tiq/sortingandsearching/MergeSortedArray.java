package tiq.sortingandsearching;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may
 * assume that nums1 has enough space (size that is greater or equal to m + n) to hold
 * additional elements from nums2.
 * <p>
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public static void run() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        System.out.println("Merging these two arrays: ");
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println("Result array: ");
        merge1(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * Merges two sorted arrays of integers nums1 (length m) and nums2 (length n), into a sorted
     * array of integers nums1, assuming that nums1 has enough space (size that is greater or equal
     * to m + n) to hold additional elements from nums2.
     * <p>
     * O(n + m) time, O(1) space (no extra space allocated: see space assumption)
     * </p>
     *
     * @param nums1 sorted array of integers (merge result to be stored here)
     * @param m     length of nums1
     * @param nums2 sorted array of integers
     * @param n     length of nums2
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        // pos1 and pos2 keeps track of positions in nums1 and nums2 respectively
        int pos1 = m - 1;
        int pos2 = n - 1;
        int finalSize = m + n - 1;
        // WORK FROM THE BACK to avoid unnecessary shifting/moving elements
        while (pos1 >= 0 && pos2 >= 0) {
            if (nums1[pos1] > nums2[pos2]) {
                nums1[finalSize] = nums1[pos1];
                pos1--;
            } else {
                nums1[finalSize] = nums2[pos2];
                pos2--;
            }
            finalSize--;
        }
        // combine rest of nums2 (if anything left) into nums1
        while (pos2 >= 0) {
            nums1[finalSize] = nums2[pos2];
            pos2--;
            finalSize--;
        }
    }
}
