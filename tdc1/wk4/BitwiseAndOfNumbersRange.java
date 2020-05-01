package tdc1.wk4;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in
 * this range, inclusive.
 * <p>
 * Example 1:
 * <p>
 * Input: [5,7]
 * Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: [0,1]
 * Output: 0
 */
public class BitwiseAndOfNumbersRange {
    public static int run() {
        int m = 5;
        int n = 7;
        int ans = bitwiseAndOfNumbersRange1(m, n);
        System.out.println(ans);
        return ans;
    }

    /**
     * #j This problem is asking:
     * What is the (longest) common prefix in the binary representations of m and n?
     * Example: for numbers m=26 to n=30
     * <p>
     * 11010
     * 11011
     * 11100
     * 11101
     * 11110
     * <p>
     * If we AND all of these, we get 11000, since only the first and second positions don't
     * have zeros (AND is 1 only if there are no zeros).
     * <p>
     * The idea is to chop one bit off the left of both m and n (by right shifting) as long as they
     * differ, to get the prefix of 1s that m and n share (and therefore all the numbers in between
     * m and n share), then shift to the left by as many bits as we chopped off.
     * <p>
     * Note that we are given that m and n are both positive and fit in 32-bits, so we can just use
     * the default int, and not think about unsigned or signed shifting.
     * <p>
     * O(n) time, O(1) space, where n is the number of bits in the longer of the binary
     * representations of m and n
     * </p>
     *
     * @param m integer lower bound of range, 0 <= m <= n <= 2147483647
     * @param n integer upper bound of range, 0 <= m <= n <= 2147483647
     * @return the result after performing bitwise AND consecutively on all the numbers between
     * m and n, inclusive, as an int
     */
    public static int bitwiseAndOfNumbersRange1(int m, int n) {
        int nShifts = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            nShifts++;
        }
        return m << nShifts;
    }
}
