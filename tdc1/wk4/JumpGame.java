package tdc1.wk4;

import java.util.Arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the
 * array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * <p>
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    enum Index {
        GOOD, BAD, UNKNOWN
    }

    public static boolean run() {
        int[] nums = {2,3,1,1,4};
        boolean ans = jumpGame2(nums);
        System.out.println(ans);
        return ans;
    }

    /**
     * Dynamic programming: bottom-up
     * <p>
     * O(n^2) time, O(n) time
     * </p>
     *
     * @param nums integer array indicating maximum jumps
     * @return true if can jump to last index, false otherwise
     */
    public static boolean jumpGame1(int[] nums) {
        Index[] memo = new Index[nums.length];
        Arrays.fill(memo, Index.UNKNOWN);
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            // furthest jump possible so far
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                // can jump to GOOD index from current index, means current index is GOOD
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }

    /**
     * Optimisation on Dynamic Programming approach
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param nums integer array indicating maximum jumps
     * @return true if can jump to last index, false otherwise
     */
    public static boolean jumpGame2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
