#
# @lc app=leetcode id=67 lang=python
#
# [67] Add Binary
#
# https://leetcode.com/problems/add-binary/description/
#
# algorithms
# Easy (40.09%)
# Total Accepted:    328.2K
# Total Submissions: 817.3K
# Testcase Example:  '"11"\n"1"'
#
# Given two binary strings, return their sum (also a binary string).
# 
# The input strings are both non-empty and contains only characters 1 or 0.
# 
# Example 1:
# 
# 
# Input: a = "11", b = "1"
# Output: "100"
# 
# Example 2:
# 
# 
# Input: a = "1010", b = "1011"
# Output: "10101"
# 
#
# class Solution(object):
#     def addBinary(self, a, b):
#         """
#         :type a: str
#         :type b: str
#         :rtype: str
#         """
#         return format(int(a, 2) + int(b, 2), "b")

class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        if len(a) == 0:
            return b
        if len(b) == 0:
            return a

        res = ''

        i, j, carray = len(a)-1, len(b)-1, 0
        while i >= 0 or j >= 0:
            sum_ = carray
            if i >= 0:
                sum_ += int(a[i])
            if j >= 0:
                sum_ += int(b[j])
            carray = sum_ / 2
            res += str(sum_ % 2)
            i -= 1
            j -= 1

        if carray > 0:
            res += str(carray)

        return res[::-1]

