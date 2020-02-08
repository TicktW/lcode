import java.util.List;

/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode fast = dummpy;
        ListNode slow = dummpy;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;

        ListNode pre = null;

        while(fast != null){
            ListNode temp = fast.next;
            fast.next = pre;
            pre = fast;
            fast = temp;
        }

        while(pre != null && head != null){
            if(pre.val != head.val){
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}
// @lc code=end

