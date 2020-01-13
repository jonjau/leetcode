# 2019-02-

# Say you have an array for which the ith element is the price of a given stock
# on day i.

# Design an algorithm to find the maximum profit. You may complete as many
# transactions as you like (i.e., buy one and sell one share of the stock
# multiple times).

# Note: You may not engage in multiple transactions at the same time (i.e., you
# must sell the stock before you buy again).

class Solution:
    def __call__(self):
        l1 = [7,1,5,3,6,4] #7
        l2 = [1,2,3,4,5] #4
        l3 = [7,6,4,3,1] #0
        ans = self.maxProfit2(l1)
        return ans

    # Greedy and verbose solution
    # greedy in that we are buying stocks and "holding" to sell for max profit
    def maxProfit1(self, prices: 'List[int]') -> 'int':
        if len(prices) <= 1:
            return 0

        total_profit = 0
        held_price = 0
        curr_index = 0
        # this extra variable (next_index) for curr_index + 1 doesn't seem to
        # affect performance much, but does improve readability
        next_index = 1 
        is_holding = False
        price_movement = 'none'

        while next_index < len(prices):
            price_difference = prices[next_index] - prices[curr_index]

            # price is going down
            if price_difference < 0:
                # if it wasn't down before, this is a turning point (a peak)
                if price_movement != 'down':
                    price_movement = 'down'
                    # sell the held stock if holding
                    if is_holding :
                        total_profit += (prices[curr_index] - held_price)
                        held_price = 0
                        is_holding = False

            # price is going up
            elif price_difference > 0:
                # same reasoning as above: this is a trough
                if price_movement != 'up':
                    price_movement = 'up'
                    # buy current stock if not holding
                    if not is_holding:
                        held_price = prices[curr_index]
                        is_holding = True

            # no movement
            else:
                if price_movement != 'none':
                    price_movement = 'none'

            curr_index += 1
            next_index += 1
        
        # sell if still holding by the end of the list, prices won't go higher
        if is_holding:
            total_profit += (prices[curr_index] - held_price)

        return total_profit

    # Same idea as above, but this time assuming buying and selling on the same
    # day is allowed. "Holding" a stock is not a thing in this solution. Here,
    # we just look for immediate positive differences in price: if the price
    # goes up in the next day (say day 2), then we take note of the profit as
    # if we bought on that day (day 1) and sold the next day (day 2). If the
    # price goes up again the day after that (day 3), then we take note of the
    # profit as if we bought on day 2 and sold on day 3, effectively buying and
    # selling on day 2.
    def maxProfit2(self, prices: 'List[int]') -> 'int':
        total_profit = 0
        for i in range(1, len(prices)):
            total_profit += max(prices[i] - prices[i-1], 0)
        return total_profit