#
# @lc app=leetcode id=35 lang=python
#
# [35] Search Insert Position
#
# https://leetcode.com/problems/search-insert-position/description/
#
# algorithms
# Easy (41.09%)
# Total Accepted:    439.7K
# Total Submissions: 1.1M
# Testcase Example:  '[1,3,5,6]\n5'
#
# Given a sorted array and a target value, return the index if the target is
# found. If not, return the index where it would be if it were inserted in
# order.
# 
# You may assume no duplicates in the array.
# 
# Example 1:
# 
# 
# Input: [1,3,5,6], 5
# Output: 2
# 
# 
# Example 2:
# 
# 
# Input: [1,3,5,6], 2
# Output: 1
# 
# 
# Example 3:
# 
# 
# Input: [1,3,5,6], 7
# Output: 4
# 
# 
# Example 4:
# 
# 
# Input: [1,3,5,6], 0
# Output: 0
# 
# 
#
class Solution(object):
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums_len = len(nums)
        if nums_len == 0:
            return 0

        if target <= nums[0]:
            return 0
        if target > nums[-1]:
            return nums_len
        if target == nums[-1]:
            return nums_len - 1

        low = 0
        high = nums_len-1

        while low < high:
            if (high - low) // 2 > 0:
                mid = (low+high) // 2
                if nums[mid] > target:
                    high = mid
                elif nums[mid] == target:
                    return mid
                else:
                    low = mid
            else:
                return high
        return high

if __name__ == '__main__':
    Solution().searchInsert([2,7,8,9,10], 9)
