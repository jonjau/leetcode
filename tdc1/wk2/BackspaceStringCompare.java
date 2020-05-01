package tdc1.wk2;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Note:
 *
 *     1 <= S.length <= 200
 *     1 <= T.length <= 200
 *     S and T only contain lowercase letters and '#' characters.
 *
 * Follow up:
 *
 *     Can you solve it in O(N) time and O(1) space?
 */
public class BackspaceStringCompare {
    public static boolean run() {
        String S = "a##c";
        String T = "#a#c";
        boolean ans = backspaceStringCompare1(S, T);
        System.out.println(ans);
        return ans;
    }

    /**
     * Checks whether two Strings are equivalent after interpreting '#'s as backspaces:
     * Stack approach
     * <p>
     *     O(n+m) time, O(n+m) space
     * </p>
     * @param S the first string
     * @param T the second string
     * @return Whether S and T are equivalent Strings as defined
     */
    public static boolean backspaceStringCompare1(String S, String T) {
        return buildString(S).equals(buildString(T));
    }

    /**
     * Returns the result String after '#'s are interpreted as backspaces.
     * <p>
     *     O(n) time, O(n) space
     * </p>
     * @param str the String for which keystrokes are to be simulated
     * @return the resultant String after keystroke simulation
     */
    private static String buildString(String str) {
        Stack<Character> characterStack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch != '#') {
                characterStack.push(ch);
            } else if (!characterStack.isEmpty()) {
                characterStack.pop();
            }
        }
        return String.valueOf(characterStack);
    }

    /**
     * Checks whether two Strings are equivalent after interpreting '#'s as backspaces:
     * "Iterate from the back" approach
     * <p>
     *     O(n+m) time, O(1) space
     * </p>
     * @param S the first string
     * @param T the second string
     * @return Whether S and T are equivalent Strings as defined
     */
    public static boolean backSpaceStringCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        // while there may be chars in build(S) or build (T)
        while (i >= 0 || j >= 0) {
            // Find position of next possible char in build(S)
            while (i >= 0) {
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            // Find position of next possible char in build(T)
            while (j >= 0) {
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}




