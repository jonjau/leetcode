package tiq.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {
    public static String run() {
        String[] strs = {"flower", "flow", "flight"};
        return longestCommonPrefix1(strs);
    }

    /**
     * Horizontal scanning: start from first string, then continually shrink the prefix to
     * satisfy the other strings.
     *
     * <p>
     * O(S) time, O(1) space
     * where S is the sum of the strings' lengths (S character comparisons occur)
     * </p>
     *
     * @param strs array of Strings
     * @return the longest common prefix for all of the strings
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            // keep chopping off last char from prefix until becomes an actual prefix for the
            // current string
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * Vertical scanning, compare all characters on the same index for all the strings in
     * each iteration, this optimizes for the case where there is a few shorter strings, unlike
     * horizontal scanning
     *
     * <p>
     * O(S) time, O(1) space
     * where S is the sum of the strings' lengths (S character comparisons occur)
     * </p>
     * <p>
     * worst case is if all strings are the same length; n strings of length m: S = n * m
     * best case is if one string is shorter/different than the others: n * minLength comparisons
     * </p>
     * @param strs array of Strings
     * @return the longest common prefix for all of the strings
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                // early return if one string is too short or is very different from the rest in
                // terms of initial characters
                if (i == str.length() || str.charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        // all the strings are the same: the longest common prefix is any one of them
        return strs[0];
    }

    // BEYOND THIS LINE REFER TO THE WEBSITE
    // https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/

    /**
     * Divide and Conquer
     * <p>
     *     O(S) time, O(m log n) space
     *     where S is the sum of all the strings' lengths, and m is the number of strings
     * </p>
     * @param strs array of Strings
     * @return the longest common prefix for all of the strings
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0 , strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private static String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    /**
     * Binary Search
     * <p>
     *     O(S log n) time, O(1) space
     *     where S is the sum of all the strings' lengths
     * </p>
     * @param strs array of Strings
     * @return the longest common prefix for all of the strings
     */
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }
}
