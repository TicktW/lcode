#
# @lc app=leetcode id=14 lang=python
#
# [14] Longest Common Prefix
#
# https://leetcode.com/problems/longest-common-prefix/description/
#
# algorithms
# Easy (33.59%)
# Total Accepted:    479.5K
# Total Submissions: 1.4M
# Testcase Example:  '["flower","flow","flight"]'
#
# Write a function to find the longest common prefix string amongst an array of
# strings.
# 
# If there is no common prefix, return an empty string "".
# 
# Example 1:
# 
# 
# Input: ["flower","flow","flight"]
# Output: "fl"
# 
# 
# Example 2:
# 
# 
# Input: ["dog","racecar","car"]
# Output: ""
# Explanation: There is no common prefix among the input strings.
# 
# 
# Note:
# 
# All given inputs are in lowercase letters a-z.
# 
#
class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """

        if "" in strs or not strs:
            return ""

        prev = None
        while strs:
            word = strs.pop()
            if prev:
                # compare prefix
                min_len = len(word) if len(word)<len(prev) else len(prev)
                for i in range(min_len):
                    if prev[i] != word[i]:
                        break
                else:
                    i += 1
                if i == 0:
                    return ""
                prev = word[:i]
            else:
                prev = word
        else:
            return prev

if __name__ == "__main__":
    solu = Solution()
    solu.longestCommonPrefix(['flower', 'flow', 'flight'])
