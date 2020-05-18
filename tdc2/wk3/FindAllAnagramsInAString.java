package tdc2.wk3;

import tiq.util.ListUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will
 * not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagramsInAString {
    public static List<Integer> run() {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ans = findAllAnagramsInAString1(s, p);
        System.out.println(ans);
        return ans;
    }

    /**
     * Sliding Window
     * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param s a string
     * @param p a string
     * @return a list of the indices where anagrams of p start in s.
     */
    public static List<Integer> findAllAnagramsInAString1(String s, String p) {
        List<Integer> solution = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || p.length() > s.length()) {
            return solution;
        }
        // build count map of characters in the pattern p (the anagrams of which are to be found)
        Map<Character, Integer> patternCharMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            patternCharMap.put(c, patternCharMap.getOrDefault(c, 0) + 1);
        }
        // how many unique characters there are in the pattern
        int counter = patternCharMap.size();

        // the start and end index of the sliding window
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            char currChar = s.charAt(end);
            if (patternCharMap.containsKey(currChar)) {
                // decrement count of the current char if it is in the pattern
                // if this brings it to 0, then reduce the number of unique chars in the map too
                patternCharMap.put(currChar, patternCharMap.get(currChar) - 1);
                if (patternCharMap.get(currChar) == 0)counter--;
            }
            // we have accounted for the character at 'end': end of window moves forward
            end++;

            // counter being 0 means all the characters that make up the pattern are now within the
            // window. Now we check for anagrams by moving the start pointer
            //
            // Moving the start pointer past this (that is, because the anagram is
            // not contiguous) will invalidate this condition, in that case, we move end of the
            // window forward, looking out for another counter == 0 state.
            while (counter == 0) {
                currChar = s.charAt(start);
                if (patternCharMap.containsKey(currChar)) {
                    // current char has just been found to have been in the pattern,
                    // the map has one more unique element now
                    if (patternCharMap.get(currChar) == 0) {
                        counter++;
                    }
                    // increment count
                    patternCharMap.put(currChar, patternCharMap.get(currChar) + 1);
                }
                // contains all the characters in the pattern (from while condition),
                // contiguous (from the if condition below), this is an anagram!
                // Add its starting index to the list.
                if (end - start == p.length()) {
                    solution.add(start);
                }
                start++;
            }
        }
        return solution;
    }
}
