package tiq.dynamicprogramming;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain
 * amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police if
 * two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine
 * the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * <p>
 * Example 2:
 * <p>
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {
    public static int run() {
        int[] nums = {2, 7, 9, 3, 1};
        int ans = rob1(nums);
        System.out.println(ans);
        return ans;
    }

    /**
     * Given a list of non-negative integers, determine the maximum amount of money you can rob
     * without alerting the police (no two adjacent houses can be robbed)
     * <p>
     *     O(n) time, O(1) space
     * </p>
     * @param nums an array of non-negative integers representing money in houses
     * @return maximum amount of money that you can rob
     */
    public static int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // three element sliding window: prev2, prev1, num
        // prev1 and prev2 indicate the maximum money that you can rob if you were to stop
        // robbing at the previous (i-1) or the one before previous (i-2), respectively
        int prev2 = 0;
        int prev1 = 0;
        for (int num : nums) {
            int temp = prev1;
            // either rob house i and get max at i-2 or don't rob and get max at i-1
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        return prev1;
    }
}

/*
There is some frustration when people publish their perfect fine-grained algorithms without sharing
any information abut how they were derived. This is an attempt to change the situation. There is not
much more explanation but it's rather an example of higher level improvements. Converting a solution
to the next step shouldn't be as hard as attempting to come up with perfect algorithm at first
attempt.

This particular problem and most of others can be approached using the following sequence:

    Find recursive relation
    Recursive (top-down)
    Recursive + memo (top-down)
    Iterative + memo (bottom-up)
    Iterative + N variables (bottom-up)

Step 1. Figure out recursive relation.
A robber has 2 options: a) rob current house i; b) don't rob current house.
If an option "a" is selected it means she can't rob previous i-1 house but can safely proceed to the
one before previous i-2 and gets all cumulative loot that follows. If an option "b" is selected the
robber gets all the possible loot from robbery of i-1 and all the following buildings. So it boils
down to calculating what is more profitable:

    robbery of current house + loot from houses before the previous
    loot from the previous house robbery and any loot captured before that

rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1) )

Step 2. Recursive (top-down)
Converting the recurrent relation from Step 1 shound't be very hard.

public int rob(int[] nums) {
    return rob(nums, nums.length - 1);
}
private int rob(int[] nums, int i) {
    if (i < 0) {
        return 0;
    }
    return Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
}

This algorithm will process the same i multiple times and it needs improvement. Time complexity: [to
fill]

Step 3. Recursive + memo (top-down).

int[] memo;
public int rob(int[] nums) {
    memo = new int[nums.length + 1];
    Arrays.fill(memo, -1);
    return rob(nums, nums.length - 1);
}

private int rob(int[] nums, int i) {
    if (i < 0) {
        return 0;
    }
    if (memo[i] >= 0) {
        return memo[i];
    }
    int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    memo[i] = result;
    return result;
}

Much better, this should run in O(n) time. Space complexity is O(n) as well, because of the
recursion stack, let's try to get rid of it.

Step 4. Iterative + memo (bottom-up)

public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int[] memo = new int[nums.length + 1];
    memo[0] = 0;
    memo[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        int val = nums[i];
        memo[i+1] = Math.max(memo[i], memo[i-1] + val);
    }
    return memo[nums.length];
}

Step 5. Iterative + 2 variables (bottom-up)
We can notice that in the previous step we use only memo[i] and memo[i-1], so going just 2 steps
back. We can hold them in 2 variables instead. This optimization is met in Fibonacci sequence
creation and some other problems [to paste links].

the order is: prev2, prev1, num
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    int prev1 = 0;
    int prev2 = 0;
    for (int num : nums) {
        int tmp = prev1;
        prev1 = Math.max(prev2 + num, prev1);
        prev2 = tmp;
    }
    return prev1;
}

 */





