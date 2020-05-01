package tdc1.wk1;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * <p>
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
    public static List<List<String>> run() {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = groupAnagrams2(strings);
        for (List<String> list : ans) {
            System.out.print("[ ");
            for (String s : list) {
                System.out.print(s);
                System.out.print(' ');
            }
            System.out.print(" ]\n");
        }
        return ans;
    }

    /**
     * Build up map of sorted strings and their respective anagrams, then convert that to a
     * list of lists of strings.
     * <p>
     * O(nk*log n) time, O(nk) space
     * </p>
     * where n is the number of strings in str, and k is the maximum length of a string in strings
     * @param strings array of strings to be grouped
     * @return list of lists of grouped anagrams of strings in strings
     */
    public static List<List<String>> groupAnagrams1(String[] strings) {
        if (strings.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> stringListMap = new HashMap<>();
        // build a map of sorted strings and strings
        // if str1 == str2 when they are both sorted
        for (String str : strings) {
            // yes, this is how you sort a string is Java: 3 lines and 2 type conversions...
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = String.valueOf(arr);
            if (!stringListMap.containsKey(sortedStr)) {
                stringListMap.put(sortedStr, new ArrayList<>());
            }
            stringListMap.get(sortedStr).add(str);
        }
        // return the stringListMap as a list of lists of strings
        return new ArrayList<>(stringListMap.values());
    }

    /**
     * "hashing" approach, assuming 26-letter alphabet and '#' is a reserved character, this lets
     * us skip sorting each string.
     * <p>
     * O(nk) time, O(nk) space
     * </p>
     * where n is the number of strings in str, and k is the maximum length of a string in strings
     * @param strings array of strings to be grouped
     * @return list of lists of grouped anagrams of strings in strings
     */
    public static List<List<String>> groupAnagrams2(String[] strings) {
        if (strings.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strings) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }
}
