package tiq.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * SingleUniqueNumber
 */
public class SingleUniqueNumber {

    public static int run() {
        int[] nums = {8,8,4,1,2,1,2};
        return singleUniqueNumber3(nums);
    }

    /**
     * building map, then finding that with count 1
     * O(n) time, O(n) space
     */
    public static Integer singleUniqueNumber1(int[] nums) {
        // using hashSet should also work
       Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        // returning null would be dangerous. The problem guarantees
        // this will not happen, but return 0 anyway.
        return 0;
    }

    /**
     * Adding new elements and removing new elements from set,
     * leaving the unique to be the last remaining item in that set
     * O(n) time, O(n) space
     */
    public static Integer singleUniqueNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // if we've seen what we see now, it will have been the 2nd time
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        // the set should have one last element, which doesn't appear twice
        // in nums
        return (Integer) set.toArray()[0];
    }

    /**
     * Bitwise XOR, since N ^ N = 0, and 0 ^ N = N
     * O(n) time, O(1) space
     */
    public static Integer singleUniqueNumber3(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}