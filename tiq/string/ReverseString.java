package tiq.string;

/**
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * <p>
 * You may assume all the characters consist of printable ascii characters.
 */
public class ReverseString {
    public static void run() {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(String.valueOf(s));
        reverseString(s);
        System.out.println(String.valueOf(s));
    }

    /**
     * reverses a string given as a char[] by swapping with two pointers
     * converging at the middle
     * 
     * <p> O(n) time, O(1) space </p>
     *
     * @param s char[] to be reversed, contains only printable ASCII characters
     */
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
