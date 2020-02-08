/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        
        ListNode curr = head;
        // 计算链表节点个数
        // 将curr指针指向最后一个节点
        int i;
        for (i = 1; curr.next != null; i++) {
            curr = curr.next;
        }
        // 连接成循环链表
        curr.next = head;
        // 找到新的尾部节点和头节点
        curr = head;

        for (int j = 1; j < i- k%i; j++) {
            curr = curr.next;
        }
        // 新头节点
        head = curr.next;
        // 新尾节点
        curr.next = null;

        return head;

    }
}
// @lc code=end

