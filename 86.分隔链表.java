/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        ListNode leesNode = new ListNode(0);
        ListNode moreNode = new ListNode(0);
        ListNode moreNodeTemp = moreNode;
        ListNode leesNodeTemp = leesNode;

        while (head != null) {
            if(head.val >= x){
                moreNode.next = head;
                moreNode = head;
            }else{
                leesNode.next = head;
                leesNode = head;
            }
            head = head.next;
        }
        moreNode.next = null;
        leesNode.next = moreNodeTemp.next;
        return leesNodeTemp.next;
    }
}
// @lc code=end

