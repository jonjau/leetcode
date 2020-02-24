package tiq.dynamicprogramming;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class ClimbingStairs {
    public static int run() {
        int n = 44;
        int ans = climbStairs2(n);
        System.out.println(ans);
        return ans;
    }

    /**
     * VERY SLOW (TIME LIMIT EXCEEDED) Recursive brute force: find the number of distinct ways to
     * get to exactly n steps with steps of 1 and/or 2
     * <p>
     *     O(2^n) time (size of recursion tree will be 2^n)
     *     O(n) space (depth of recursion tree )
     * </p>
     *
     * @param n the positive integer number of steps to get to
     * @return the number of distinct ways to get to n, with steps of 1 and/or 2
     */
    public static int climbStairs1(int n) {
        return climbStairs1helper(0, n);
    }

    /**
     * Recursive helper function for climbStairs1
     *
     * @param i current step
     * @param n destination step
     * @return number of distinct ways to arrange steps of 1 and/or 2 to get to n, starting from i
     */
    public static int climbStairs1helper(int i, int n) {
        // two base cases: +0 for invalid climb (i overshoots n)
        if (i > n) {
            return 0;
        }
        // or +1 for valid climb (where i exactly equals n)
        if (i == n) {
            return 1;
        }
        // recursive case, i still less than n, so try to fit in more (with either 1 or 2 steps)
        return climbStairs1helper(i + 1, n) + climbStairs1helper(i + 2, n);
    }

    /**
     * Recursive, with memoization: find the number of distinct ways to
     * get to exactly n steps with steps of 1 and/or 2
     * <p>
     *     O(n) time (size of recursion tree can go up to n)
     *     O(n) space (depth of recursion tree can go up to n)
     * </p>
     *
     * @param n the positive integer number of steps to get to
     * @return the number of distinct ways to get to n, with steps of 1 and/or 2
     */
    public static int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return climbStairs2helper(0, n, memo);
    }

    /**
     * Recursive helper function for climbStairs2
     *
     * @param i current step
     * @param n destination step
     * @param memo integer array storing the number of distinct ways to get to each i
     * @return number of distinct ways to arrange steps of 1 and/or 2 to get to n, starting from i
     */
    public static int climbStairs2helper(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        // number of distinct ways to get to the i'th step has been calculated before
        if (memo[i] > 0) {
            return memo[i];
        }
        // never been to this i before, calculate and memoize
        memo[i] = climbStairs2helper(i + 1, n, memo) + climbStairs2helper(i + 2, n, memo);
        return memo[i];
    }
}
