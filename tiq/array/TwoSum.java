package tiq.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target. You may assume that each input would have
 * exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

    public static int[] run() {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = twoSum2(nums, target);
        return ans;
    }

    /**
     * BRUTE FORCE, try all possible pairs
     * O(n^2) time, O(1) space
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        // shouldn't reach here
        throw new IllegalArgumentException("Exactly one solution expected.");
    }


    /**
     * One-pass hash table
     * O(n) time, O(n) space
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // shouldn't reach here
        throw new IllegalArgumentException("Exactly one solution expected.");
    }
}