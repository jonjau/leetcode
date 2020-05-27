package tdc2.wk4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups
 * of any size.
 * <p>
 * Each person may dislike some other people, and they should not go into the same group.
 * <p>
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b
 * into the same group.
 * <p>
 * Return true if and only if it is possible to split everyone into two groups in this way.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 * <p>
 * Example 2:
 * <p>
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 2000
 * 0 <= dislikes.length <= 10000
 * 1 <= dislikes[i][j] <= N
 * dislikes[i][0] < dislikes[i][1]
 * There does not exist i != j for which dislikes[i] == dislikes[j].
 */
public class PossibleBipartition {

    //private static ArrayList<ArrayList<Integer>> graph;
    //private static Map<Integer, Integer> color;

    public static boolean run() {
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        int N = 5;
        boolean ans = possibleBipartition1(N, dislikes);
        System.out.println(ans);
        return ans;
    }

    /**
     * https://leetcode.com/problems/possible-bipartition/solution/
     * 2-colourability problem, DFS
     * <p>
     * O(n+e) time, O(n+e) space, where e is the length of dislikes
     * </p>
     *
     * @param N        the number of people
     * @param dislikes array of arrays representing who dislikes who
     * @return whether it is possible to split everyone into two groups
     */
    public static boolean possibleBipartition1(int N, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 1; i <= N + 1; ++i) graph.add(new ArrayList<>());
        // fill graph with nodes such that: if A has an edge with B and vice versa,
        // it means they dislike each other, we must put them in separate arrays,
        // that is, we have to "color one red and the other blue"
        for (int[] edge : dislikes) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Map<Integer, Integer> colorMap = new HashMap<>();
        for (int node = 1; node <= N; ++node) {
            if (!colorMap.containsKey(node) && !dfs(node, 0, colorMap, graph)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int node, int color, Map<Integer, Integer> colorMap,
                               List<List<Integer>> graph) {
        if (colorMap.containsKey(node)) {
            return colorMap.get(node) == color;
        }

        colorMap.put(node, color);

        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, color ^ 1, colorMap, graph)) {
                return false;
            }
        }
        return true;
    }
}
