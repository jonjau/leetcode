import time
from remove_duplicates import *
# from buy_sell_stock_2 import *

def main():
    s = Solution()
    start_time = time.time()
    for _ in range(100000):
        s()
    end_time = time.time()
    print("--- %f seconds ---" % (end_time - start_time))
    return

if __name__ == "__main__":
    main()