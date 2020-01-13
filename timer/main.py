import time
import sys
sys.path.insert(0, '../tiq/array')
from buy_sell_stock_2 import Solution

def main():
    s = Solution()
    print(s())
    start_time = time.time()
    for _ in range(100000):
        s()
    end_time = time.time()
    print("--- %f seconds ---" % (end_time - start_time))
    return

if __name__ == "__main__":
    main()