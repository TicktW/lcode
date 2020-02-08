/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummpy = new ListNode(0);
        dummpy.next = head;
        ListNode cur = dummpy;
        while (cur != null && cur.next != null && cur.next.next != null) {
            if(cur.next.val == cur.next.next.val){
                ListNode temp = cur.next.next;
                while(temp != null && temp.next != null && temp.val == temp.next.val){
                    temp = temp.next;
                }
                cur.next = temp.next;
            }else{
                cur = cur.next;
            }
            
            
        }
        return dummpy.next;
    }
}
// @lc code=end

