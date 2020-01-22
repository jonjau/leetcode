package tiq.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index If it doesn't
 * exist, return -1.
 */
public class FirstUniqueCharacterInString {
    public static int run() {
        String str = "loveleetcode";
        return firstUniqueCharacterInString1(str);
    }

    /**
     * Finds the index of the first unique character in a string
     * <p>
     * O(n) time, O(n) space
     * </p>
     *
     * @param str String to be evaluated
     * @return the index of the first unique character in {@code str}
     */
    public static int firstUniqueCharacterInString1(String str) {
        // LinkedHashMap preserves insertion order when you iterate over it
        Map<Character, Integer> count = new LinkedHashMap<>();
        int n = str.length();
        // build up character count map
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        // check for count of 1, which implies uniqueness
        for (int i = 0; i < n; i++) {
            if (count.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
