/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        if(head == null){
            return;

        }
        // 获得中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;

        // 反转从slow开始
        ListNode dummpy = new ListNode(0);
        ListNode next;
        while (fast!= null) {
            next = fast.next;
            fast.next = dummpy.next;
            dummpy.next = fast;
            fast = next;
        }
        // 合并两个链表
        ListNode curr = dummpy.next;
        while (curr != null) {
            next = curr.next;
            curr.next = head.next;
            head.next = curr;

            head = curr.next;
            curr = next;
        }

        head = dummpy.next;
    }
}
// @lc code=end

