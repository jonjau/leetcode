package tiq.string;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can
 * do so recursively, in other words from the previous member read off the digits, counting the
 * number of digits in groups of the same digit.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 */
public class CountAndSay {
    public static String run() {
        int n = 4;
        return countAndSay(n);
    }

    /**
     * "Count and Say" the n'th term
     * <p>
     * O(n^2)? time, O(n)? space
     * </p>
     *
     * @param n which term in the sequence to output (sequence starts from n=1)
     * @return the n'th "count and say" term
     */
    public static String countAndSay(int n) {
        String numStr = "1";
        for (int i = 1; i < n; i++) {
            numStr = say(numStr);
        }
        return numStr;
    }

    /**
     * "Say" the given string of numbers
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param numStr the String of numbers to be "said"
     * @return a String representing how numStr is "said"
     */
    private static String say(String numStr) {
        StringBuilder stringBuilder = new StringBuilder();
        char digit = numStr.charAt(0);
        int count = 1;
        for (int i = 1; i < numStr.length(); i++) {
            // still the same digit, keep count
            if (digit == numStr.charAt(i)) {
                count++;
            } else {
                stringBuilder.append(count);
                stringBuilder.append(digit);
                digit = numStr.charAt(i);
                count = 1;
            }
        }
        // end last count
        stringBuilder.append(count);
        stringBuilder.append(digit);
        return stringBuilder.toString();
    }
}
