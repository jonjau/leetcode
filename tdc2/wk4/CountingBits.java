package tdc2.wk4;

import java.util.Arrays;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,1]
 * <p>
 * Example 2:
 * <p>
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do
 * it in linear time O(n) /possibly in a single pass? Space complexity should be O(n). Can you
 * do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or
 * in any other language.
 * <p>
 * Hide Hint #1
 * You should make use of what you have produced already.
 * Hide Hint #2
 * Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try to generate new range
 * from previous.
 * Hide Hint #3
 * Or does the odd/even status of the number help you in calculating the number of 1s?
 */
public class CountingBits {
    public static int[] run() {
        int num = 5;
        int[] ans = countingBits1(num);
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    /**
     * https://leetcode.com/problems/counting-bits/discuss/270693/Intermediate-processsolution-for-the-most-voted-solution-i.e.-no-simplificationtrick-hidden
     * DP
     * <p>
     * O(n) time, O(n) space where n is the value of num
     * </p>
     *
     * @param num a non-negative integer
     * @return list of the number of 1s in i, where i=[0,num]
     */
    public static int[] countingBits1(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;

        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 0) {
                // even number, so just right shift it by one (doubles decimal value)
                result[i] = result[i >> 1];
            } else {
                // odd number, so plus one from previous
                result[i] = result[i-1] + 1;
            }
        }
        return result;
    }
}
