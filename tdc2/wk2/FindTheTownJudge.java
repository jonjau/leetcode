package tdc2.wk2;

/**
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is
 * secretly the town judge.
 * <p>
 * If the town judge exists, then:
 * <p>
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * <p>
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a
 * trusts the person labelled b.
 * <p>
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise,
 * return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 * <p>
 * Example 3:
 * <p>
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 * <p>
 * Example 4:
 * <p>
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 * <p>
 * Example 5:
 * <p>
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 */
public class FindTheTownJudge {
    public static int run() {
        int[][] trust = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        int N = 4;
        int ans = findTheTownJudge1(N, trust);
        System.out.println(ans);
        return ans;
    }

    /**
     * single array
     * <p>
     *     O(n) time, O(n) space, where n is the number of unique people
     * </p>
     * @param trust an array of int arrays representing people and who they trust
     * @return the index of the town judge if any, -1 otherwise
     */
    public static int findTheTownJudge1(int N, int[][] trust) {
        // town judge has: in_degree - out_degree = N - 1
        // +1 since people are numbered 1 to N,
        // this makes the code cleaner, no need to "[i-1]"
        int[] net_degree = new int[N + 1];
        for (int[] person : trust) {
            // decrease the net degree of person trusting,
            // increase the net degree of the person trusted
            net_degree[person[0]]--;
            net_degree[person[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (net_degree[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
