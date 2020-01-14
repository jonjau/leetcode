package tiq.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ContainsDuplicate
 */
public class ContainsDuplicate {

    public static boolean run() {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        return containsDuplicate2(nums);
    }

    /**
     * Sort, then check pairwise.
     * 
     * O(nlogn) time, O(1) space
     */
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }
    
    /**
     * Build a set and check for membership
     * 
     * O(n) time, O(n) space
     * (hash lookup is linear!)
     */
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }
}