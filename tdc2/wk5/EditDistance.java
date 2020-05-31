package tdc2.wk5;

/**
 * Given two words word1 and word2, find the minimum number of operations required to convert word1
 * to word2.
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * <p>
 * Example 2:
 * <p>
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance {
    public static int run() {
        String word1 = "intention";
        String word2 = "execution";
        int ans = editDistance1(word1, word2);
        System.out.println(ans);
        return ans;
    }

    /**
     * https://leetcode.com/problems/edit-distance/discuss/25849/Java-DP-solution-O(nm)
     * <p>
     * O(nm) time, O(mn) space
     * </p>
     *
     * @param word1 first word
     * @param word2 second word
     * @return the edit distance between the two words
     */
    public static int editDistance1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            cost[i][0] = i;
        for (int i = 1; i <= n; i++)
            cost[0][i] = i;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j];
                else {
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    cost[i + 1][j + 1] = a < b ? (Math.min(a, c)) : (Math.min(b, c));
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }
}
