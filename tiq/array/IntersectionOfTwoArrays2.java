package tiq.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tiq.array.util.RandomIntArray;

/**
 * Given two arrays, write a function to compute their intersection.
 */
public class IntersectionOfTwoArrays2 {

    private static int[] array1;
    private static int[] array2;
    public static void setup(int n) {
        array1 = RandomIntArray.nonnegatives(n, 100, 123);
        array2 = RandomIntArray.nonnegatives(n, 100, 321);
    }

    public static int[] run() {
        
        int[] intersection = intersectionOfTwoArrays2_2(array1, array2);
        return intersection;
    }

    /**
     * HashMap solution
     * <p>
     * O(n + m) time, O(n) space
     * <p>
     * where the length of the shorter array is n and the other's length is m
     */
    public static int[] intersectionOfTwoArrays2_1(int[] nums1, int[] nums2) {
        int[] shorter;
        if (nums1.length < nums2.length) {
            shorter = nums1;
        } else {
            shorter = nums2;
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> intersection = new ArrayList<>(shorter.length);
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num)) {
                intersection.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] result = new int[intersection.size()];
        for (int i=0; i<intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        return result;
    }

    /**
     * Sort then compare elementwise
     * <p>
     * O(max(nlogn, mlogm)) time, O(n) space?
     * in practice grows slightly slower than 1st algorithm
     */
    public static int[] intersectionOfTwoArrays2_2(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i=0, j=0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            }
            else if (nums1[i] > nums2[j]) {
                j++;
            }
            else {
                intersection.add(nums1[i]);
                i++;
                j++;

            }
        }
        int[] result = new int[intersection.size()];
        for (int i=0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        return result;
    }
}