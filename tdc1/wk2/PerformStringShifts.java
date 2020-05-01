package tdc1.wk2;

/**
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i]
 * = [direction, amount]:
 * <p>
 * direction can be 0 (for left shift) or 1 (for right shift). amount is the amount by which
 * string s is to be shifted. A left shift by 1 means remove the first character of s and append
 * it to the end. Similarly, a right shift by 1 means remove the last character of s and add it
 * to the beginning.
 * <p>
 * Return the final string after all operations.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * <p>
 * Example 2:
 * <p>
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s only contains lower case English letters.
 * 1 <= shift.length <= 100
 * shift[i].length == 2
 * 0 <= shift[i][0] <= 1
 * 0 <= shift[i][1] <= 100
 * <p>
 * Intuitively performing all shift operations is acceptable due to the constraints.
 * <p>
 * You may notice that left shift cancels the right shift, so count the total left shift times (may
 * be negative if the final result is right shift), and perform it once.
 */
public class PerformStringShifts {
    public static String run() {
        String s1 = "abcdefg";
        String s2 = "mecsk";
        String s3 = "wpdhhcj";
        int[][] shifts1 = {{1, 1}, {1, 1,}, {0, 2}, {1, 3}};
        int[][] shifts2 = {{1, 4}, {0, 5}, {0, 4}, {1, 1}, {1, 5}};
        int[][] shifts3 = {{0, 7}, {1, 7}, {1, 0}, {1, 3}, {0, 3}, {0, 6}, {1, 2}};
        String ans = performStringShifts1(s3, shifts3);
        System.out.println(ans);
        return ans;
    }

    /**
     * O(n) time, O(1) space
     *
     * @param s     the string to be shifted
     * @param shift a matrix of shifts, "0 means left, 1 means right"
     * @return the resultant string after all the shifts
     */
    public static String performStringShifts1(String s, int[][] shift) {
        int netLeftShift = 0;
        for (int[] ints : shift) {
            if (ints[0] == 0) {
                netLeftShift += ints[1];
            } else {
                netLeftShift -= ints[1];
            }
        }
        return rotateString(s, netLeftShift);
    }

    /**
     * <p>
     * O(n) time (depends on Java's substring()), O(1) space
     * </p>
     *
     * @param s the string to rotate
     * @param nShifts the number of characters to left shift (negative means right shift)
     * @return the rotated string
     */
    private static String rotateString(String s, int nShifts) {
        nShifts %= s.length();
        if (nShifts < 0) {
            nShifts = -nShifts;
            String s1 = s.substring(s.length() - nShifts, s.length());
            String s2 = s.substring(0, s.length() - nShifts);
            return s1 + s2;
        } else if (nShifts > 0) {
            String s2 = s.substring(0, nShifts);
            String s1 = s.substring(nShifts, s.length());
            return s1 + s2;
        }
        return s;
    }
}
