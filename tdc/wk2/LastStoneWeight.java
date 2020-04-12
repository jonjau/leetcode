package tdc.wk2;

import java.util.PriorityQueue;

/**
 * We have a collection of stones, each stone has a positive integer weight.
 * <p>
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have
 * weights x and y with x <= y.  The result of this smash is:
 * <p>
 * If x == y, both stones are totally destroyed; If x != y, the stone of weight x is totally
 * destroyed, and the stone of weight y has new weight y-x.
 * <p>
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no
 * stones left.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class LastStoneWeight {
    public static int run() {
        int[] stones = {2, 7, 4, 1, 8, 1};
        int ans = lastStoneWeight1(stones);
        System.out.println(ans);
        return ans;
    }

    /**
     * Smash two of the largest stones, if they are of the same weight they are both destroyed,
     * else a stone of weight of the difference of their weight will appear. This returns the
     * weight of that last stone if you keep smashing stones together.
     * <p>
     * O(nlogn) time, O(n) space
     * </p>
     *
     * @param stones integers representing stone weights
     * @return the last stone weight
     */
    public static int lastStoneWeight1(int[] stones) {
        // enqueue and dequeue in priority queue is O(log n)
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (Integer stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            queue.offer(queue.poll() - queue.poll());
        }
        return queue.poll();
    }
}
