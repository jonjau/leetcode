package tiq.string;

/**
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional initial
 * plus or minus sign followed by as many numerical digits as possible, and interprets them as a
 * numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are
 * ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if
 * no such sequence exists because either str is empty or it contains only whitespace characters, no
 * conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−2^31,  2^31 − 1]. If the numerical value is out of the range of
 * representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
 */
public class StringToInteger {
    public static int run() {
        String s1 = "   -42"; // -42
        String s2 = "    -4193 with words"; // 4193
        String s3 = "words and 987"; // 0
        String s4 = "-91283472332"; // -2147483648
        // edge cases: Integer.MIN_VALUE and Integer MAX_VALUE
        String s5 = "-2147483648"; // -2147483648
        String s6 = "2147483647"; // -2147483647
        String s7 = "   "; // 0
        String s8 = ""; // 0
        return atoi1(s2);
    }

    /**
     * Converts a string to a signed integer, if possible.
     * Skips initial whitespace, and ignores trailing non-digit characters.
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param str String to be converted to integer
     * @return first signed, in-range integral value in str, as an int, 0 if conversion impossible,
     * Integer.MAX_VALUE or Integer.MIN_VALUE if value is out of range
     */
    public static int atoi1(String str) {
        int i = 0;
        int n = str.length();
        // empty string: no conversion
        if (n == 0) {
            return 0;
        }
        // skip ahead of whitespace
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        // parse sign, if any
        int sign = 1;
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        // using only one bound for *both* large positive and large NEGATIVE integers, because
        // MAX is 2147483647 and MIN is -2147483648. There is no integral value in between
        // 2^31 - 1 and 2^31.
        int resultValue = 0;
        int bound = Integer.MAX_VALUE / 10;
        // build up result value, with overflow checks
        while (i < n && Character.isDigit(str.charAt(i))) {
            int currentDigitValue = str.charAt(i) - '0';
            if (resultValue > bound
                    || (resultValue == bound && currentDigitValue > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            resultValue = resultValue * 10 + currentDigitValue;
            i++;
        }
        return sign * resultValue;
    }
}
