/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // if head is null or list len < 2 , return node
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = new ListNode(0);
        ListNode curr = head;
        // get the new head
        ListNode res = head.next;
        // there are three pointers should be changed
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = curr;
            prev.next = temp;
            prev = curr;
            curr = curr.next;
        }
        return res;
    }
}
// @lc code=end

