/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ListNode tail = head;
        // ListNode old = head;
        // int i = 1;
        // while (head.next != null) {
        //     if(i++ > n)
        //      tail = tail.next;
        //     head = head.next;
        // }
        // tail.next = tail.next.next;
        // return old;
        ListNode fast = head;
        ListNode slow = head;
        // fast go n first
        for (int i = 1; i <= n; i++) {
            if(fast.next != null){
                fast = fast.next;
            }else{
                // if n > num.length then return null
                return head.next;
            }
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
// @lc code=end

