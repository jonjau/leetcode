import time
import sys
sys.path.insert(0, '../tiq/array')
from remove_duplicates import Solution

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