package tiq.string;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Assume we are dealing with an environment which could only store integers
 * within the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of
 * this problem, assume that your function returns 0 when the reversed integer
 * overflows.
 */
public class ReverseInteger {
    public static int run() {
        int x = 123;
        int y = -123;
        int z = 120;
        return reverseInteger2(x);
    }

    /**
     * "push and pop" digits, with hardcoded overflow check
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param x Integer to be reversed (assumed to be signed 32-bit integer)
     * @return x reversed
     */
    public static int reverseInteger1(int x) {
        int reversed = 0;
        while (x != 0) {
            // pop leftmost digit
            int pop = x % 10;
            x /= 10;

            // the second cases of these overflow/underflow checks are redundant; they are
            // impossible since the input itself is a signed integer (it is bounded as well)

            // check for integer overflow
            // last digit of Integer.MAX_VALUE is 7
            if (reversed > Integer.MAX_VALUE / 10
                    || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            // check for integer underflow
            // last digit of Integer.MIN_VALUE is 8 (note MIN_VALUE is a negative number)
            if (reversed < Integer.MIN_VALUE / 10
                    || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            // push 'pop' as rightmost digit
            reversed = reversed * 10 + pop;
        }
        return reversed;
    }

    // For your reference, to test if there is overflow for any integer x of the
    // form x = a * 10 + b where |b| < 10, the right way should be comparing x /
    // 10 (integer division) with a. If x / 10 != a, there is overflow,
    // otherwise no overflow can happen. The proof is as follows: first note
    // that x itself is a signed integer, therefore we have INT_MIN <= x <=
    // INT_MAX, which implies INT_MIN/10 <= x/10 <= INT_MAX/10. So if we assume
    // x / 10 == a, we have INT_MIN/10 <= a <= INT_MAX/10. Since |b| < 10, then
    // a * 10 + b can overflow only if a = INT_MAX/10 or a = INT_MIN/10. For
    // signed 32-bit integers, we have INT_MAX = 2147483647 and INT_MIN =
    // -2147483648. For a = INT_MAX/10 = 214748364, overflow will happen only if
    // b = 8 or 9. However if this is the case, then x = a * 10 + b will be
    // negative and x / 10 cannot be the same as a, contradicting our assumption
    // above. Similarly if a = INT_MIN/10 = -214748364, overflow will happen
    // only if b = -9 but then x = a * 10 + b will be positive and again x / 10
    // won't be equal to a.
    //
    // In summary, x / 10 != a <==> overflow.
    // 
    // As for the test condition in the original post, which is equivalent to
    // testing (x - b) / 10 != a, it will only cover the cases when |a| >
    // INT_MAX/10 but not the cases when |a| = INT_MAX/10, b = 8 or 9 for
    // positive a and -9 for negative a. The test condition works here because
    // the edge cases mentioned above won't happen due to the fact that the
    // input itself is a signed integer. If the input is something else, say a
    // string (see String to Integer (atoi)), the test condition above will fail
    // the edge cases.

    /**
     * "push and pop" digits, with hardcoded overflow check
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param x Integer to be reversed (assumed to be signed 32-bit integer)
     * @return x reversed
     */
    public static int reverseInteger2(int x) {
        int result = 0;
        while (x != 0) {
            // pop leftmost digit
            int pop = x % 10;
            x /= 10;

            // push 'pop' as rightmost digit
            int temp = result * 10 + pop;

            // in the case of any overflow/underflow, pushing operation will be "irreversible"
            if ((temp - pop) / 10 != result) {
                return 0;
            }
            result = temp;
        }
        return result;
    }
}
