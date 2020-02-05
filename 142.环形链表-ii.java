/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;

        while(fast != null){
            fast = fast.next;
            low = low.next;

            if(fast == null){
                return null;
            }

            fast = fast.next;

            if(fast == low){
                while(head != fast){
                    head = head.next;
                    fast = fast.next;
                }
                return head;
            }
        }
        return null;
    }
}
// @lc code=end

