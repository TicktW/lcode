#
# @lc app=leetcode id=1 lang=python
#
# [1] Two Sum
#
# https://leetcode.com/problems/two-sum/description/
#
# algorithms
# Easy (44.23%)
# Total Accepted:    1.8M
# Total Submissions: 4.2M
# Testcase Example:  '[2,7,11,15]\n9'
#
# Given an array of integers, return indices of the two numbers such that they
# add up to a specific target.
#
# You may assume that each input would have exactly one solution, and you may
# not use the same element twice.
#
# Example:
#
#
# Given nums = [2, 7, 11, 15], target = 9,
#
# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].
#
#
#
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        v_k_dict = {}
        for k,v in enumerate(nums):
            v_k_dict[v] = k

        for k,v in enumerate(nums):
            num2_index = v_k_dict.get(target-v)
            # the two index can't repeate
            if num2_index and num2_index != k:
                return [k, num2_index]
