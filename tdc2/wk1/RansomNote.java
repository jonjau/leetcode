package tdc2.wk1;

import java.util.HashMap;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the
 * magazines, write a function that will return true if the ransom note can be constructed from the
 * magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    public static boolean run() {
        String ransomNote = "aa";
        String magazine = "aab";
        boolean ans = ransomNote1(ransomNote, magazine);
        System.out.println(ans);
        return ans;
    }

    /**
     * HashMap approach
     * <p>
     * O(n+m) time, O(m) space; where n is the length of ransomNote and m is the length of
     * magazine
     * </p>
     *
     * @param ransomNote the ransomNote string
     * @param magazine the magazine string
     * @return if the ransomNote can be built up from the characters in magazine
     */
    public static boolean ransomNote1(String ransomNote, String magazine) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }
        for (char ch : ransomNote.toCharArray()) {
            if (!charMap.containsKey(ch) || charMap.get(ch) == 0) {
                return false;
            } else {
                charMap.put(ch, charMap.get(ch) - 1);
            }
        }
        return true;
    }
}
