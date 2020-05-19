package tdc2.wk3;

import java.util.Stack;

/**
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span
 * of that stock's price for the current day.
 * <p>
 * The span of the stock's price today is defined as the maximum number of consecutive days
 * (starting from today and going backwards) for which the price of the stock was less than or equal
 * to today's price.
 * <p>
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85],
 * then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["StockSpanner","next","next","next","next","next","next","next"],
 * [[],[100],[80],[60],[70],[60],[75],[85]]
 * Output: [null,1,1,1,2,1,4,6]
 * Explanation:
 * First, S = StockSpanner() is initialized.  Then:
 * S.next(100) is called and returns 1,
 * S.next(80) is called and returns 1,
 * S.next(60) is called and returns 1,
 * S.next(70) is called and returns 2,
 * S.next(60) is called and returns 1,
 * S.next(75) is called and returns 4,
 * S.next(85) is called and returns 6.
 * <p>
 * Note that (for example) S.next(75) returned 4, because the last 4 prices
 * (including today's price of 75) were less than or equal to today's price.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
 * There will be at most 10000 calls to StockSpanner.next per test case.
 * There will be at most 150000 calls to StockSpanner.next across all test cases.
 * The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
 */
public class OnlineStockSpanner {
    static class StockSpanner {
        // weighted stack of decreasing elements
        Stack<Integer> prices, spans;

        public StockSpanner() {
            prices = new Stack<>();
            spans = new Stack<>();
        }

        /**
         * stack approach
         * @param price the current ("today") price of the stock
         * @return the number of consecutive days including this one where the stock price was
         *         equal to or less than today.
         */
        public int next(int price) {
            // minimum span is 1
            int span = 1;
            while (!prices.isEmpty() && prices.peek() <= price) {
                prices.pop();
                span += spans.pop();
            }
            prices.push(price);
            spans.push(span);
            return span;
        }
    }

    public static void run() {
        StockSpanner stockSpanner = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        for (int price : prices) {
            int ans = stockSpanner.next(price);
            System.out.println(String.valueOf(price) + ' ' + ans);
        }
    }
}
