package tiq.string;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {
    public static boolean run() {
        String s = "anagram";
        String t = "nagaram";
        return validAnagram2(s, t);
    }

    /**
     * Checks if two strings are anagrams of each other.
     * Fixed size array approach possible due to assumptions, if all of Unicode possible, use
     * HashMap.
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param s first string
     * @param t second string
     * @return true if s1 is an anagram of s2 and vice versa, otherwise false.
     */
    public static boolean validAnagram1(String s, String t) {
        int n = s.length();
        if (t.length() != n) {
            return false;
        }
        int[] alphabetCounts = new int[ALPHABET_SIZE];
        for (int i = 0; i < n; i++) {
            alphabetCounts[s.charAt(i) - 'a']++;
            alphabetCounts[t.charAt(i) - 'a']--;
        }
        for (int count : alphabetCounts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if two strings are anagrams of each other.
     * Slightly more optimized, early return in second for loop
     * <p>
     * O(n) time, O(1) space
     * </p>
     *
     * @param s first string
     * @param t second string
     * @return true if s1 is an anagram of s2 and vice versa, otherwise false.
     */
    public static boolean validAnagram2(String s, String t) {
        int n = s.length();
        if (t.length() != n) {
            return false;
        }
        int[] alphabetCounts = new int[ALPHABET_SIZE];
        for (int i = 0; i < n; i++) {
            alphabetCounts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            char ch = t.charAt(i);
            alphabetCounts[ch - 'a']--;
            if (alphabetCounts[ch - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    private static final int ALPHABET_SIZE = 26;
}
