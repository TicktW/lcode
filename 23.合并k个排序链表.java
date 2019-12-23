import java.security.spec.MGF1ParameterSpec;
import java.util.List;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        ListNode head = lists[0]; 
        // ListNode tail = head;
        // int minval = lists[0].val;
        // int minVal=lists[0].val;
        // int minIndex=0;
        // for (int i = 0; i < lists.length; i++) {
        //     if(lists[i] == null) continue;
        //     if(lists[i].val < minVal){
        //         minVal = lists[i].val;
        //         minIndex = i;
        //     }
        // }
        for (int i = 1; i< lists.length; i++) {
             head = merge(head, lists[i]);
        }
        // head = merge(lists[2], lists[1]);
        return head;
        
    }

    private ListNode merge(ListNode listprev, ListNode listnext) {
        if(listprev == null){
            return listnext;
        }
        if(listnext == null){
            return listprev;
        }
        ListNode head;
        if (listprev.val < listnext.val) {
            head = listprev;
            listprev.next = merge(listprev.next, listnext);
        }else{
            head = listnext;
            listnext.next = merge(listprev, listnext.next);
        }
        return head;
    }
}
// @lc code=end

