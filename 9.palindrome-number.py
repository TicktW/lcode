#
# @lc app=leetcode id=9 lang=python
#
# [9] Palindrome Number
#
# https://leetcode.com/problems/palindrome-number/description/
#
# algorithms
# Easy (43.52%)
# Total Accepted:    597.2K
# Total Submissions: 1.4M
# Testcase Example:  '121'
#
# Determine whether an integer is a palindrome. An integer is a palindrome when
# it reads the same backward as forward.
# 
# Example 1:
# 
# 
# Input: 121
# Output: true
#
#
# Example 2:
#
#
# Input: -121
# Output: false
# Explanation: From left to right, it reads -121. From right to left, it
# becomes 121-. Therefore it is not a palindrome.
#
#
# Example 3:
#
#
# Input: 10
# Output: false
# Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
#
#
# Follow up:
#
# Coud you solve it without converting the integer to a string?
#
#
class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False

        old_x = x
        new_x = 0
        while x > 0:
            new_x = new_x*10 + x % 10
            x = x // 10

        print(new_x)
        print(x)

        return True if new_x == old_x else False

# if __name__ == '__main__':
#     print(Solution().isPalindrome(121))
