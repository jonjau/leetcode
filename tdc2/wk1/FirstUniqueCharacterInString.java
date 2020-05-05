package tdc2.wk1;

import java.util.HashMap;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it
 * doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * <p>
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInString {
    public static int run() {
        String s = "loveleetcode";
        int ans = firstUniqueCharacterInString1(s);
        System.out.println(ans);
        return ans;
    }

    /**
     * two scans
     * <p>
     *     O(n) time, O(n) space
     * </p>
     * @param s String of lowercase characters
     * @return the index of the first unique character in the string, or -1 none
     */
    public static int firstUniqueCharacterInString1(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
