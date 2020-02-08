/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        // 虚拟头节点
        ListNode dummpy = new ListNode(Integer.MIN_VALUE);
        dummpy.next = head;
        // 遍历链表
        ListNode cur = head;
        ListNode tail = dummpy;
        // 节点和有序的部分比较
        while(cur != null){
            if(cur.val >= tail.val){
                cur = cur.next;
                tail = tail.next;
            }else{
                ListNode temp = dummpy;
                while(temp.next.val < cur.val){
                    temp = temp.next;
                }
                tail.next = cur.next;
                cur.next = temp.next;
                temp.next = cur;
                cur = tail.next;
            }
        }
        // 若大于等于有序的最后一个，则直接跳过
        // 若小于有序的最后一个，则从头开始比较，找到合适的位置插入
        return dummpy.next;
    }
}
// @lc code=end

