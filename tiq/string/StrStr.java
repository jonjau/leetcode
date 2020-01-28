package tiq.string;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * <p>
 * Clarification:
 * What should we return when needle is an empty string? This is a great question to ask during an
 * interview. For the purpose of this problem, we will return 0 when needle is an empty string. This
 * is consistent to C's strstr() and Java's indexOf().
 */
public class StrStr {
    public static int run() {
        String s1 = "hello";
        String s2 = "ll";
        String s3 = "aaaa";
        String s4 = "bba";
        String s5 = "";
        String s6 = "she sells she shells";
        String s7 = "she shells";
        return indexOf2(s6, s7);
    }

    /**
     * "Brute Force" approach: try all starting match indices in haystack, until full match found
     * <p>
     * O(nm) time, O(1) space
     * where n is the length of the text and m is the length of the pattern
     * </p>
     *
     * @param haystack String against which pattern is matched
     * @param needle   pattern string
     * @return the index where the first full match (of the pattern in the text) begins, or -1 if
     * no match is found
     */
    public static int indexOf1(String haystack, String needle) {
        int startMatchIndex = 0;
        int textLength = haystack.length();
        int patternLength = needle.length();
        while (startMatchIndex <= textLength - patternLength) {
            int i = 0;
            for (; i < patternLength; i++) {
                if (haystack.charAt(startMatchIndex + i) != needle.charAt(i)) {
                    break;
                }
            }
            if (i == patternLength) {
                return startMatchIndex;
            }
            startMatchIndex++;
        }
        // no match found
        return -1;
    }

    /**
     * KMP variant pattern matching algorithm
     * .Text pointer never backtracks.
     * <p>
     * O(n + m) time, O(m) space
     * where n is the length of the text and m is the length of the pattern
     * </p>
     *
     * @param haystack String against which pattern is matched
     * @param needle   pattern string
     * @return the index where the first full match (of the pattern in the text) begins, or -1 if
     * no match is found
     */
    public static int indexOf2(String haystack, String needle) {
        int textLength = haystack.length();
        int patternLength = needle.length();
        if (patternLength > textLength) {
            return -1;
        }
        int[] table = kmpPreprocess(needle);
        int textIndex = 0;
        int patternIndex = 0;
        while (textIndex < textLength && patternIndex < patternLength) {
            // potential match: keep going, advance both text and pattern
            if (haystack.charAt(textIndex) == needle.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;
            }
            // mismatch in the middle of pattern: reset pattern pointer based on table
            else if (patternIndex > 0) {
                patternIndex = table[patternIndex - 1];
            }
            // mismatch at first character of pattern: table will not help, just advance text
            else {
                textIndex++;
            }
        }
        return patternIndex == patternLength ? textIndex - patternIndex : -1;
    }

    /**
     * Constructs a KMP (variant) partial match table for a given pattern string
     * <p>
     * O(m) time, O(m) space
     * </p>
     *
     * @param pattern pattern string for which partial match table is to be constructed
     * @return an array of integers:
     * table of "what index in the pattern string to resume matching in case of mismatch on the
     * character right after this one."
     * e.g. index 5 has value 2 and mismatch occurs on index 6: resume matching from index 2 in
     * the pattern string, skipping the first two characters.
     */
    private static int[] kmpPreprocess(String pattern) {
        // i tracks end of the expanding substring, j tracks the end of the matching prefix
        int i = 1;
        int j = 0;

        int[] table = new int[pattern.length()];
        while (i < pattern.length()) {
            // chars at i and j are same: advance both to determine matching suffix/prefix length
            if (pattern.charAt(i) == pattern.charAt(j)) {
                table[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = table[j - 1];
            } else {
                table[i] = 0;
                i++;
            }
        }
        return table;
    }
}
