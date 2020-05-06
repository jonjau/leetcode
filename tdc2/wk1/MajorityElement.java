package tdc2.wk1;

import java.util.HashMap;

/**
 * Given an array of size n, find the majority element. The majority element is the element that
 * appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {
    public static int run() {
        int[] nums = {2,2,1,1,1,2,2};
        int ans = majorityElement1(nums);
        System.out.println(ans);
        return ans;
    }

    /**
     * hashmap approach
     * @param nums a non-empty array of integers, with an odd number of values (majority exists)
     * @return the majority element
     */
    public static int majorityElement1(int[] nums) {
        // it is given that nums is non-empty, and the majority element always exists in the array
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > n/2) {
                return num;
            }
        }
        // no unique majority element found: behavior undefined by specification.
        return nums[0];
    }
}
