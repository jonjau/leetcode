# 2019-02-06

# Given a sorted array nums, remove the duplicates in-place such that each
# element appear only once and return the new length.

# Do not allocate extra space for another array, you must do this by modifying
# the input array in-place with O(1) extra memory.

class Solution:
    def __call__(self):
        l1 = [1,1,2,2,3,3,3,4,7,19]
        return self.removeDuplicates1b(l1)

    def removeDuplicates1a(self, nums: 'List[int]') -> 'int':
        if len(nums) == 0:
            return 0
        pointer = nums[0]
        n = 0
        # i starts from the second element
        for i in range(1, len(nums)):
            if nums[i] != pointer:
                n += 1
                nums[n] = nums[i]
                pointer = nums[n]
        return n + 1

    def removeDuplicates1b(self, nums: 'List[int]') -> 'int':
        if len(nums) == 0:
            return 0
        anchor_index = 0
        # i starts from the second element, anchor_index lays out the new vector
        # by copying the unique elements (non-consecutive, as array is sorted)
        for i in range(1, len(nums)):
            if nums[i] != nums[anchor_index]:
                anchor_index += 1
                nums[anchor_index] = nums[i]
        # watch out for off-by-one error, we are returning new size
        return anchor_index + 1