package tiq.array;

/**
 * BuySellStock2
 */
public class BuySellStock2 {

    public static int run() {
        int[] l1 = {7,1,5,3,6,4}; //7
        int[] l2 = {1,2,3,4,5}; //4
        int[] l3 = {7,6,4,3,1}; //0

        return buySellStock2(l1);
    }

    // O(n) time, O(1) space
    public static int buySellStock2(int[] prices) {
        int i = 0;
        int valley = 0;
        int peak = 0;
        int profit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i+1]) {
                i++;
            }
            valley = prices[i];

            while (i < prices.length - 1 && prices[i] <= prices[i+1]) {
                i++;
            }
            peak = prices[i];
            profit += peak - valley;
        }
        return profit;
    }
}