#
# @lc app=leetcode id=7 lang=python
#
# [7] Reverse Integer
#
# https://leetcode.com/problems/reverse-integer/description/
#
# algorithms
# Easy (25.33%)
# Total Accepted:    710.4K
# Total Submissions: 2.8M
# Testcase Example:  '123'
#
# Given a 32-bit signed integer, reverse digits of an integer.
# 
# Example 1:
# 
# 
# Input: 123
# Output: 321
# 
# 
# Example 2:
# 
# 
# Input: -123
# Output: -321
# 
# 
# Example 3:
# 
# 
# Input: 120
# Output: 21
# 
# 
# Note:
# Assume we are dealing with an environment which could only store integers
# within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
# this problem, assume that your function returns 0 when the reversed integer
# overflows.
# 
#
class Solution(object):
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """

        flag = 1 if x > 0 else 0
        if not flag:
            x = -x

        temp = 0
        while x != 0:
            temp = temp*10 + x%10
            x = x//10

        if temp < -2**31 or temp > 2**31-1:
            return 0
        return temp if flag else -temp
