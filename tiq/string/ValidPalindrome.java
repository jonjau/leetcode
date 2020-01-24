package tiq.string;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and
 * ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    public static boolean run() {
        // respectively: true, false, true
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = "";
        String s4 = ".,";
        return isPalindrome1(s1);
    }

    /**
     * Checks if a string is a palindrome
     *
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param s String to be evaluated
     * @return true if s is a palindrome, false otherwise
     */
    public static boolean isPalindrome1(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            char cHead = s.charAt(head);
            char cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }

        }
        return true;
    }
}
