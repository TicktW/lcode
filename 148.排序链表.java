import java.util.List;

/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 将链表一分为2
        ListNode fast = head.next; // TODO 如果不是head.next 则导致栈溢出 
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = head;

        // 对两端排序
        slow = sortList(slow);
        fast = sortList(fast);

        // 将排序好的两段合并
        return merge(fast, slow);
    }

    private  ListNode merge(ListNode l1, ListNode l2){
        ListNode dummpy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummpy;
        while (l1 != null && l2 != null) {
            if(l1.val > l2.val){
                curr.next = l2;
                l2 = l2.next;
            }else{
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        if(l1 != null){
            curr.next = l1;
        }
        if(l2 != null){
            curr.next = l2;
        }
        return dummpy.next;
    }
}
// @lc code=end

