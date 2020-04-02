package tdc.wk1;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the
 * number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * <p>
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class HappyNumber {
    public static boolean run() {
        int num1 = 19;
        boolean ans = isHappy(num1);
        System.out.println(ans);
        return ans;
    }

    /**
     * <p>
     * O(??? * n) time, O(???) space,
     * where ??? is the number of times the square-summing is done
     * </p>
     *
     * @param n integer to be tested
     * @return whether or not n is "Happy"
     */
    private static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        seen.add(n);
        int sumOfSquares = sumOfSquaresOfDigits(n);
        // keep going until loop back (false in that case), or sum == 1 (then true)
        while (sumOfSquares != 1) {
            if (seen.contains(sumOfSquares)) {
                return false;
            } else {
                seen.add(sumOfSquares);
            }
            sumOfSquares = sumOfSquaresOfDigits(sumOfSquares);
        }
        return true;
    }

    /**
     * return the sum of the squares of the digits in a number
     * <p>
     * O(number of digits) time, (1) space
     * </p>
     *
     * @param n integer whose digits are to be squared and summed
     * @return the sum of the squares of the digits of n
     */
    private static int sumOfSquaresOfDigits(int n) {
        int result = 0;
        int digit = 0;
        while (n > 0) {
            digit = n % 10;
            result += digit * digit;
            n /= 10;
        }
        return result;
    }
}
