# 2019-03-01

# Given an array, rotate the array to the right by k steps, where k is
# non-negative.

class Solution:
    def __call__(self):
        # l1 k1 -> [5,6,7,1,2,3,4]
        l1 = [1,2,3,4,5,6,7]
        k1 = 3
        # [3,99,-1,-100]
        l2 = [-1,-100,3,99]
        k2 = 2

        self.rotate(l1, k1)
        print(l1)
        return l1

    def rotate(self, nums: 'List[int]', k: 'int') -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        