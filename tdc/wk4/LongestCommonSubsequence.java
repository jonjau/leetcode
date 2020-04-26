package tdc.wk4;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some
 * characters(can be none) deleted without changing the relative order of the remaining characters.
 * (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings
 * is a subsequence that is common to both strings.
 * <p>
 * <p>
 * <p>
 * If there is no common subsequence, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * <p>
 * Example 2:
 * <p>
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * <p>
 * Example 3:
 * <p>
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 */
public class LongestCommonSubsequence {
    public static int run() {
        String text1 = "abcde";
        String text2 = "ace";
        int ans = longestCommonSubsequence2(text1,text2);
        System.out.println(ans);
        return ans;
    }

    /**
     * Recursive approach, without memoization
     * <p>
     * O(2^(m*n)) time, O(n+m) space
     * </p>
     *
     * @param text1 first string
     * @param text2 second string
     * @return the length of the longest common subsequence of text1 and text2
     */
    public static int longestCommonSubsequence1(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        return _lcsm1(text1.toCharArray(), text2.toCharArray(), length1, length2);
    }

    /**
     * Recursive helper function for longestCommonSubsequence1()
     */
    private static int _lcsm1(char[] s1, char[] s2, int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (s1[i - 1] == s2[j - 1]) {
            return _lcsm1(s1, s2, i - 1, j - 1);
        } else {
            return Math.max(_lcsm1(s1, s2, i - 1, j), _lcsm1(s1, s2, i, j - 1));
        }
    }

    /**
     * Dynamic programming, bottom up
     * <p>
     * O(nm) time, O(nm) space
     * </p>
     *
     * @param text1 first string
     * @param text2 second string
     * @return the length of the longest common subsequence of text1 and text2
     */
    public static int longestCommonSubsequence2(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // +1 because we are always "one ahead" of the positions we are considering
        // we will end up at the ends of the strings this way
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
