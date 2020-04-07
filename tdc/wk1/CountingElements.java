package tdc.wk1;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 *
 * If there're duplicates in arr, count them seperately.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 *
 * Example 2:
 *
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 *
 * Example 3:
 *
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 *
 * Example 4:
 *
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 *
 *
 *
 * Constraints:
 *
 *     1 <= arr.length <= 1000
 *     0 <= arr[i] <= 1000
 */
public class CountingElements {
    public static int run() {
        int[] arr = {1,3,2,3,5,0};
        int ans = countingElements1(arr);
        System.out.println(ans);
        return ans;
    }

    /**
     * Given an integer array arr, count element x such that x + 1 is also in arr.
     * If there are duplicates in arr, count them separately.
     *
     * Hashset approach. Build hashset then count how many valid elements in the array
     * <p>
     *     O(n) time, O(n) space
     * </p>
     * @param arr array of integers
     * @return number of elements x such that x + 1 is also in the array
     */
    public static int countingElements1(int[] arr) {
        Set<Integer> toCount = new HashSet<>();
        for (int num : arr) {
            toCount.add(num - 1);
        }
        int count = 0;
        for (int num : arr) {
            if (toCount.contains(num)) {
                count++;
            }
        }
        return count;
    }
}
