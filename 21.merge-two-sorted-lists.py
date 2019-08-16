#
# @lc app=leetcode id=21 lang=python
#
# [21] Merge Two Sorted Lists
#
# https://leetcode.com/problems/merge-two-sorted-lists/description/
#
# algorithms
# Easy (47.66%)
# Total Accepted:    606K
# Total Submissions: 1.3M
# Testcase Example:  '[1,2,4]\n[1,3,4]'
#
# Merge two sorted linked lists and return it as a new list. The new list
# should be made by splicing together the nodes of the first two lists.
# 
# Example:
# 
# Input: 1->2->4, 1->3->4
# Output: 1->1->2->3->4->4
# 
# 
#
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 is None and l2 is None:
            return l1
        if l1 is None and l2 is not None:
            return l2
        if l1 is not None and l2 is None:
            return l1

        if l1.val < l2.val:
            head_temp = l1
            l1 = l1.next
        else:
            head_temp = l2
            l2 = l2.next

        head = head_temp
        while l1.next and l2.next:
            if l1.val < l2.val:
                head.next = l1
                l1 = l1.next
            else:
                head.next = l2
                l2 = l2.next
            head = head.next

        if l1.next:
            l2.next = l1.next
        if l2.next:
            l1.next = l2.next
        return head_temp
