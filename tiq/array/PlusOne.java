package tiq.array;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 */
public class PlusOne {

    public static int[] run() {
        int[] digits = {9,9,9};
        int[] ans = plusOne1(digits);

        return ans;
    }
    
    /**
     * As by hand.
     * <p>
     * O(n) time, O(n) space
     */
    public static int[] plusOne1(int[] digits) {
        int carry = 1;
        int index = digits.length-1;
        while (index >= 0 && carry > 0) {
            digits[index] = (digits[index] + carry) % 10;
            carry = digits[index] == 0 ? 1 : 0;
            index--;
        }
        // only if all 9's
        if (carry > 0) {
            // JAVA SPEC: int arrays created by new are initialised to 0's
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }

    /**
     * Again, as by hand.
     * <p>
     * O(n) time, O(n) space
     */
    public static int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i=n-1; i>=0; i--) {
            // no need to carry (anymore)
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        // reaching beyond the loop means all 9's
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}