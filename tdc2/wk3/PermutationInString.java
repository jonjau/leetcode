package tdc2.wk3;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of
 * s1. In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * <p>
 * Example 2:
 * <p>
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * Hide Hint #1
 * Obviously, brute force will result in TLE. Think of something else.
 * Hide Hint #2
 * How will you check whether one string is a permutation of another string?
 * Hide Hint #3
 * One way is to sort the string and then compare. But, Is there a better way?
 * Hide Hint #4
 * If one string is a permutation of another string then they must one common metric. What is that?
 * Hide Hint #5
 * Both strings must have same character frequencies, if one is permutation of another. Which data
 * structure should be used to store frequencies?
 * Hide Hint #6
 * What about hash table? An array of size 26?
 */
public class PermutationInString {
    public static boolean run() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean ans = permutationInString1(s1, s2);
        System.out.println(ans);
        return ans;
    }

    /**
     * LITERALLY 3 LINES DIFFERENT FROM FindAllAnagramsInAString.
     * Anagrams are defined as meaningful permutations of a word. In this context,
     * the 'meaningful' part doesn't matter, therefore it is exactly the same problem,
     * just different output (true/false instead of a list of indices)
     * <p>
     * This is sliding window
     * (there are definitely optimisations possible for this specific problem instance).
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param s1 a string
     * @param s2 a string
     * @return whether s2 contains a substring that is a permutation of s1
     */
    public static boolean permutationInString1(String s1, String s2) {
        // refer to FindAllAnagramsInAString too. Again, it is literally the same problem
        if (s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()) {
            return false;
        }
        // build up map of characters and their frequencies in s1
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // counts the number of unique characters in s1
        int counter = map.size();
        int start = 0;
        int end = 0;
        while (end < s2.length()) {
            char currChar = s2.charAt(end);
            if (map.containsKey(currChar)) {
                // reduce count of the character in map,
                // and possibly update the (remaining) number of unique characters to find
                map.put(currChar, map.get(currChar) - 1);
                if (map.get(currChar) == 0) {
                    counter--;
                }
            }
            end++;
            // possible solution: all characters in s1 are within the window,
            // verify solution by moving start pointer now.
            while (counter == 0) {
                currChar = s2.charAt(start);
                if (map.containsKey(currChar)) {
                    if (map.get(currChar) == 0) {
                        counter++;
                    }
                    map.put(currChar, map.get(currChar) + 1);
                }
                // the substring defined by the window exacly consists of same characters
                // in s1, and has the same length too, this is a permutation of s1
                if (end - start == s1.length()) {
                    return true;
                }
                start++;
            }
        }
        return false;
    }
}
