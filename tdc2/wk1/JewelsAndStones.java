package tdc2.wk1;

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the
 * stones you have.  Each character in S is a type of stone you have.  You want to know how many of
 * the stones you have are also jewels.
 * <p>
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are
 * case sensitive, so "a" is considered a different type of stone from "A".
 * <p>
 * Example 1:
 * <p>
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * <p>
 * Note:
 * <p>
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class JewelsAndStones {
    public static int run() {
        String J = "aA";
        String S = "aAAbbbb";
        int ans = jewelsAndStones1(J, S);
        System.out.println(ans);
        return ans;
    }

    /**
     * HashSet approach
     * <p>
     * O(n+m) time, O(n) space, where n is the length of J and m is the length of S
     * </p>
     *
     * @param J the jewels string
     * @param S the stones string
     * @return the number of stones in S that are jewels in J
     */
    public static int jewelsAndStones1(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        int nJewels = 0;
        for (char jewel : J.toCharArray()) {
            jewels.add(jewel);
        }
        for (char stone : S.toCharArray()) {
            if (jewels.contains(stone)) {
                nJewels++;
            }
        }
        return nJewels;
    }
}
