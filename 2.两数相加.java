import java.util.Stack;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null)  return l2;
        if(l2 == null && l1 != null)  return l1;
        if(l1 == null && l2 == null) return l1;
        
        ListNode head1 = l1;
        ListNode head2 = l2;

        // add val in l1 and l2
        while (true) {
            // if(l1.next == null && l2.next != null){
            //     l1.val = l1.val + l2.val;
            //     break;
            // }
            // if(l2.next == null){
            //     break;
            // }
            l1.val = l1.val + l2.val;

            if(l1.next == null | l2.next == null){
                break;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        if(l2.next != null) {
            l1.next = l2.next;
        }

        // if(l1.next != null) {
        //     l1.next = l2.next;
        // }

        l1 = head1;
        int carry = 0;
        int s = 0;
        // travel l1
        while (l1.next != null ) {
            s = l1.val % 10 + carry;
            carry = (l1.val + carry)/10;
            // carry = (l1.val+carry) > 9 ? 1 : 0;
            l1.val = s % 10;
            l1 = l1.next;        
        }
        
        s = l1.val % 10 + carry;
        
        // carry = (l1.val+carry) > 9 ? 1 : 0;
        carry = (l1.val + carry)/10;
        l1.val = s % 10;
        if(carry==1) l1.next = new ListNode(1);
        return head1;
    }
}
// @lc code=end

