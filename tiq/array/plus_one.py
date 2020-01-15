from typing import List

class Solution:
    def __call__(self):
        l1 = [4,3,2,1]
        return self.plus_one(l1)

    def plus_one(self, digits: List[int]) -> List[int]:
        return [int(d) for d in str(int(''.join([str(d) for d in digits]))+1)]

