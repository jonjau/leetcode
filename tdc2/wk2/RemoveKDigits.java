package tdc2.wk2;

import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that
 * the new number is the smallest possible.
 * <p>
 * Note:
 * <p>
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * <p>
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * <p>
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain
 * leading zeroes.
 * <p>
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits {
    public static String run() {
        String num = "10200";
        int k = 1;
        String ans = removeDigits1(num, k);
        System.out.println(ans);
        return ans;
    }

    /**
     * Greedy stack approach:
     * <p>
     * try to convert num into an strictly increasing sequence digits working from
     * the most significant digit, if num already is an increasing sequence of digits,
     * remove leftmost digits.
     * </p>
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param num a sting of digits
     * @param k the number of digit removals allowed
     * @return the string representing the minimum number after k digit removals on num
     */
    public static String removeDigits1(String num, int k) {
        int n = num.length();
        if (k == n) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        // tracks position in num string
        int i = 0;

        // essentially we want to, as much as k allows, turn num into a
        // strictly increasing sequence of digits.
        while (i < n) {
            char currDigit = num.charAt(i);
            // keep removing digits until either run out of removals (k = 0) or
            // the digit is less than current digit, whichever comes first.
            while (k > 0 && !stack.isEmpty() && stack.peek() > currDigit) {
                stack.pop();
                k--;
            }
            stack.push(currDigit);
            i++;
        }

        // In the case that the num string is made up of the same digits e.g. '3333', or is
        // already an increasing sequence e.g. '12345', then just chop off the rightmost digits
        while (k > 0) {
            stack.pop();
            k--;
        }

        // construct the string from the stack:
        // need to reverse because least significant digit will be at the top of the stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        // remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
