/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
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
    public boolean hasCycle(ListNode head) {
        // fast 走两步 low 走一步 直到追上
        ListNode fast = head;
        ListNode low = head;

        while(fast != null){
            fast = fast.next;
            low = low.next;

            if(fast != null){
                fast = fast.next;
            }else{
                return false;
            }

            if(fast == low){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

