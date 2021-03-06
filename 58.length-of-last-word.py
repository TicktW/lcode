#
# @lc app=leetcode id=58 lang=python
#
# [58] Length of Last Word
#
# https://leetcode.com/problems/length-of-last-word/description/
#
# algorithms
# Easy (32.29%)
# Total Accepted:    289.4K
# Total Submissions: 896.3K
# Testcase Example:  '"Hello World"'
#
# Given a string s consists of upper/lower-case alphabets and empty space
# characters ' ', return the length of last word in the string.
# 
# If the last word does not exist, return 0.
# 
# Note: A word is defined as a character sequence consists of non-space
# characters only.
# 
# Example:
# 
# 
# Input: "Hello World"
# Output: 5
# 
# 
# 
# 
#
class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        right = len(s)-1
        res = 0

        while right >= 0 and s[right] == ' ':
            right -= 1

        while right >= 0 and s[right] != ' ':
            right -= 1
            res += 1

        return res

if __name__ == '__main__':
    print(Solution().lengthOfLastWord("a"))
