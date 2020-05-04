package tdc2.wk1;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the
 * bits of its binary representation.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 5 Output: 2 Explanation: The binary representation of 5 is 101 (no leading zero bits), and
 * its complement is 010. So you need to output 2.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: 1 Output: 0 Explanation: The binary representation of 1 is 1 (no leading zero bits), and
 * its complement is 0. So you need to output 0.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class NumberComplement {
    public static int run() {
        int num = 5;
        int ans = numberComplement1(num);
        System.out.println(ans);
        return ans;
    }

    /**
     * N + bitwiseComplement(N) = 11....11 = X
     * Then bitwiseComplement(N) = X - N
     * <p>
     *     O(logn) time, O(1) space where n is the decimal value of num
     * </p>
     * @param num a decimal number
     * @return the binary complement of num, in decimal
     */
    public static int numberComplement1(int num) {
        int X = 1;
        while (num > X) {
            X = X * 2 + 1;
        }
        return X - num;
    }
}
